import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] firstLastIndexes = new int[26][2];
        for(int i = 0; i < 26; i++)
            Arrays.fill(firstLastIndexes[i], -1);

        firstLastIndexes[s.charAt(0) - 'a'][0] = 0;
        int[][] ps = new int[n][26];
        int[] ps0 = new int[26];
        ps0[s.charAt(0) - 'a']++;
        ps[0] = ps0;
        for(int i = 1; i < n; i++) {
            if(firstLastIndexes[s.charAt(i) - 'a'][0] == -1) {
                firstLastIndexes[s.charAt(i) - 'a'][0] = i;
            }else {
                firstLastIndexes[s.charAt(i) - 'a'][1] = i;
            }
            ps[i] = Arrays.copyOf(ps[i - 1], 26);
            ps[i][s.charAt(i) - 'a']++;
        }
        int res = 0;

        for(int i = 0; i < 26; i++) {
            if(firstLastIndexes[i][1] == -1 || firstLastIndexes[i][0] == -1){
                continue;
            }

            int start  = firstLastIndexes[i][0];
            int end = firstLastIndexes[i][1];
            if(end - start == 1){
                continue;
            }

            for(int j = 0; j < 26; j++) {
                if(ps[end - 1][j] - ps[start][j] > 0) {
                    res++;
                }
            }


        }


        return res;
    }
}
