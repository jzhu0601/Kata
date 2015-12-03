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

    public void printBorad() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public int tick(int steps, String direction){
        int counter = 1;
        int timer = 0;
        for(int loop = 0; loop < steps; loop++){

        }
        return 0;
    }

    public int tickUp(int steps) {
        int counter = 1;
        int timer = 0;
        for (int loop = 0; loop < steps; loop++) {
            for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
                board[pacmanBornHeight - innerTimer][pacmanBornWidth] = " ";
            }
            pacmanBornHeight -= counter;
            if (pacmanBornHeight < 0) {
                pacmanBornHeight += counter;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            ghostRandomMovement(counter);
            timer++;
        }
        printBorad();
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
            if (pacmanBornHeight >= boardHeight) {
                pacmanBornHeight -= counter;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            ghostRandomMovement(counter);
            timer++;
        }
        printBorad();
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
            if (pacmanBornWidth >= boardWidth) {
                pacmanBornWidth -= counter;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            ghostRandomMovement(counter);
            timer++;
        }
        printBorad();
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
            if (pacmanBornWidth < 0) {
                pacmanBornWidth += counter;
            }
            board[pacmanBornHeight][pacmanBornWidth] = "V";
            ghostRandomMovement(counter);
            timer++;
        }
        printBorad();
        return pacmanBornWidth;
    } //end tickLeft

    public void ghostRandomMovement(int counter) {
        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        indexes.add(1);
        indexes.add(2);
        indexes.add(3);
        Random rand = new Random();
        int index = rand.nextInt(4);
        indexes.get(index);
        board[firstGhostHeight][firstGhostWidth] = "*";
        board[secondGhostHeight][secondGhostWidth] = "*";
        if (index == UP) {
            firstGhostHeight -= counter;
            secondGhostHeight -= counter;
            if (firstGhostHeight < 0) {
                firstGhostHeight += counter;
            }
            if (secondGhostHeight < 0) {
                secondGhostHeight += counter;
            }
            counter++;
        } else if (index == DOWN) {
            secondGhostHeight += counter;
            firstGhostHeight += counter;
            if (secondGhostHeight >= boardHeight) {
                secondGhostHeight -= counter;
            }
            if (firstGhostHeight >= boardHeight) {
                firstGhostHeight -= counter;
            }
            counter++;
        } else if (index == LEFT) {
            firstGhostWidth -= counter;
            secondGhostWidth -= counter;
            if (secondGhostWidth < 0) {
                secondGhostWidth += counter;
            }
            if (firstGhostWidth < 0) {
                firstGhostWidth += counter;
            }
            counter++;
        } else { //RIGHT
            firstGhostWidth += counter;
            secondGhostWidth += counter;
            if (secondGhostWidth >= boardWidth) {
                secondGhostWidth -= counter;
            }
            if (firstGhostWidth >= boardWidth) {
                firstGhostWidth -= counter;
            }
            counter++;
        }
        board[firstGhostHeight][firstGhostWidth] = "@";
        board[secondGhostHeight][secondGhostWidth] = "@";
    }

    public boolean boardCreated() {
        return board[0].length > 0 && board.length > 0;
    }

    public boolean pacmanCreated() {
        return pacmanBornHeight >= 0 && pacmanBornWidth >= 0;
    }

    public static void main(String args[]) {
        PacmanKata pacmanKata = new PacmanKata(10, 10);
        pacmanKata.tickUp(10);
    }

}
