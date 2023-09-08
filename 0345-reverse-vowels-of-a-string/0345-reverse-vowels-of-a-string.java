class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length -1;
        while(start < end){
            if(!isVowel(arr[start])){
                start++;
            }else if(!isVowel(arr[end])){
                end--;

            }else{
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return  String.valueOf(arr);
        }
        boolean isVowel(char ch){
          if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;  
        }
    
}