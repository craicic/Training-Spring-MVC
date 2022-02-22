package me.craicic.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Override
    public void run(ApplicationArguments args) {
        logger.info("Running webapp at http://localhost:8080/home");
    }
}
