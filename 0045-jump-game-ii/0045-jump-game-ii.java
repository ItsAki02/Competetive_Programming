class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int count = 0;
        int curr = 0;
        int prev = 0;
        int n = nums.length-1;

        for(int i = 0; i < n; i++){
            curr = Math.max(curr,i + nums[i]);
            
            if(i == prev){
                prev = curr;
                count++;
            }
        }
        return count;
    }
}