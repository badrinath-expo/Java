public class Ep34_RecursionProblems {

    static boolean checkPalindrome(String str, int n, int s, int e) {

        if (s >= e) {
            return true;
        }

        if (str.charAt(s) == str.charAt(e)) {
            return checkPalindrome(str, n, ++s, --e);
        } else {
            return false;
        }
    }

    static boolean checkPalindrome2(String str, int n, int s, int e) {

        if (s >= e) {
            return true;
        }

        if (str.charAt(s) == str.charAt(e)) {
            return checkPalindrome2(str, n, ++s, --e);
        } else {
            return false;
        }
    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        System.out.println("n" + n);
        // code here
        return checkPalindrome2(s, n, 0, n - 1);
    }

    static int power(int a, int b) {
        // base case
        if (b == 0)
            return 1;

        if (b == 1) {
            return a;
        }

        int ans = power(a, b / 2);

        if (b % 2 == 0) {
            return ans * ans;
        } else {
            return a * ans * ans;
        }
    }

    //Homw work: Solve bubble sort using recursion

    public static void main(String[] args) {

        System.out.println(checkPalindrome("raceca", 6, 0, 6 - 1));

        System.out.println(isPalindrome("abba"));
    }
}
