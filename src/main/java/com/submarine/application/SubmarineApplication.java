package com.submarine.application;

import java.io.IOException;
import java.util.Scanner;

public class SubmarineApplication {

    private static boolean executing = true;

    public static void main(String[] args) throws IOException {

        startUI();

        while(executing) {
            //MOVER PARA A LINHA DE CIMA CASO NAO QUEIRA REINICIAR O SUBMARINO TDAS AS VEZES
            SubmarineController controller = new SubmarineController();
            navigate(controller);
        }
    }

    private static void startUI() {
        showLogo();
        showTitle();
    }

    private static void showLogo() {
        String logo = "    ___\n" +
                "             /   |\n" +
                "   ,--------'    '--------..._,.\n" +
                "  (                          _--+\n" +
                "   `----------------------''' `'";

        System.out.println(logo);
    }

    private static void showTitle() {
        String title = "     _______. __    __  .______   .___  ___.      ___      .______       __  .__   __.   ______   \n" +
                "    /       ||  |  |  | |   _  \\  |   \\/   |     /   \\     |   _  \\     |  | |  \\ |  |  /  __  \\  \n" +
                "   |   (----`|  |  |  | |  |_)  | |  \\  /  |    /  ^  \\    |  |_)  |    |  | |   \\|  | |  |  |  | \n" +
                "    \\   \\    |  |  |  | |   _  <  |  |\\/|  |   /  /_\\  \\   |      /     |  | |  . `  | |  |  |  | \n" +
                ".----)   |   |  `--'  | |  |_)  | |  |  |  |  /  _____  \\  |  |\\  \\----.|  | |  |\\   | |  `--'  | \n" +
                "|_______/     \\______/  |______/  |__|  |__| /__/     \\__\\ | _| `._____||__| |__| \\__|  \\______/  \n" +
                "                                                                                                 ";

        System.out.println(title);
    }

    private static void showLabel() {
        String label = "Digite os comandos abaixo: (:q! para sair)";
        System.out.println("\n\n" + label);

    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void navigate(SubmarineController controller) throws IOException {
        showLabel();
        String input = getInput();
        if(input.equals(":q!")) {
            executing = false;
        } else {
            String output = controller.navigate(input.toUpperCase());
            showOutput(output);
        }
    }

    private static void showOutput(String output) {
        System.out.println(output);
    }
}
