class Solution {
    public void moveZeroes(int[] nums) {
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i != length){
                    int temp = nums[length];
                    nums[length] = nums[i];
                    nums[i] = temp;
                }
                length++;
            }
        }
    }
}