package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3);
        while (true) {
            if (game.menu() == -1) break;
            game.play();
        }
    }
}