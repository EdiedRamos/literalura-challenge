package com.literalura.challenge.view;

import com.literalura.challenge.controller.MenuController;
import com.literalura.challenge.dto.BookDTO;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<String> options;
    private final Scanner scanner;
    private final MenuController menuController;

    public Menu(MenuController menuController) {
        options = List.of("[1] Buscar libro por título"
                , "[2] Lista de todos los libros"
                , "[3] Salir");
        scanner = new Scanner(System.in);
        this.menuController = menuController;
    }

    private void searchTitleMenu() {
        System.out.println("Ingrese el nombre del libro: ");
        String bookTitle = scanner.nextLine();
        try {
            BookDTO bookFound = menuController.searchBookByTitle(bookTitle);
            System.out.println(bookFound);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void optionsProxy(String option) {
        switch (option) {
            case "1" -> {
                searchTitleMenu();
            }
            case "2" -> {
                System.out.println("2 - En progreso");
            }
            default -> {
                System.out.println("Opcion no reconocida");
            }
        }
    }

    private void showOptions() {
        System.out.println("LISTA DE OPCIONES:");
        options.forEach(System.out::println);
    }

    private void cycle() {
        String selectedOption = "";
        while (!selectedOption.equals("3")) {
            showOptions();
            selectedOption = scanner.nextLine();
            optionsProxy(selectedOption);
        }
    }

    public void run() {
        cycle();
    }
}
