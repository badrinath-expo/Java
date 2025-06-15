import java.util.ArrayList;

public class Ep39_Permuaions {

    static void printArray(ArrayList<Integer> nums) {
        for (Integer x : nums) {
            System.out.print(x);
        }
        System.out.println();
    }

    static void solve(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans, int index) {

        if (index >= nums.size()) {
           // printArray(nums);
            ans.add(new ArrayList<>(nums));
            return;
        }

        for (int j = index; j < nums.size(); j++) {

            int temp = nums.get(index);
            nums.set(index, nums.get(j));
            nums.set(j, temp);

            solve(nums, ans, index + 1);

            temp = nums.get(index);
            nums.set(index, nums.get(j));
            nums.set(j, temp);

        }
    }

    static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        int index = 0;
        solve(nums, ans, index);
        return ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>();

        nums.add(1);
        nums.add(2);
        nums.add(3);

        ArrayList<ArrayList<Integer>> ans = permute(nums);

        for (ArrayList<Integer> ar : ans) {
            for (Integer x : ar) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
