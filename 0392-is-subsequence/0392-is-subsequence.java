class Solution {
    public boolean isSubsequence(String s, String t) {
        int k=0;
        char[] sub=s.toCharArray();
        char[] w=t.toCharArray();
        if (sub.length == 0) return true;
        
        // Fix 2: If s is longer than t, it's impossible to be a subsequence
        if (sub.length > w.length) return false;
        for(int i=0;i<w.length;i++){
            if (w[i] == sub[k]) {
                k++;
                if (k == sub.length) {
                    return true;
                }
            }
        }
        return false;
    }
}