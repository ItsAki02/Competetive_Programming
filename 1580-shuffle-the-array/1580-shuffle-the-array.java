class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[]  = new int[n*2];
        int j = 0;
        for(int i = 0; i < n; i++){
            arr[j] = nums[i];
            j +=2;
        }
        int k = 1;
        for(int i = n; i < 2* n; i++){
            arr[k] = nums[i];
            k +=2;
        }
        return arr;
    }
}