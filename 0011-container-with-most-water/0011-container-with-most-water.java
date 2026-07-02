class Solution {
    public int maxArea(int[] arr) {
         int l=0,r=arr.length-1,max=0,cmax=0,len=0;
        while(l<r){
           if(arr[l]<arr[r]) len=arr[l];
           else len=arr[r];
           cmax=len*(r-l);
           max=Math.max(max,cmax);
           if(arr[l]<arr[r]) l++;
           else r--;
        }
        return max;
    }
}