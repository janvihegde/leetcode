import java.util.Hashtable;

class Solution {
    public int lengthOfLongestSubstring(String og) {
        int size=og.length(), start=0, end=0,mLen=0;
        Hashtable<Character,Integer> tab = new Hashtable<>();
        while(end<size){
            char key = og.charAt(end);
            if(tab.containsKey(key))
                start = Math.max(start,tab.get(key)+1);
            tab.put(key, end);
            mLen = Math.max(mLen,end-start+1);
            end++;
        }
        return mLen;
    }
}