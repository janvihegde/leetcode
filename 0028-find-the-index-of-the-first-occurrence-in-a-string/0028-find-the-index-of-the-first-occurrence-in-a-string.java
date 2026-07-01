class Solution {
    public int strStr(String haystack, String needle) {
        char[] h=haystack.toCharArray();
        char[] n=needle.toCharArray();
        if(h.length<n.length) return -1;
        if(n.length==0) return 0;
        for(int i=0;i<=h.length-n.length;i++){
            if(h[i]==n[0]){
                boolean match=true;
                for(int j=1;j<n.length;j++){
                    if(h[i+j]!=n[j]) {
                        match=false;
                        break;
                    }
                }
                if(match) {
                    return i;
                }
            }
        }return -1;

    }
}