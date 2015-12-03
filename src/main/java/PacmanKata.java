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
    static String[][] pacmanLocation;
    final int UP = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int RIGHT = 3;

    public PacmanKata(int height, int width) {
        boardHeight = height;
        boardWidth = width;
        board = new String[boardHeight][boardWidth];
        pacmanBornHeight = (int) Math.floor(height / 2);
        pacmanBornWidth = (int) Math.floor(width / 2);
        pacmanLocation = new String[pacmanBornHeight][pacmanBornWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = "*";
            }
        }
        board[pacmanBornHeight][pacmanBornWidth] = "V";
    }

//    public void tickUp(int steps) {
//        int counter = 1;
//        int timer = 0;
//        for (int loop = 0; loop < steps; loop++) {
//            board[pacmanBornHeight - counter][pacmanBornWidth] = "V";
//            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
//                board[pacmanBornHeight - innerTimer][pacmanBornWidth] = " ";
//            }
//            counter++;
//            timer++;
//        }
//
//
//        for (int i = 0; i < boardHeight; i++) {
//            for (int j = 0; j < boardWidth; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("-------------------------");
//    } //end going UP


//    public void tickDown(int steps) {
//        int counter = 1;
//        int timer = 0;
//        for (int loop = 0; loop < steps; loop++) {
//            board[pacmanBornHeight + counter][pacmanBornWidth] = "V";
//            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
//                board[pacmanBornHeight + innerTimer][pacmanBornWidth] = " ";
//            }
//            counter++;
//            timer++;
//        }
//
//        for (int i = 0; i < boardHeight; i++) {
//            for (int j = 0; j < boardWidth; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("-------------------------");
//    }//end tickDown


    public void tickUp(int steps) {
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
    }//end tickDown

    public void tickDown(int steps) {
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
    }//end tickDown

    public void tickRight(int steps) {
        int counter = 1;
        int timer = 0;
        for (int loop = 0; loop < steps; loop++) {
            board[pacmanBornHeight][pacmanBornWidth + counter] = "V";
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight][pacmanBornWidth + innerTimer] = " ";
            }
            counter++;
            timer++;
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    } //end tickRight

    public void tickLeft(int steps) {
        int counter = 1;
        int timer = 0;
        for (int loop = 0; loop < steps; loop++) {
            board[pacmanBornHeight][pacmanBornWidth - counter] = "V";
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight][pacmanBornWidth - innerTimer] = " ";
            }
            counter++;
            timer++;
        }
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    } //end tickLeft


//    public boolean boardCreated() {
//        return board[0].length > 0 && board.length > 0;
//    }

//    public boolean pacmanCreated() {
//        return pacmanBornHeight >= 0 && pacmanBornWidth >= 0;
//    }


    public static void main(String args[]) {
        PacmanKata pacmanKata = new PacmanKata(10, 10);
        pacmanKata.tickUp(3);
        pacmanKata.tickDown(3);
//        pacmanKata.tickLeft(3);
    }
}
