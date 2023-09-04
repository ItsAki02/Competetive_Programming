class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length * 2];
        int newLength = ans.length;
        int j  = 0;
        for(int i = 0; i < newLength; i++){
            if(i >= length){
                ans[i] = nums[j++];
                continue;
            }
            ans[i] = nums[i];
        }
        return ans;
    }
}