import java.util.Scanner;

/**
 * Created by Jason on 12/3/15.
 */
public class RunApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rows do you want to start? Minium 5 rows so Pacman have a chance to survive: ");
        int inputRows = scanner.nextInt();
        while (inputRows < 5) {
            System.out.println("Sorry minium 5 rows so Pacman have a chance to survive: ");
            inputRows = scanner.nextInt();
        }
        System.out.println("How many column do you want to start? Minium 5 columns for the same reason: ");
        int inputColumn = scanner.nextInt();
        while (inputColumn < 5) {
            System.out.println("Sorry minium 5 columns so Pacman have a chance to survive: ");
            inputColumn = scanner.nextInt();
        }

        PacmanKata pacmanKata = new PacmanKata(inputRows, inputColumn);
        pacmanKata.printBoard();
        System.out.println("V is Pacman! @ are ghosts, if ghosts near you, you will die!");

        while (scanner.hasNextLine()) {
            int gameMonitor = 0;
            System.out.println("Which direction do you want Pacman to move? Type letter \"U\" or \"D\" or \"L\" or \"R\" to move UP,DOWN,LEFT,or RIGHT ");
            String direction = scanner.next();
            System.out.println("How many steps do you want Pacman to move? When Pacman moves, ghosts also move!");
            int steps = scanner.nextInt();
            gameMonitor = pacmanKata.tick(steps, direction);
            if (gameMonitor == -1)
                break;
            System.out.println("Keep Playing? Type \"Y\" for YES, or \"N\" for NO\"");
            String play = scanner.next();
            if (play.equalsIgnoreCase("N"))
                break;
        }
    }
}
