package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class V10__symmetric_encode extends BaseJavaMigration {

    private static final Logger logger = LoggerFactory.getLogger(V10__symmetric_encode.class);

    @Override
    public void migrate(Context context) throws Exception {

        Connection connection = context.getConnection();
        Statement stUser = connection.createStatement();
        Statement stEntry = connection.createStatement();
        ResultSet userRs = stUser.executeQuery(" SELECT id, main_password FROM app_user ");

        final PreparedStatement psPersistNewSalt = connection.prepareStatement(
                "INSERT INTO secret (id, user_id, salt) VALUES (?, ? ,?)");

        final PreparedStatement psPersistEncodedPwD = connection.prepareStatement(
                "UPDATE entry SET password = ? WHERE id = ? ");

        final PreparedStatement psPersistEncodedMainPwd = connection.prepareStatement(
                "UPDATE app_user SET main_password = ? WHERE id = ? ");

        int i = 1;
        while (userRs.next()) {

            int userId = userRs.getInt("id");
            String mainPassword = userRs.getString("main_password");

            psPersistNewSalt.setInt(1, i);
            psPersistNewSalt.setInt(2, userId);
            String hash = KeyGenerators.string().generateKey();
            psPersistNewSalt.setString(3, hash);
            psPersistNewSalt.execute();

            i++;

            final PreparedStatement psSelectEntres = connection.prepareStatement(
                    "SELECT id, password FROM entry WHERE user_id = ? ");
            psSelectEntres.setInt(1, userId);
            ResultSet entryRs = psSelectEntres.executeQuery();

            while (entryRs.next()) {
                int entryId = entryRs.getInt("id");
                String password = entryRs.getString("password");

                logger.info(mainPassword + " hash:" + hash);
                TextEncryptor encryptor = Encryptors.text(mainPassword, hash);
                String encryptedPwd = encryptor.encrypt("qwertz");
                logger.info("Encryptors did :" + encryptedPwd);
                psPersistEncodedPwD.setString(1, encryptedPwd);
                psPersistEncodedPwD.setInt(2, entryId);
                psPersistEncodedPwD.execute();
            }
            entryRs.close();

            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

            try {
                bcrypt.upgradeEncoding(mainPassword);
                logger.debug("Password looks already encoded : " + mainPassword);
            } catch (Exception e) {
                logger.warn("Password was raw : " + mainPassword);
                String bCryptMainPwd = bcrypt.encode(mainPassword);

                psPersistEncodedMainPwd.setString(1, bCryptMainPwd);
                psPersistEncodedMainPwd.setInt(2, userId);
                psPersistEncodedMainPwd.execute();
            }
        }

        userRs.close();
        psPersistNewSalt.close();
        psPersistEncodedPwD.close();
        psPersistEncodedMainPwd.close();

    }
}
