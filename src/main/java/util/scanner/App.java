package util.scanner;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Game game = new Game();
        byte winner;
        char[] box = new char[9];

        game.initGame();


        winner = game.startGame(box);

        game.printWinner(winner);
    }


}