package util.scanner;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        App app = new App();
        byte winner;
        char[] box = new char[9];

        System.out.println("Enter box number to select. Enjoy!\n");
        app.printBox(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'});

        winner = app.startGame(box);

        app.printWinner(winner);
    }

    private byte startGame(char[] box){
        byte winner = 0;
        while (winner == 0) {
            this.scanPlayerInput(box);

            if(this.checkWinnStatus(box, 'X')){
                winner = 1;
                return winner;
            }

            if(!this.checkBoxAvailable(box)){
                winner = 3;
                return winner;
            }

            this.moveRandomPlayer(box);

            if(this.checkWinnStatus(box,'O')){
                winner = 2;
            }
            this.printBox(box);
        }
        return winner;
    }

    private void printBox(char[] box){
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private boolean checkBoxAvailable(char[] box){
        for(char c : box){
            if (c != 'X' && c != 'O')
                return true;
        }
        return false;
    }

    private boolean checkWinnStatus(char[] box, char playerStatus){
        return (box[0]==playerStatus && box[1]==playerStatus && box[2]==playerStatus) ||
                (box[3]==playerStatus && box[4]==playerStatus && box[5]==playerStatus) ||
                (box[6]==playerStatus && box[7]==playerStatus && box[8]==playerStatus) ||
                (box[0]==playerStatus && box[3]==playerStatus && box[6]==playerStatus) ||
                (box[1]==playerStatus && box[4]==playerStatus && box[7]==playerStatus) ||
                (box[2]==playerStatus && box[5]==playerStatus && box[8]==playerStatus) ||
                (box[0]==playerStatus && box[4]==playerStatus && box[8]==playerStatus) ||
                (box[2]==playerStatus && box[4]==playerStatus && box[6]==playerStatus);
    }

    private void printWinner(byte winner){
        if(winner == 1){
            System.out.println("You won the game!");
        } else if(winner == 2){
            System.out.println("You lost the game!");
        } else if(winner == 3){
            System.out.println("It's a draw!");
        }
        System.out.println("Created by Shreyas Saha. Thanks for playing!");
    }

    private void scanPlayerInput(char[] box){
        Scanner scan = new Scanner(System.in);
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (isCellEmpty(box, input)) {
                    box[input - 1] = 'X';
                    return;
                }
                else
                    System.out.println("That one is already in use. Enter another.");
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }
    private void moveRandomPlayer(char[] box){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (isCellEmpty(box, rand)) {
                box[rand - 1] = 'O';
                return;
            }
        }
    }
    private boolean isCellEmpty(char[] box, int i){
        return box[i - 1] != 'X' && box[i - 1] != 'O';
    }
}