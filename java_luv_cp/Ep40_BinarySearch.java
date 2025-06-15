public class Ep40_BinarySearch {
    
    public static int binarySearch(int arr[], int n, int key){
            int left = 0, right = n-1;
            while (left < right) {
                int mid = (left + right)/2;
                if(key <= arr[mid]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            
        return arr[left] == key ? left : -1;
    }
    
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,8};
        int res = binarySearch(arr, arr.length, 3);
        System.out.println(res);
    }
}
