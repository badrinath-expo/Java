public class Ep43_WoodProblem {

    public static int isWoodSufficient(int tree[], int h, int k) {
        int wood = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] >= h) {
                wood += (tree[i] - h);
            }
        }

        return wood;
    }

    static int find_height(int tree[], int n, int k) {
        int r = tree[0];
        for (int i = 1; i < tree.length; i++) {
            r = Math.max(r, tree[i]);
        }

        int l = 0;

        int ans = -1;

        while (l<=r) {
            int mid = l + (r - l) / 2;
            
            int val = isWoodSufficient(tree, mid, k);
            
            if(val == k) return mid;

            if (val > k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {

    }
}
