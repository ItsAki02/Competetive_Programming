class Solution {
    public String reverseWords(String s) {
        if(s == null)
        return s;

        String str = s.trim();

        String[] rev = str.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i = rev.length-1; i >= 0; i--){
            sb.append(rev[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}