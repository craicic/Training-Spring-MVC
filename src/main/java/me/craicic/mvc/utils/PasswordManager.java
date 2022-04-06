package me.craicic.mvc.utils;

import me.craicic.mvc.repository.SecretRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PasswordManager {

    private static final Logger logger = LoggerFactory.getLogger(PasswordManager.class);


    private static TextEncryptor textEncryptor;

    private final SecretRepository secretRepo;

    public PasswordManager(SecretRepository secretRepo) {
        this.secretRepo = secretRepo;
    }

    public String decodePassword(String encoded) {
        logger.info("encoded string : " + encoded);
        return textEncryptor.decrypt(encoded);

    }

    public void createTextEncryptor(String mainUsername, String mainPassword) {
        String salt = secretRepo.retrieveHashByUserName(mainUsername);
        textEncryptor = Encryptors.text("azerty", salt);
    }
}
