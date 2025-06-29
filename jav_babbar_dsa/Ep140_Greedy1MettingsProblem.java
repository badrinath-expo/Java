class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    
    class Pair {
    int first;
    int second;
    Pair(int f, int s){
      this.first = f;
      this.second = s;
    }
  }
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        // add your code here
         ArrayList<Pair> v = new ArrayList<Pair>();
    
    for(int i = 0;i<n;i++){
      Pair p = new Pair(start[i],end[i]);
      v.add(p);
    }
    
    v.sort((a,b) ->a.second - b.second);
    
    int count = 1;
    int ansEnd = v.get(0).second;
    
    for(int i = 1;i<n;i++){
      if(v.get(i).first > ansEnd){
        count++;
        ansEnd = v.get(i).second;
      }
    }
    return count;
    }
}
