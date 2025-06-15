
public class Ep7_Binaray_Decimal {

    static int reverseNum(int n) {
        int ans = 0;
        while (n != 0) {
            int lastDigit = n % 10;

            // we should not do ans*10 > Integer.MAX_VALUE, Since ans*10 might be overflown
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = (ans * 10) + lastDigit;
            n /= 10;
        }
        return ans;
    }

    static int onesComplement(int n) {
        int i = 0;
        int dec = 0;
        while (n != 0) {
            if ((n & 1) == 0) {
                dec += Math.pow(2, i);
            }

            i++;
            n >>= 1;
        }
        return dec;
    }

    static int onesComplementOptimized(int n){
        if(n==1){
            return 0;
        }

        int mask = 0;

        int m = n;

        while (m!=0) {
            mask = (mask<<1) | 1;
            m>>=1;
        }

        return (~n & mask);

    }

    static String getNum(int n){
        switch (n) {
            case 1:
                return "One";
            default:
              return "zero";
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseNum(123));//321
        System.out.println(onesComplement(5)); //2
        System.out.println(onesComplementOptimized(5)); //2
    }
}
