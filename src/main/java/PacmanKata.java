import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jzhu on 12/2/2015.
 */

public class PacmanKata {

    static int boardHeight;
    static int boardWidth;
    static String[][] board;
    static int pacmanBornHeight;
    static int pacmanBornWidth;
    static int firstGhostHeight;
    static int firstGhostWidth;
    static int secondGhostHeight;
    static int secondGhostWidth;
    private final Integer UP = 0;
    private final Integer DOWN = 1;
    private final Integer LEFT = 2;
    private final Integer RIGHT = 3;
    private final String GHOST_FACE = "@";
    private final String PACMAN_FACE = "V";
    private final String DOTS = "*";
    private final String EATEN_DOTS = " ";


    public PacmanKata(int height, int width) {
        boardHeight = height;
        boardWidth = width;
        board = new String[boardHeight][boardWidth];
        pacmanBornHeight = (int) Math.floor(height / 2);
        pacmanBornWidth = (int) Math.floor(width / 2);
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = DOTS;
            }
        }
        board[pacmanBornHeight][pacmanBornWidth] = PACMAN_FACE;
        firstGhostHeight = 0;
        firstGhostWidth = 0;
        secondGhostHeight = height - 1;
        secondGhostWidth = width - 1;
        board[firstGhostHeight][firstGhostWidth] = GHOST_FACE;
        board[secondGhostHeight][secondGhostWidth] = GHOST_FACE;
    }

    public void printBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    private boolean pacmanAlive(int x, int y) {

        try {
            int[][] neighbors = {{x - 1, y}, {x + 1, y}, {x, y + 1}, {x, y - 1}};
            for (int i = 0; i < neighbors.length; i++) {
                int neighborX = neighbors[i][0];
                int neighborY = neighbors[i][1];
                if (neighborX >= 0 && neighborX < boardHeight && neighborY >= 0
                        && neighborY < boardWidth && board[neighborX][neighborY].equals(GHOST_FACE)) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Error, illegal argument passed.");
        }
        return false;
    }

    public int tick(int steps, String direction) {
        boolean pacmanAlive = true;
        for (int loop = 0; loop < steps; loop++) {
            board[pacmanBornHeight][pacmanBornWidth] = EATEN_DOTS;
            if (direction.equalsIgnoreCase("U")) {
                if (pacmanBornHeight <= 0)
                    // pacman on the top of board, he needs to wrap around
                    pacmanBornHeight = boardHeight - 1;
                else
                    // pacman has room to move up
                    pacmanBornHeight--;
            } else if (direction.equalsIgnoreCase("D")) {
                if (pacmanBornHeight >= boardHeight - 1)
                    pacmanBornHeight = 0;
                else
                    pacmanBornHeight++;
            } else if (direction.equalsIgnoreCase("L")) {
                if (pacmanBornWidth <= 0)
                    pacmanBornWidth = boardWidth - 1;
                else pacmanBornWidth--;
            } else if (direction.equalsIgnoreCase("R")) {
                if (pacmanBornWidth >= boardWidth - 1)
                    pacmanBornWidth = 0;
                else pacmanBornWidth++;
            }
            board[pacmanBornHeight][pacmanBornWidth] = PACMAN_FACE;
            pacmanAlive = ghostRandomMovement();
            if (!pacmanAlive || !pacmanAlive(pacmanBornHeight, pacmanBornWidth)) {
                System.out.println("Sorry, game over, you died!");
                return -1;
            }
        }
        printBoard();
        if (direction.equalsIgnoreCase("U") || direction.equalsIgnoreCase("D"))
            return pacmanBornHeight;
        else
            return pacmanBornWidth;

    }

    private boolean ghostRandomMovement() {
        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        indexes.add(1);
        indexes.add(2);
        indexes.add(3);
        Random rand = new Random();
        int index = rand.nextInt(4);
        indexes.get(index);
        board[firstGhostHeight][firstGhostWidth] = DOTS;
        board[secondGhostHeight][secondGhostWidth] = DOTS;
        if (index == UP) {
            if (firstGhostHeight <= 0) {
                firstGhostHeight = boardHeight - 1;
            } else {
                firstGhostHeight--;
            }
            if (secondGhostHeight <= 0) {
                secondGhostHeight = boardHeight - 1;
            } else {
                secondGhostHeight--;
            }
        } else if (index == DOWN) {
            if (firstGhostHeight >= boardHeight - 1) {
                firstGhostHeight = 0;
            } else {
                firstGhostHeight++;
            }
            if (secondGhostHeight >= boardHeight - 1) {
                secondGhostHeight = 0;
            } else {
                secondGhostHeight++;
            }
        } else if (index == LEFT) {
            if (firstGhostWidth <= 0) {
                firstGhostWidth = boardWidth - 1;
            } else {
                firstGhostWidth--;
            }
            if (secondGhostWidth <= 0) {
                secondGhostWidth = boardWidth - 1;
            } else {
                secondGhostWidth--;
            }
        } else if (index == RIGHT) {
            if (firstGhostWidth >= boardWidth - 1) {
                firstGhostWidth = 0;
            } else {
                firstGhostWidth++;
            }
            if (secondGhostWidth >= boardWidth - 1) {
                secondGhostWidth = 0;
            } else {
                secondGhostWidth++;
            }
        }
        if (board[firstGhostHeight][firstGhostWidth].equals(PACMAN_FACE))
            return false;
        board[firstGhostHeight][firstGhostWidth] = GHOST_FACE;
        board[secondGhostHeight][secondGhostWidth] = GHOST_FACE;
        return true;
    }

    public boolean boardCreated() {
        return board[0].length > 0 && board.length > 0;
    }

    public boolean pacmanCreated() {
        return pacmanBornHeight >= 0 && pacmanBornWidth >= 0;
    }
}
