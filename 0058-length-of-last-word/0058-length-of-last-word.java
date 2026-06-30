class Solution {
    public int lengthOfLastWord(String s) {
        String[] words=s.trim().split("\\s+");
        int n=words.length;
        String rest=words[n-1];
        int res=rest.length();
        return res;

    }
}