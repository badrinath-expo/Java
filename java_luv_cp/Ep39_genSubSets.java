import java.util.ArrayList;

public class Ep39_genSubSets {

    public static void generateSubsets(ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> subset, int arr[],
            int i) {

        if (i == arr.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);
        generateSubsets(subsets, subset, arr, i+1);
        subset.remove(subset.size() - 1);
        generateSubsets(subsets, subset, arr, i+1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
         
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        generateSubsets(subsets, subset, arr, 0);

        for (ArrayList<Integer> ss : subsets) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : ss) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
