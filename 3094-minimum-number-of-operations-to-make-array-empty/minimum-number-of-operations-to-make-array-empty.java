class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        int count = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if(freq == 1) return -1;

            count += freq / 3;
            if( freq % 3 != 0) count++;
        }

        return count;
    }
}