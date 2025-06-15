import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Ep20_Streams {
  public static void forEachEx() {
        List<Integer> nums = Arrays.asList(4, 5);

        Consumer<Integer> consumer = new Consumer<Integer>() {
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        // using forEach
        nums.forEach(n -> System.out.println(n)); // Since consumer is a functional interface, we can write lambda expression
        nums.forEach(consumer);
    }

    
    public static void streamExample(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5,3,1);

        Stream<Integer> s1 = nums.stream();
        s1.forEach(n -> System.out.println(n));
        s1.forEach(n -> System.out.println(n)); // stream provides only one time use
    }

    public static void mapExample(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 2, 1);
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
       // s1.map(n -> System.out.println(n)); // 4 2
        
        //reduce
        int result = nums.stream().filter(n -> n%2 ==0).map(n -> n*2).reduce(0,(c,e) -> c+e);
        System.out.println(result);  
    }


    public static void filterPolyFill(String[] args) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            public boolean test(Integer i) {
                return ((i % 2) > 0);
            }
        };
        List<Integer> nums = Arrays.asList(4, 5, 2, 1);
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> res = s1.filter(predicate);
        System.out.println(res);
    }


        public static void mapPolyfill(String[] args) {

        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            public Integer apply(Integer t) {
                return t * 2;
            }
        };

        List<Integer> nums = Arrays.asList(4, 5, 2, 1);
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> res = s1.map(function);
        res.forEach(n -> System.out.println(n)); //8 10 4 2
    }


    public static void reducePolyFill(String[] args) {
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            public Integer apply(Integer c, Integer e) {
                return c + e;
            }
        };

        List<Integer> nums = Arrays.asList(4, 5, 2, 1);
        Stream<Integer> s1 = nums.stream();
        int res = s1.reduce(0, binaryOperator);
        System.out.println(res);
    }

    public static void sortedExample(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 2, 1);
        Stream<Integer> s1 = nums.stream().sorted();
        s1.forEach(i -> System.out.println(i));
    }
}
