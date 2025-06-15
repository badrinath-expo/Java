public class Ep23_2DArrayBinarySearch {

    static boolean binarySearch(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int s = 0;
        int e = row * col - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target <= matrix[mid / col][mid % col]) {
                if (target == matrix[mid / col][mid % col]) {
                    return true;
                }

                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return false;
    } // O(log(row*col))

    // Leetcode: Search in a 2D matrix, row wise sorted, column wise sorted
    static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int rowIndex = 0;
        int colIndex = col - 1;

        while (rowIndex < row && colIndex >= 0) {
            int element = matrix[rowIndex][colIndex];

            if (element == target) {
                return true;
            }

            if (element < target) {
                rowIndex++;
            } else {
                colIndex--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(binarySearch(arr, 21));

        int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 11));
    }
}
