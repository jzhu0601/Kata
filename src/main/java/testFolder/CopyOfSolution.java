package testFolder;

import java.util.Scanner;

/**
 * Created by Jason on 2/4/16.
 */
public class CopyOfSolution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numOfRows = scan.nextInt();
        scan.nextLine();
        String[][] stringRowArray = new String[numOfRows][numOfRows];
        int[][] intRowArray = new int[numOfRows][numOfRows];
        for (int i = 0; i < numOfRows; i++) {
            String thisLine = scan.nextLine();
            stringRowArray[i] = thisLine.split(" ");
        }
        for (int h = 0; h < numOfRows; h++) {
            for (int k = 0; k < stringRowArray[0].length; k++) {
                intRowArray[h][k] = Integer.parseInt(stringRowArray[h][k]);
            }
        }

        int sumPrimary = 0;
        int sumSecondary = 0;
        for (int m = 0; m < numOfRows; m++) {
            sumPrimary += intRowArray[m][m];
            sumSecondary += intRowArray[m][numOfRows - m - 1];
        }
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }
}

/*
        Scanner scan = new Scanner(System.in);
        int numOfRows = scan.nextInt();
        scan.nextLine();
        String[][] stringRowArray = new String[numOfRows][numOfRows];
        int[][] intRowArray = new int[numOfRows][numOfRows];
        for (int i = 0; i < numOfRows; i++) {
            String thisLine = scan.nextLine();
            stringRowArray[i] = thisLine.split(" ");
        }
        for (int h = 0; h < numOfRows; h++) {
            for (int k = 0; k < stringRowArray[0].length; k++) {
                intRowArray[h][k] = Integer.parseInt(stringRowArray[h][k]);
            }
        }
*/