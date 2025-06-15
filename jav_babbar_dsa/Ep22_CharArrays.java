public class Ep22_CharArrays {

    static void maxOccCharacterInString(String s) {
        int arr[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int number = 0;
            if (ch >= 'a' && ch <= 'z') {
                number = ch - 'a';
            } else {
                number = ch - 'A';
            }

            arr[number]++;
        }

        int maxi = -1, ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (maxi < arr[i]) {
                maxi = Math.max(maxi, arr[i]);
                ans = i;
            }
        }

        System.out.println((char) ('a' + ans));

    }

    // Remove spaces and replace with @40
    static void removeSpacesAndReplaceAt40(String s) {

        String res = "";
        boolean space = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                space = true;

            } else {

                if (space) {
                    res += "@40" + s.charAt(i);
                    space = false;
                    continue;
                }
                res = res + s.charAt(i);
            }
        }

        System.out.println(res);
    }

    static void removeAllOccurencesOfSubString(String s, String part) {

        while (s.indexOf(part, 0) > 0) {
            s = s.replace(part, "");
        }

        System.out.println(s);
    }

    static boolean checkEqual(int count1[], int count2[]) {
        int i = 0;
        while (i < count1.length) {
            if (count1[i] != count2[i]) {
                return false;
            }
            i++;
        }

        return true;
    }

    // Sliding window problem
    static boolean permutationInString(String s1, String s2) {
        int count1[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            count1[index]++;
        }

        // traverse s2 String in window of size s1 length and compare
        int i = 0;
        int windowSize = s1.length();
        int count2[] = new int[26];

        // running for first window
        while (i < windowSize) {
            int index = s2.charAt(i) - 'a';
            count2[index]++;
            i++;
        }

        if (checkEqual(count1, count2)) {
            return true;
        }

        // forward the window
        while (i < s2.length()) {
            char newChar = s2.charAt(i);
            int index = newChar - 'a';
            count2[index]++;

            char oldChar = s2.charAt(i - windowSize);
            index = oldChar - 'a';
            count2[index]--;

            i++;
            if ((checkEqual(count1, count2))) {
                return true;
            }
        }
        return false;
    }

    static void removeAdjacentDuplicates(String s) {

        String res = "";
        boolean space = false;
        res += s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                space = true;
            } else {
                if (space) {
                    res += s.charAt(i);
                    space = false;
                    continue;
                }
                res = res + s.charAt(i);
            }
        }

        System.out.println(res);
    }

    static void stringCompression(String s) {

        String res = "";
        boolean space = false;
        res += s.charAt(0);

        int charCt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                space = true;
                charCt++;
            } else {
                if (space) {
                    res = res + (charCt >= 1 ? charCt + 1 : "") + s.charAt(i);
                    space = false;
                    charCt = 0;
                    continue;
                }
                res = res + s.charAt(i);
            }
        }

        System.out.println(res);
    }

    public static int compress(char[] chars) {

        String res = "";
        boolean space = false;
        res += chars[0];
        int charCt = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                space = true;
                charCt++;
            } else {
                if (space) {
                    res = res + (charCt >= 1 ? charCt + 1 : "") + chars[i];
                    space = false;
                    charCt = 0;
                    continue;
                }
                res = res + chars[i];
            }
        }

        if (charCt >= 1) {
            res += (charCt + 1);
        }
    

        for (int i = 0; i < res.length(); i++) {
            chars[i] = res.charAt(i);
        }

        return res.length();
    }

    public static void main(String[] args) {
        Character c[] = new Character[] { 'a', 'b', '\0', '7' };
        maxOccCharacterInString("test");
        removeSpacesAndReplaceAt40("My    Name is Khan"); // My@40Name@40is@40Khan
        removeAllOccurencesOfSubString("daabcbaabcbc", "abc");

        System.out.println(permutationInString("ab", "eidbaooo"));

        removeAdjacentDuplicates("abbaca");

        stringCompression("aabccdd");

        System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
    }
}
// Homework
// LeetCode: Reverse words in a sring

// Learn about scanner
