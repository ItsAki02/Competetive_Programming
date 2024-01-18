//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
         
        // Create intervals based on the sprinkler range
          int[][] intervals = new int[n][2];
        int intervalCount = 0;
        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                intervals[intervalCount][0] = Math.max(0, i - gallery[i]);
                intervals[intervalCount][1] = Math.min(n - 1, i + gallery[i]);
                intervalCount++;
            }
        }

        // Resize the intervals array to the actual number of intervals
        intervals = Arrays.copyOf(intervals, intervalCount);

        // Sort intervals based on starting points in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int sprinklersOn = 0;
        int start = 0;
        int i = 0;

        while (start < n) {
            int maxEnd = -1;

            // Find the interval with the maximum endpoint that covers the current starting point
            while (i < intervalCount && intervals[i][0] <= start) {
                maxEnd = Math.max(maxEnd, intervals[i][1]);
                i++;
            }

            // If no interval covers the current starting point, it's not possible to water the entire gallery
            if (maxEnd == -1) {
                return -1;
            }

            // Turn on the sprinkler at the chosen interval
            sprinklersOn++;
            start = maxEnd + 1;
        }

        return sprinklersOn;
    }
}
