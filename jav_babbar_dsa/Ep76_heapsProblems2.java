import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Ep76_heapsProblems2 {
static class Node {
    int data;
    int i;
    int j;

    Node(int data, int row,int col){
        this.data = data;
        this.i = row;
        this.j = col;
    }
}

    /******* Kth largest sum sub array ************/
   static int getKthLargestSumSubArrayUnOptimized(List<Integer> arr, int k){ //T.C - O(N^2) S.C - O(N^2)
    List<Integer> sumStore = new ArrayList<>();
    int n = arr.size();

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum+= arr.get(j);
            sumStore.add(sum);
        }
    }

    sumStore.sort((a,b) -> a-b);
    return sumStore.get(sumStore.size() - k);
   }
   
   static int getKthLargestSumSubArrayOptimized(List<Integer> arr,int k){ //T.C - O(N^2) S.C - O(K)
    PriorityQueue<Integer> mini = new PriorityQueue<>();    

    int n = arr.size();
    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum+=arr.get(j);
            if(mini.size() < k){
                mini.add(sum);
            } else{
                if(sum > mini.peek()){
                    mini.remove();
                    mini.add(sum);
                }
            }
        }
    }
    return mini.peek();
   } 


   /************ Problem 2 ***************/

   static List<Integer> mergeKsortedArrays(int[][] kArrays, int k){
      PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.data, b.data));

     //step1: insert first elements of all the k arrays
     for(int i = 0;i <k;i++){
        Node tmp = new Node(kArrays[i][0], i, 0);
    pq.add(tmp);
    }

List<Integer> ans = new ArrayList<>();
//step2
while (pq.size() > 0) {
    Node temp = pq.peek();
    ans.add(temp.data);
    pq.remove();
    
    int i = temp.i;
    int j = temp.j;

    if(j+1 < kArrays[i].length){
        Node tmp = new Node(kArrays[i][j+1], i, j+1);
        pq.add(tmp);
    }
}
     
return ans;
   }


   //merge k sorted LL - solve on your own
    public static void main(String[] args) {
        
    }
}
