//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        //code here
        int n = s.length();
         if (n == 0) 
            return -1; 
       
        // If there is single digit 
        if (n == 1) 
            return ((s.charAt(0)-'0') % 8 == 0) ? 1 : -1; 
       
        // If there is double digit 
        if (n == 2) 
            return (((s.charAt(n-2)-'0')*10 + (s.charAt(n-1)-'0')) % 8 == 0) ? 1 : -1; 
       
        // If number formed by last three digits is 
        // divisible by 8. 
        int last = s.charAt(n-1) - '0'; 
        int second_last = s.charAt(n-2) - '0'; 
        int third_last = s.charAt(n-3) - '0'; 
       
        return ((third_last * 100 + second_last * 10 + last) % 8 == 0) ? 1 : -1;
    }
}
