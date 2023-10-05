package org.example;

import java.util.Scanner;

import org.example.Action.*;

// print 2048 in console
public class ConsoleRenderer {
    private static Scanner scanner = new Scanner(System.in);
    // print field
    public static void renderField(Field field) {
        Block[][] blocks = field.getField();
        for (int i = 0; i < field.size; ++i) {
            for (int j = 0; j < field.size; ++j) {
                System.out.print(blocks[i][j].getValue() + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // print interface
    public static Action renderInterface(int score) {
        System.out.println("0. Влево");
        System.out.println("1. Вправо");
        System.out.println("2. Вверх");
        System.out.println("3. Вниз");
        System.out.println("4. Выйти");
        System.out.println("Очки: " + score);
        System.out.println("------------------");

        int input = scanner.nextInt();
        final Action[] actions = Action.values();
        try {
            Action action = actions[input];
            return action;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("------------------");
            System.out.println("Неправильное ввод!!!");
            System.out.println("------------------");
            return Action.NOACTION;
        }
    }

    public static void renderLose() {
        System.out.println("Вы проиграли!");
    }

    public static int renderMenu() {
        System.out.println("Выберите размер поля:");
        int size = scanner.nextInt();

        return size;
    }

}
