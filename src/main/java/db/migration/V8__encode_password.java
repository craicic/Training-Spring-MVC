package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class V8__encode_password extends BaseJavaMigration {

    private static final Logger logger = LoggerFactory.getLogger(V8__encode_password.class);

    @Override
    public void migrate(Context context) throws Exception {

        Connection connection = context.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, main_password FROM app_user");
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        final PreparedStatement psEncoded = connection.prepareStatement("UPDATE app_user SET main_password = ? WHERE id = ? ");

        while (rs.next()) {
            int id = rs.getInt("id");
            String password = rs.getString("main_password");
            try {
                bcrypt.upgradeEncoding(password);
                logger.debug("Password looks already encoded : " + password);
            } catch (Exception e) {
                logger.warn("Password was raw : " + password);
                password = bcrypt.encode(password);
                psEncoded.setString(1, password);
                psEncoded.setInt(2, id);
                psEncoded.execute();
            }
        }
        rs.close();
        psEncoded.close();
        st.close();
    }
}
