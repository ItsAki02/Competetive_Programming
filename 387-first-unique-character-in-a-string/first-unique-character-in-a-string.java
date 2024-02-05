class Solution {
    public int firstUniqChar(String s) {
         if(s.length()==0) {
            return -1;
        }
        int[] freq = new int[26]; // Stores the frequency of string s
        
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(freq[ch-'a']==1) {
                return i;
            }
        }
        return -1;
        
    }
}