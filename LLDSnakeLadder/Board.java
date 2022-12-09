package lld_practice.LLDSnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {

        initializeCells(boardSize);
        addSnakes(numberOfSnakes);
        addLadders(numberOfLadders);
    }

    private void initializeCells (int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for (int i = 0;i<boardSize; i++){
            for (int j=0;j<boardSize; j++){
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
        System.out.println("Board is ready sir ");
    }

    private void addSnakes (int numberOfSnakes) {

        while (numberOfSnakes != 0) {
            int start;
            int end;

            start = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            end = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if (end >= start){
                continue;
            }

            Jump jump = new Jump();
            jump.start = start;
            jump.end = end;

            Cell cell = getCellPosition(start);
            cell.jump = jump;
            numberOfSnakes--;

            System.out.println("Adding Nagara's busss snakes ");
        }
    }

    private void addLadders (int numberOfLadders) {

        while (numberOfLadders != 0) {
            int start;
            int end;

            start = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            end = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if (start >= end){
                continue;
            }

            Jump jump = new Jump();
            jump.start = start;
            jump.end = end;

            Cell cell = getCellPosition(start);
            cell.jump = jump;
            numberOfLadders--;

            System.out.println("Ladder added pikachu ");
        }
    }

    Cell getCellPosition(int cellPosition) {
        int row = cellPosition / cells.length;
        int col = cellPosition % cells.length;
        return cells[row][col];
    }
}
