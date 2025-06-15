//Notion link: https://www.notion.so/Java-Core-189fad9b5f9c80e08b56fae3d6bfec0a?pvs=4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Student that) {
        if (this.age > that.age)
            return 1;
        else
            return -1;
    }

}

public class Ep20_Collection {

    public static void Lists(String[] args) {
        Collection<Integer> nums = new ArrayList<Integer>();
        // or List<Integer> nums = new ArrayList<Integer>(); // List has some useful
        // methods
        nums.add(5);
        nums.add(4);

        for (Integer n : nums) {
            System.out.println(n);
        }
    }

    //Sets
    public static void Sets() {
        Set<Integer> nums = new HashSet<Integer>();
        nums.add(62);
        nums.add(54);
        nums.add(82);
        nums.add(21);

        for (Integer n : nums) {
            System.out.print(n + " "); // 82 21 54 62 //random order
        }

        // Treeset - sorted order
        Set<Integer> tnums = new TreeSet<Integer>();
        tnums.add(62);
        tnums.add(54);
        tnums.add(82);
        tnums.add(21);

        for (Integer n : tnums) {
            System.out.print(n + " "); // 21 54 62 82 //sorted order
        }

    }

    //Iterator
    public static void IteratorE2ample(String[] args) {
        Collection<Integer> nums = new HashSet<Integer>();
        nums.add(5);
        nums.add(4);
        nums.add(5);

        Iterator<Integer> values = nums.iterator();
        while (values.hasNext()) {
            System.out.println(values.next() + " "); // 4 5

        }
    }

    //Maps
    public static void Maps(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("navin", 56);
        students.put("Ryan", 24);
        students.put("aron", 42);
        students.put("navin", 32);

        System.out.println(students); // {navin=32, Ryan=24, aron=42}

        for (String key : students.keySet()) {
            System.out.println(key + " " + students.get(key));
            /*
             * navin 32
             * Ryan 24
             * aron 42
             */
        }

      //  Map.of() returns an immutable map – you can't add/remove elements.
    }
    // synchronized - hashTable (useful in multi threading)

    // → by default, Integer extends Comparable Interface. That’s why we’re able to
    // sort it without need of comparator defining.

    // Comparator - interface used for own logic for sorting
    public static void comparators() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                // We should return greater value on when to swap and less value if not
                if (i > j) {
                    return 1;
                } else {
                    return -1;
                }
                // or return i-j; //ascending
                // for descending: return j-i
            }

        };
        // using lambda => Comparator<Integer> comparator = (i,j) -> i-j;
        List<Integer> nums = new ArrayList<>();
        nums.add(8);
        nums.add(3);
        nums.add(4);
        Collections.sort(nums, comparator);
        System.out.println(nums); // [3, 4, 8]
    }

    public static void customComparator() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("tony", 20));
        students.add(new Student("steve", 30));
        Collections.sort(students);
    }

    // As List
    public static void AsList() {
        List<Integer> nums = Arrays.asList(4, 5);
        System.out.println(nums); // [4, 5]
        int sum = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                n *= 2;
                sum = sum + n;
            }
        }
        System.out.println(nums); // [4, 5]
        System.out.println(sum); // 8

        // using forEach
        nums.forEach(n -> System.out.println(n));
    }




    public static void main(String[] args) {

    }
}