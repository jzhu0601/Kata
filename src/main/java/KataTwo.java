import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jason on 2/5/16.
 */
public class KataTwo {

    public static void main(String args[]) throws Exception {

        String outputToPrint = "";
        Scanner scan = new Scanner(System.in);
        int numOfRows = scan.nextInt();
        scan.nextLine();
        int[][] intRowArray = new int[numOfRows][numOfRows];
        String[][] stringRowArray = new String[numOfRows][numOfRows];
        for (int i = 0; i < numOfRows; i++) {
            String thisLine = scan.nextLine();
            stringRowArray[i] = thisLine.split(" ");
            if (stringRowArray[i].length != numOfRows) {
                outputToPrint = "ERROR";
                System.out.println(outputToPrint);
                break;
            }
        }

        if (!outputToPrint.equals("ERROR")) {
            for (int h = 0; h < numOfRows; h++) {
                for (int k = 0; k < stringRowArray[0].length; k++) {
                    intRowArray[h][k] = Integer.parseInt(stringRowArray[h][k]);
                }
            }
        }

        intRowArray = shiftMatrix(intRowArray);

        if (!outputToPrint.equals("ERROR")) {
            for (int i = 0; i < numOfRows; i++) {
                for (int j = 0; j < numOfRows; j++) {
                    System.out.print(intRowArray[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    static int[][] shiftMatrix(int[][] intRowArray) {
        if (intRowArray.length == 0 || intRowArray.length == 1) return intRowArray;
        List<Integer> outerMatrix = new ArrayList<>();
        for (int j = 0; j < intRowArray.length; j++) outerMatrix.add(intRowArray[0][j]);

        for (int i = 1; i < intRowArray.length; i++) outerMatrix.add(intRowArray[i][intRowArray.length - 1]);

        for (int j = intRowArray.length - 2; j >= 0; j--) outerMatrix.add(intRowArray[intRowArray.length - 1][j]);

        for (int i = intRowArray.length - 2; i >= 1; i--) outerMatrix.add(intRowArray[i][0]);

        int[][] newIntRowArray = new int[intRowArray.length - 2][intRowArray.length - 2];
        for (int i = 1; i < intRowArray.length - 1; i++) {
            for (int j = 1; j < intRowArray.length - 1; j++) newIntRowArray[i - 1][j - 1] = intRowArray[i][j];
        }
        intRowArray = newIntRowArray;
        outerMatrix.add(0, outerMatrix.remove(outerMatrix.size() - 1));
        intRowArray = shiftMatrix(intRowArray);

        int[][] newIntRowArray1 = new int[intRowArray.length + 2][intRowArray.length + 2];

        for (int j = 0; j < intRowArray.length + 2; j++) newIntRowArray1[0][j] = outerMatrix.remove(0);

        for (int i = 1; i < intRowArray.length + 2; i++)
            newIntRowArray1[i][intRowArray.length + 1] = outerMatrix.remove(0);

        for (int j = intRowArray.length; j >= 0; j--)
            newIntRowArray1[intRowArray.length + 1][j] = outerMatrix.remove(0);

        for (int i = intRowArray.length; i >= 1; i--) newIntRowArray1[i][0] = outerMatrix.remove(0);

        for (int i = 0; i < intRowArray.length; i++) {
            for (int j = 0; j < intRowArray[i].length; j++) newIntRowArray1[i + 1][j + 1] = intRowArray[i][j];
        }

        intRowArray = newIntRowArray1;

        return intRowArray;
    }

}
