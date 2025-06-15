import java.text.DecimalFormat;
import java.util.Scanner;

class Ep3_Overflow_precision {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Ascii A to Z ==> 65 to 90 a to z ==> 97 to 122

        // Implicit typecasting
        // 1e9 by default it's double, declare as 1e9f to treat it as float
        int f = (int) 1e9;

        int ch = (int) 'A'; // 65

        // We can also fit in big data types
        byte b = 122;
        int x = b;

        int i = (int) 1e9; // 1000000000
        int ij = (int) 1e10; // 2147483647
        System.out.println(i);
        long a = (long) 1e18; // 1000000000000000000 18 zeroes
        long bb = (long) 1e19; // 9223372036854775807
        System.out.println(bb);

        // byte range is -128 to 127

        byte n1 = 127;
        byte n2 = 127;
        int n = n1 + n2;
        System.out.println(n); // 254

        double yy = 3333.12345;
        String str = String.format("%.3f", yy);
        System.out.println(str);// 3333.123
        System.out.printf("%.2f", yy); // 3333.12 //doesn't goes to new line in console
        System.out.printf("%.2f\n", yy); // 3333.12 //goes to new line in console

        System.out.println();

        double num = 3.1415926535;

        DecimalFormat df = new DecimalFormat("#.#"); // 1 decimal places
        System.out.println("Formatted: " + df.format(num)); // 3.1
        String ss = "abcde";
        System.out.println(ss.charAt(0)); // a
 
        

        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine(); // abc def
        String s2 = scanner.nextLine(); // ghik asd asd
        String s3 = scanner.nextLine(); // abc ghi
        System.out.println(s1 + s2 + s3); // abc defghik asd asdabc ghi
        scanner.close();

        // 2-D array can be initialized this way
        int[] arr[] = new int[5][5];
        // or int arr[][] = new int[5][5];

        //pass by reference can be done with arrays or objects.
    }

}

/*   Modular arithmetic

1.Addition
     (a+b)%M    =   ((a%M)+(b%M))%M



2.Multiplication
     (a*b)%M    =   ((a % M)*(b % M)) % M



3.Subtraction
    (a-b)%M    =   ((a % M)-(b % M) + M) % M



4.Divison

    (a/b)%M    =   ((a % M)*(b^-1) % M)) % M

*/


/*
Find the modulo M of given factorial
of number

when we try to get factorial on 21 we are going to get negative values

later we will be unable to move forward

for(int i=2;i<=n;i++){
    fact =(fact*i)%M;
}

//       significance of M=10^9+7
*/