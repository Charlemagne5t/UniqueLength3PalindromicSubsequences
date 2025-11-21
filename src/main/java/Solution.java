import java.util.Arrays;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] ps = new int[n][26];
        int[][] firstLast = new int[26][2];
        for(int i = 0; i < 26; i++){
            Arrays.fill(firstLast[i], -1);
        }
        firstLast[s.charAt(0) - 'a'][0] = 0;
        ps[0][s.charAt(0) - 'a']++;
        for(int i = 1; i < n; i++) {
            int ch = s.charAt(i) -'a';
            int[] cur = Arrays.copyOf(ps[i - 1], 26);
            cur[ch]++;
            ps[i] = cur;
            if(firstLast[ch][0] == -1) {
                firstLast[ch][0] = i;
            }else {
                firstLast[ch][1] = i;
            }
        }
        
        int res = 0;
        for(int i = 0; i < 26; i++) {
            int start = firstLast[i][0];
            int end = firstLast[i][1];
            if(start == -1 || end == -1 || end - start == 1){
                continue;
            }
            int[] cur = Arrays.copyOf(ps[end], 26);
            if(start != 0) {
                for(int j = 0; j < 26; j++) {
                    cur[j] -= ps[start - 1][j];
                }
            }
            for(int j = 0; j < 26; j++){
                if(j == i){
                    res += cur[j] > 2 ? 1 : 0;
                }
                else {
                    res += cur[j] > 0 ? 1 : 0;
                }
                
            }
        }
        return res;
    }
}