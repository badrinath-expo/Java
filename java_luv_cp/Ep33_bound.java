import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ep33_bound {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        // lowerBound (≥): ceiling()
        System.out.println(set.ceiling(25)); // Output: 30

        // upperBound (>): higher()
        System.out.println(set.higher(30)); // Output: 40

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");

        // lowerBound (≥): ceilingKey()
        System.out.println(map.ceilingKey(15)); // Output: 20

        // upperBound (>): higherKey()
        System.out.println(map.higherKey(20)); // Output: 30


        //USING COLLECTIONS 
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        int key = 25;
        int idx = Collections.binarySearch(list, key);

        if (idx < 0)
            idx = -(idx + 1); // Lower bound (first ≥ key)
        System.out.println("Lower Bound Index: " + idx); // Output: 2 (list.get(2) = 30)
    }
}
