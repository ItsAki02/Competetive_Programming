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
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i =0; i <= n; i++)
        adj.add(new ArrayList<Integer>());
        for(int x[] : edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        int mm[] = new int[n+1];
        Arrays.fill(mm,0);
        int count = 0, taken = 0, v =1;
        return help(count,taken,v,n,m,adj,mm);
    }
    
    static int help(int count, int taken, int v, int n, int m,ArrayList<ArrayList<Integer>> adj, int []mm){
        if(count==m){
            return taken;
        }
        if(v==n+1) return Integer.MAX_VALUE;
        boolean aa = false;
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        b = help(count,taken,v+1,n,m,adj,mm);
        count += adj.get(v).size();
        for(Integer x : adj.get(v)){
            if(mm[x] != 0) count--;
        }
        mm[v]++;
        a = help(count,taken+1,v+1,n,m,adj,mm);
        mm[v]--;
        return Math.min(a,b);
    }
}
        
