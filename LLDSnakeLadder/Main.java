package lld_practice.LLDSnakeLadder;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cells ");
        int boardSize = sc.nextInt();

        System.out.println("Enter number of snakes ");
        int numSnakes = sc.nextInt();

        System.out.println("Enter number of ladders ");
        int numLadders = sc.nextInt();

        Game obj = new Game(boardSize, numSnakes, numLadders);
        obj.startGame();
    }
}

