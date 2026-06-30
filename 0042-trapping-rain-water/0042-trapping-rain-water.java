class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int lm = height[l]; 
        int rm = height[r];
        int tw=0;
        if (height == null || height.length == 0) {
            return 0;
        }
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=lm) 
                   lm=height[l];
                else
                  tw+=lm-height[l];
                l++;             
            }
            else{
                if(height[r]>=rm)
                  rm=height[r];
                else
                  tw+=rm-height[r];
                r--;
            }
        }return tw;
    }
}