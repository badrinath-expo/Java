import java.util.ArrayList;

public class Ep52_SubsetsBitManiputation {
    // subset generation
    /*
     * 
     * 0 - 000 []
     * 1 - 001 [5]
     * 2 - 010 [4]
     * 3 - 011 [4,5]
     * 4 - 100 [2]
     * 5 - 101 [2,5]
     * 6 - 110 [2,4]
     * 7 - 111 [2,4,5]
     */

    static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
        int n = nums.size();
        int subset_ct = (1 << n); // 2^n
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int mask = 0; mask < subset_ct; mask++) // 2^n times
        {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) // n times
            {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums.get(i));
                }
            }
            subsets.add(subset);
        }
        // O((2^n)*n) :bit masking
        // recursion: 2^n
        return subsets;
    }

    public static void main(String[] args) {

        ArrayList<Integer> v = new ArrayList<Integer>();
        v.add(1);
        v.add(2);
        v.add(3);

        ArrayList<ArrayList<Integer>> all_subsets = subsets(v);
        for (ArrayList<Integer> subset : all_subsets) {
            for (int ele : subset) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
