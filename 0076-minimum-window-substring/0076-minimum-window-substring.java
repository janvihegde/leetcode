class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in string t (target)
        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        
        // Number of unique characters in t that need to be matched
        int requiredMatches = 0;
        for (int count : tMap) {
            if (count > 0) requiredMatches++;
        }
        
        // Tracks how many unique characters currently meet the required frequency in the window
        int formedMatches = 0; 
        
        // Frequency map for the current sliding window
        int[] windowMap = new int[128];

        while (end < s.length()) {
            char rightChar = s.charAt(end);
            windowMap[rightChar]++;

            // If the current character's count matches its target count, record it as a match
            if (tMap[rightChar] > 0 && windowMap[rightChar] == tMap[rightChar]) {
                formedMatches++;
            }

            // Try to shrink the window from the left as long as it remains valid
            while (formedMatches == requiredMatches) {
                // Update the minimum window metrics
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char leftChar = s.charAt(start);
                windowMap[leftChar]--;

                // If dropping this character breaks our target match condition, decrement formedMatches
                if (tMap[leftChar] > 0 && windowMap[leftChar] < tMap[leftChar]) {
                    formedMatches--;
                }
                
                start++; // Shrink window
            }
            
            end++; // Expand window
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}