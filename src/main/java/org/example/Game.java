package org.example;

public class Game {
    Field field;
    public int score = 0;
    Game(int size) {
        field = new Field(size);
    }

    int getScore() {
        return score;
    }

    void action(Action action) {
        switch (action) {
            case LEFT:
                field.actLeft();
                break;
            case RIGHT:
                field.actRight();
                break;
            case UP:
                field.actUp();
                break;
            case DOWN:
                field.actDown();
                break;
            case NOACTION:
                break;
        }
    }
    void play() {
        while (true) {
            field.initField();
            ConsoleRenderer.renderField(field);
            Action action = ConsoleRenderer.renderInterface(score);
            action(action);
            score += 1;
            if(!field.setRandomBlock()) {
                ConsoleRenderer.renderLose();
                return;
            }
        }
    }

    int menu() {
        while (true) {
            int size = ConsoleRenderer.renderMenu();
            if (size > 0 && size < 10) {
                field.setSize(size);
                return 1;
            } else {
                return -1;
            }
        }
    }

}
