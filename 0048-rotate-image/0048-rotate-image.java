class Solution {
    public void rotate(int[][] mat) {
         int size=mat.length;
        //transpose
        for(int row=0;row<size;row++){
            for(int col=row+1;col<size;col++){
                mat[row][col] ^= mat[col][row];
                mat[col][row] ^= mat[row][col];
                mat[row][col] ^= mat[col][row];
            }
        }
        //reverse
        for(int row=0;row<size;row++){
            int l=0,r=size-1 ;
            while(l<r){
                mat[row][l] ^= mat[row][r];
                mat[row][r] ^= mat[row][l];
                mat[row][l] ^= mat[row][r];
                l++;r--;
            }



    }
        
    }
}