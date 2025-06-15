public class Ep18_Recursion {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int digitSum(int n){
        if(n==0) return 0;
        return n%10 + digitSum(n/10);
    }

    public static int arraySum(int arr[], int n){
        if(n==0) return 0;
        return arr[n-1] + arraySum(arr, n-1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        int n = arr.length;
        System.out.println("Sum of array: " + arraySum(arr, n)); // 15
    }
}

//Solve josephus problem using recursion