class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int tt=0,ct=0,station=0;
        for(int i=0;i<gas.length;i++){
            tt +=gas[i]-cost[i];
            ct +=gas[i]-cost[i];
            if(ct<0){
                station=i+1;
                ct=0;
            }


        }
        if(tt>=0) return station;
        else return -1;
    }
}