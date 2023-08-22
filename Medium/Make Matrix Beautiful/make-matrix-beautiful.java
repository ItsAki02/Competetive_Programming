//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int n, int[][] matrix) {
        // code here
       int[] rowSum = new int[n];
       int[] colSum = new int[n];
       
       for(int i = 0; i < n ; ++i){
           for(int j = 0; j < n; ++j){
               rowSum[i] += matrix[i][j];
               colSum[j] += matrix[i][j];
           }
       }
           int maxSum = 0;
           for(int i = 0; i < n ; ++i){
               maxSum = Math.max(maxSum, rowSum[i]);
               maxSum = Math.max(maxSum, colSum[i]);
           }
           int count = 0;
           for(int i = 0, j =0 ; i < n && j < n;){
               int diff = Math.min(maxSum - rowSum[i], maxSum - colSum[j]);
               matrix[i][j] += diff;
               rowSum[i] += diff;
               colSum[j] += diff;
               
               count += diff;
           
           if(rowSum[i] == maxSum)
           ++i;
           
           if(colSum[j] == maxSum)
           ++j;
       }
       return count;
    }
}

        
