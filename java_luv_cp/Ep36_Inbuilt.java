import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ep36_Inbuilt {
    public static void main(String[] args) {
        Collections.addAll(null, null);
        Collections.reverse(null);
        Math.min(0, 0);
        int x = (int) Math.PI;

        List<Integer> nums = Arrays.asList(2, 4, 6, 8, 10);
//all of 
boolean allEven = nums.stream().allMatch(n -> n % 2 == 0);
// true, because all numbers are even

//anyof
boolean hasOdd = nums.stream().anyMatch(n -> n % 2 != 0);
// false, because none are odd

//none of
boolean noneNegative = nums.stream().noneMatch(n -> n < 0);
// true, because all are non-negative

//some of 
boolean someEven = nums.stream().anyMatch(n -> n % 2 == 0)
    && !nums.stream().allMatch(n -> n % 2 == 0);




    }
}
