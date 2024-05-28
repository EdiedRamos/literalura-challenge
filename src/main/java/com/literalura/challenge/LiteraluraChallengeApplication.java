package com.literalura.challenge;

import com.literalura.challenge.deserialization.BookDeserializer;
import com.literalura.challenge.model.Book;
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
//        String allBooksUrl = "https://gutendex.com/books/";
//        String data = APIConsumer.makeRequest(allBooksUrl);
//        System.out.println("Information: " + data);
        String jsonString = "{\n" +
                "    \"id\": 63848,\n" +
                "    \"title\": \"Della peste e della pubblica amministrazione sanitaria\",\n" +
                "    \"authors\": [\n" +
                "        {\n" +
                "            \"name\": \"Frari, A. A. (Angelo Antonio)\",\n" +
                "            \"birth_year\": 1780,\n" +
                "            \"death_year\": 1865\n" +
                "        }\n" +
                "    ],\n" +
                "    \"translators\": [],\n" +
                "    \"subjects\": [\n" +
                "        \"Plague\"\n" +
                "    ],\n" +
                "    \"bookshelves\": [],\n" +
                "    \"languages\": [\n" +
                "        \"it\"\n" +
                "    ],\n" +
                "    \"copyright\": false,\n" +
                "    \"media_type\": \"Text\",\n" +
                "    \"formats\": {\n" +
                "        \"text/plain; charset=us-ascii\": \"https://www.gutenberg.org/ebooks/63848.txt.utf-8\",\n" +
                "        \"text/html\": \"https://www.gutenberg.org/ebooks/63848.html.images\",\n" +
                "        \"text/html; charset=utf-8\": \"https://www.gutenberg.org/files/63848/63848-h/63848-h.htm\",\n" +
                "        \"application/epub+zip\": \"https://www.gutenberg.org/ebooks/63848.epub3.images\",\n" +
                "        \"application/x-mobipocket-ebook\": \"https://www.gutenberg.org/ebooks/63848.kf8.images\",\n" +
                "        \"text/plain; charset=utf-8\": \"https://www.gutenberg.org/files/63848/63848-0.txt\",\n" +
                "        \"application/rdf+xml\": \"https://www.gutenberg.org/ebooks/63848.rdf\",\n" +
                "        \"image/jpeg\": \"https://www.gutenberg.org/cache/epub/63848/pg63848.cover.medium.jpg\",\n" +
                "        \"application/octet-stream\": \"https://www.gutenberg.org/cache/epub/63848/pg63848-h.zip\"\n" +
                "    },\n" +
                "    \"download_count\": 94\n" +
                "}";
        JSONConverter converter = new JSONConverter();
        Book book = converter.toObjectWithBuilder(jsonString, Book.class, new BookDeserializer());
        System.out.println(book);
    }
}
