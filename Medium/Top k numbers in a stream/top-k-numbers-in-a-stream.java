//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


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
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> distinctNumbers = new PriorityQueue<>(
                (x, y) -> frequency.get(x).equals(frequency.get(y)) ? Integer.compare(x, y) : Integer.compare(frequency.get(y), frequency.get(x))
        );

        for (int i = 0; i < N; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
            distinctNumbers.clear();  // Clear the PriorityQueue at the beginning of each iteration
            distinctNumbers.addAll(frequency.keySet()); // Add distinct numbers up to this point

            ArrayList<Integer> currentResult = new ArrayList<>();
            PriorityQueue<Integer> sortedNumbers = new PriorityQueue<>(distinctNumbers);

            int count = Math.min(K, sortedNumbers.size());
            for (int j = 0; j < count; j++) {
                currentResult.add(sortedNumbers.poll());
            }

            result.add(currentResult);
        }

        return result;
    }
}
        
