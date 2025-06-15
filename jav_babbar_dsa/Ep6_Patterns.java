public class Ep6_Patterns {

    static void pascalTriangle() {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            int k = 1;
            for (int j = 1; j <= n; j++) {
                System.out.print(j <= n - i ? " " : (k++));
            }
            k -= 2;
            while (k > 0) {
                System.out.print(k--);
            }
            System.out.println();
        }
    }

    // Number pattern with stars
    static void numberPatternWithStars() {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j <= n - i + 1 ? j : "*");
            }
            for (int j = n; j > 0; j--) {
                System.out.print(j <= n - i + 1 ? j : "*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        numberPatternWithStars();
    }
}