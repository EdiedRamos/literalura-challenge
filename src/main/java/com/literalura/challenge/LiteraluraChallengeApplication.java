package com.literalura.challenge;

import com.literalura.challenge.controller.MenuController;
import com.literalura.challenge.model.Book;
import com.literalura.challenge.service.BookService;
import com.literalura.challenge.service.GutendexRequest;
import com.literalura.challenge.view.Menu;
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
        BookService bookService = new BookService();
        MenuController menuController = new MenuController(bookService);
        Menu menu = new Menu(menuController);
        menu.run();
    }
}
