package com.literalura.challenge.view;

import com.literalura.challenge.controller.MenuController;

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

    private void showOptions() {
        System.out.println("LISTA DE OPCIONES:");
        options.forEach(System.out::println);
    }

    private void cycle() {
        String selectedOption = "";
        while (!selectedOption.equals("3")) {
            showOptions();
            selectedOption = scanner.nextLine();
            menuController.controllerProxy(selectedOption);
        }
    }

    public void run() {
        cycle();
    }
}
