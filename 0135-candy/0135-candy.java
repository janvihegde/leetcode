class Solution {
    public int candy(int[] rating) {
        int n=rating.length;
        int[] ans=new int[n];
        java.util.Arrays.fill(ans, 1);
        
        for(int i=1;i<n;i++){
            if(rating[i]>rating[i-1]) ans[i]=ans[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(rating[i]>rating[i+1]) 
              ans[i]=Math.max(ans[i],ans[i+1]+1);

        }
            
        
        int sum=0;
        for(int num:ans){
            sum+=num;
        }return sum;
    }
}