package lld_practice.LLDSnakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Player winner;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();

    public Game(int boardSize, int numSnakes, int numLadders){
        board = new Board(boardSize, numSnakes, numLadders);
        dice = new Dice(1);
        addPlayers();
    }

    public void addPlayers() {
        Player p1 = new Player("bunny", 0);
        Player p2 = new Player("penny", 0);
        System.out.println("Added players ");
        playersList.add(p1);
        playersList.add(p2);

    }

    public void startGame() {

        while (winner == null) {
//            System.out.println("Hi man");
            Player currentPlayer = getCurrentPlayer();
            System.out.println("player turn is:" + currentPlayer.id + " current position is: " + currentPlayer.currentPosition);
            int playernextPos = dice.rollDice();
            playernextPos += currentPlayer.currentPosition;
            playernextPos = checkJump(playernextPos);
            currentPlayer.currentPosition = playernextPos;
            System.out.println("player turn is:" + currentPlayer.id + " new Position is: " + playernextPos);
            if (playernextPos >= board.cells.length * board.cells.length - 1) {
                winner = currentPlayer;
                System.out.println("Winner is declared f off all " + currentPlayer.id);
            }


        }
    }

    private int checkJump (int nextPosition) {
        // checks if snake or ladder is present
        if (nextPosition > board.cells.length * board.cells.length - 1) {
            return nextPosition;
        }
        Cell cell = board.getCellPosition(nextPosition);
        if (cell.jump != null && cell.jump.start == nextPosition) {
            return cell.jump.end;
        }
        return nextPosition;
    }

    private Player getCurrentPlayer() {
        Player player = playersList.removeFirst();
        playersList.addLast(player);
        return player;
    }

}
