import java.util.ArrayList;

public class Ep23_2DArrays {

    static void printWave(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;

        boolean flag = true;
        for (int i = 0; i < cols; i++) {
            if (flag) { // we can also make a condition with row/col whether it is even or odd
                for (int j = 0; j < rows; j++) {
                    System.out.print(arr[j][i] + " ");
                }
                flag = false;
            } else {
                for (int j = rows - 1; j >= 0; j--) {
                    System.out.print(arr[j][i] + " ");
                }
                flag = true;

            }
        }
        System.out.println();
    }

    static void printSpiral(int[][] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        int row = arr.length;
        int col = arr[0].length;

        int ct = 0;
        int total = row * col;

        // index init
        int startingRow = 0;
        int startingColumn = 0;
        int endingRow = row - 1;
        int endingColumn = col - 1;

        while (ct < total) {

            // print starting row
            for (int i = startingColumn; i <= endingColumn; i++) {
                ans.add(arr[startingRow][i]);
                ct++;
            }

            startingRow++;

            // print ending column
            for (int i = startingRow; i <= endingRow; i++) {
                ans.add(arr[i][endingColumn]);
                ct++;
            }

            endingColumn--;

            // print ending Row
            for (int i = endingColumn; i >= startingColumn; i--) {
                ans.add(arr[endingRow][i]);
                ct++;
            }

            endingRow--;
            // print starting column
            for (int i = endingRow; i >= startingRow; i--) {
                ans.add(arr[i][startingColumn]);
                ct++;
            }

            startingColumn++;
        }

        for (Integer integer : ans) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        printWave(arr);
        printSpiral(arr); // 1 2 3 6 9 8 7 4 5
    }
}

// Homework: Rotate matrix by 90 degrees
