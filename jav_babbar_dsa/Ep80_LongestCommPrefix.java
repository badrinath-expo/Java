import java.util.List;

public class Ep80_LongestCommPrefix {



    static String longestCommonPrefixUnOptimized(String[] arr, int n){
        StringBuilder ans =new StringBuilder("");
        boolean match = true;

        for (int i = 0; i < arr[0].length(); i++) {
            
          char ch = arr[0].charAt(i);
        for(int j=1;j<n;j++){

            if(arr[j].length() < i || ch!=arr[j].charAt(i)){
                match = false;
                break;
            }
        }

        if(match == false){
            break;
        }else{
            ans.append(ch);
        }
    }

        return ans.toString();
    } //T.C - O(M*N)     S.C - O(1)

/**********Optimized using Trie **********/
static class TrieNode{
    char data;
    TrieNode children[];
    int childCount;
    boolean isTerminal;

    TrieNode(char ch){
        this.data = ch;
        this.children  = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        this.childCount = 0;
        this.isTerminal = false;
    }
}



static class Trie{
    TrieNode root;

    Trie(char ch){
        this.root = new TrieNode(ch);
    }
}

//solve after Trie Lecture




    public static void main(String[] args) {
        
    }
}