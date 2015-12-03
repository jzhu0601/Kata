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

    public PacmanKata(int height, int width) {
        boardHeight = height;
        boardWidth = width;
        board = new String[boardHeight][boardWidth];
        pacmanBornHeight = (int) Math.floor(height / 2);
        pacmanBornWidth = (int) Math.floor(width / 2);
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = "*";
            }
        }
        board[pacmanBornHeight][pacmanBornWidth] = "V";
        firstGhostHeight = 0;
        firstGhostWidth = 0;
        secondGhostHeight = height - 1;
        secondGhostWidth = width - 1;
        board[firstGhostHeight][firstGhostWidth] = "@";
        board[secondGhostHeight][secondGhostWidth] = "@";

    }


    public int tickUp(int steps) {
        int counter = 1;
        int timer = 0;
        for (int loop = 0; loop < steps; loop++) {
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight - innerTimer][pacmanBornWidth] = " ";
            }
            pacmanBornHeight -= counter;
            //Allow for wraparounds:
            if (pacmanBornHeight > board.length) {
                pacmanBornHeight = 0;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            timer++;
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        return pacmanBornHeight;
    }//end tickDown

    public int tickDown(int steps) {
        int counter = 1;
        int timer = 0;
        for (int loop = 0; loop < steps; loop++) {
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight + innerTimer][pacmanBornWidth] = " ";
            }
            pacmanBornHeight += counter;
            //Allow for wraparounds:
            if (pacmanBornHeight > board.length) {
                pacmanBornHeight = 0;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            timer++;
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        return pacmanBornHeight;
    }//end tickDown

    public int tickRight(int steps) {
        int counter = 1;
        int timer = 0;

        for (int loop = 0; loop < steps; loop++) {
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight][pacmanBornWidth + innerTimer] = " ";
            }
            pacmanBornWidth += counter;
            //Allow for wraparounds:
            if (pacmanBornWidth > board[0].length) {
                pacmanBornWidth = 0;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            timer++;
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        return pacmanBornWidth;
    } //end tickRight

    public int tickLeft(int steps) {
        int counter = 1;
        int timer = 0;

        for (int loop = 0; loop < steps; loop++) {
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight][pacmanBornWidth - innerTimer] = " ";
            }
            pacmanBornWidth -= counter;
            //Allow for wraparounds:
            if (pacmanBornWidth > board[0].length) {
                pacmanBornWidth = 0;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            timer++;
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        return pacmanBornWidth;
    } //end tickLeft

    public void ghostRandomMovement(){

    }

    public boolean boardCreated() {
        return board[0].length > 0 && board.length > 0;
    }

    public boolean pacmanCreated() {
        return pacmanBornHeight >= 0 && pacmanBornWidth >= 0;
    }


    public static void main(String args[]) {
        PacmanKata pacmanKata = new PacmanKata(10, 10);
        pacmanKata.tickUp(3);
        pacmanKata.tickDown(7);
        pacmanKata.tickRight(3);
        pacmanKata.tickLeft(5);
    }

}
