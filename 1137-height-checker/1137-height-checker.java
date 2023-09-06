class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        int  element = 0;
        for(int i = 0 ; i < expected.length; i++){
             expected[i] = heights[i];
        }
                    Arrays.sort(heights);
        
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expected[i])
                element++;
        }
        return element;

        
    }
}