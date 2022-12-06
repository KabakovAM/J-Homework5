package Homework5;

import java.util.HashMap;

public class Ex2085 {
    public static void main(String[] args) {
        String[] words1 = new String[] { "b", "bb", "bbb" };
        String[] words2 = new String[] { "a", "aa", "aaa" };
        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < words1.length; i++) {
            if (map.containsKey(words1[i])) {
                map.put(words1[i], map.get(words1[i]) + 1);
            } else {
                map.put(words1[i], 1);
            }
        }
        for (int i = 0; i < words2.length; i++) {
            if (map.containsKey(words2[i]) && map.get(words2[i]) == 1) {
                map.put(words2[i], 0);
                result += 1;
            } else if (map.containsKey(words2[i]) && map.get(words2[i]) == 0) {
                map.remove(words2[i]);
                result -= 1;
            }
        }
        return result;
    }
}
