import java.util.*;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 'a'; i <= 'z' ; i++) {
            map.put((char)i, new int[]{-1, - 1});
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch)[0] == -1){
                int[] indexes = map.get(ch);
                indexes[0] = i;
                map.put(ch, indexes);
            }else if(map.get(ch)[0] != -1 && i - map.get(ch)[0] > 1 ){
                int[] indexes = map.get(ch);
                indexes[1] = i;
                map.put(ch, indexes);
            }
        }
        for (Map.Entry<Character, int[]> e: map.entrySet()) {
            char letter = e.getKey();
            int[] indexes = e.getValue();
            if(indexes[0] == -1 || indexes[1] == -1){
                continue;
            }
            Set<Character> distinct = new HashSet<>();
            for (int i = indexes[0] + 1; i < indexes[1]; i++) {
                distinct.add(s.charAt(i));
            }
            int count = distinct.size();
            result += count;
        }

        return result;
    }
}
