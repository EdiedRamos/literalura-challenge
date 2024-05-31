package com.literalura.challenge.controller;

public class MenuController {
    public void controllerProxy(String option) {
        switch (option) {
            case "1" -> {
                System.out.println("1 - En progreso");
            }
            case "2" -> {
                System.out.println("2 - En progreso");
            }
            default -> {
                System.out.println("Opcion no reconocida");
            }
        }
    }
}
