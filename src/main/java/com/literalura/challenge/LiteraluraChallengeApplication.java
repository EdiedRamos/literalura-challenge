package com.literalura.challenge;

import com.literalura.challenge.service.APIConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraChallengeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String allBooksUrl = "https://gutendex.com/books/";
        String data = APIConsumer.makeRequest(allBooksUrl);
        System.out.println("Information: " + data);
    }
}
