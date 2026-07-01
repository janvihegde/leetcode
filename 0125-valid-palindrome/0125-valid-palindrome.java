class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
       
        char[] chararray = s.toCharArray();
        int i=0,j=chararray.length-1;
        while(i<j){
            if(chararray[i]!=chararray[j]){
            return false;
            }
            i++;j--;
        }
        return true;
    }
}