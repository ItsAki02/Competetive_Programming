class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] monstArrivalTime = new double[n];

        for(int i = 0; i < n; i++){
            monstArrivalTime[i] = ((double)(dist[i])/ (double)speed[i]);
        }
        Arrays.sort(monstArrivalTime);
        int res = 0;
        double stick = 0.0;

        for(int i = 0; i < n; i++){
            if(stick < monstArrivalTime[i]){
                res++;
                stick++;
            }else{
                break;
            }
        }
        return res;
    }
}