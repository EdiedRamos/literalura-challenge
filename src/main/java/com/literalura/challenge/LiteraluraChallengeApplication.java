package com.literalura.challenge;

import com.literalura.challenge.controller.MenuController;
import com.literalura.challenge.service.BookService;
import com.literalura.challenge.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraChallengeApplication implements CommandLineRunner {

    @Autowired
    private MenuController menuController;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Menu menu = new Menu(menuController);
        menu.run();
    }
}
