class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        int MaxCandies = Integer.MIN_VALUE;
        for(int i = 0; i < candies.length; i++){
            if(candies[i] > MaxCandies)
            MaxCandies = candies[i];
        }
        for(int i = 0 ; i < candies.length; i++){
            if(candies[i] + extraCandies >= MaxCandies)
            list.add(true);
            else
            list.add(false);
            
        }
        return list;
    }
}