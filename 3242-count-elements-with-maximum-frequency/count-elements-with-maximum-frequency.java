class Solution {
    public int maxFrequencyElements(int[] nums) {
      int ans = 0;
        int maxFreq = Integer.MIN_VALUE;
        int[] count = new int[101];

        for(int num : nums) count[num]++;
        for(int num : count)    maxFreq = Math.max(maxFreq, num);        
        for(int num : nums) if(maxFreq == count[num])   ans++;
        return ans;  
    }
}