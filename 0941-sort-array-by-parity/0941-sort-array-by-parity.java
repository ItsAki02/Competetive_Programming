class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int moveindex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                int temp = nums[moveindex];
                nums[moveindex] = nums[i];
                nums[i]  = temp;
                moveindex++;
            }
        }
        return nums;
    }
}