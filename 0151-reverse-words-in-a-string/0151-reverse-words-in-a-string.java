class Solution {
    public String reverseWords(String s) {
        String[] w= s.trim().split("\\s+");
        int n=w.length;
        int j=0;
        String[] res=new String[n];
        for(int i=n-1;i>=0;i--){

            res[j]=w[i];
            j++;
        }return String.join(" ", res);
    }
}