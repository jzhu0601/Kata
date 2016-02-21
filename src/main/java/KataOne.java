import java.io.*;
import java.util.*;

public class KataOne {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int kIndex = 0;
        while (scan.hasNext()) {
            int numOfRows = scan.nextInt();
            scan.nextLine();
            String[][] input = new String[numOfRows][numOfRows];

            for (int i = 0; i < numOfRows; i++) {
                String eachLine = scan.nextLine();
                input[i] = eachLine.split(" ");
            }
            for (int m = 0; m < numOfRows; m++) {
                for (int n = 0; n < numOfRows; n++) {
                    list.add(Integer.parseInt(input[m][n]));
                }
            }
            kIndex = scan.nextInt();
        }
        scan.close();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        boolean flag = false;
        for (int k = 0; k < list.size(); k++) {
            if (set.contains(list.get(k))) {
                flag = true;
                break;
            }
            if (count < kIndex) {
                count++;
            } else {
                set.remove(list.get(k - kIndex));
            }
            set.add(list.get(k));
        }

        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }


}

//To easy store numbers in the array:

//    int d = s.nextInt();
//
//    int[][] matrix = new int[d][d];
//for(int i = 0; i < d; i++) {
//        for(int j = 0; j < d; j++) {
//        matrix[i][j] = Integer.parseInt(s.next());
//        }
//        }