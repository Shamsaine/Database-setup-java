package com.cmam.cmam;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmamApplication {

    static {
        // Load .env file
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
    }

    public static void main(String[] args) {
        SpringApplication.run(CmamApplication.class, args);
    }
}
