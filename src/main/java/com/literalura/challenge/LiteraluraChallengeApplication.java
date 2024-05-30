package com.literalura.challenge;

import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.dto.BookData;
import com.literalura.challenge.service.GutendexRequest;
import com.literalura.challenge.service.JSONConverter;
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
        String json = GutendexRequest.searchByTitle("");
        BookData data = new JSONConverter().toObjectWithBuilder(json, BookData.class, new BookDeserializer());
        System.out.println("Information: " + data);
    }
}
