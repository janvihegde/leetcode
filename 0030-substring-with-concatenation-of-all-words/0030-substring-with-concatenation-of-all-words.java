import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);

        // Iterate through each possible starting offset
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0; // number of valid words in current window
            int left = i;

            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String w = s.substring(right, right + wordLen);
                if (wordMap.containsKey(w)) {
                    seenWords.put(w, seenWords.getOrDefault(w, 0) + 1);
                    count++;

                    while (seenWords.get(w) > wordMap.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }
}