class Solution {
    public int removeElement(int[] nums, int val) {
        int newlength = 0;

        for(int i = 0; i <nums.length; i++){
            if(nums[i]  != val){
                nums[newlength] = nums[i];
                newlength++;
            }
        }
        return newlength;
    }
}