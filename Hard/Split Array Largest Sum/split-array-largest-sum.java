//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static boolean isPossible(int arr[], int N, int mid,int K){
        int count = 1,sum = 0;
        for(int i = 0; i < N; i++){
            sum +=  arr[i];
            if(sum>mid){
                count++;
                sum = arr[i];
            }
        }
        return K >= count;
    }
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int low = Integer.MIN_VALUE,high = 0, mid = 0,ans = Integer.MAX_VALUE;
        for(int i=0; i<N;i++){
            low = Math.max(arr[i],low);
            high += arr[i];
        }
        while(low<=high){
            mid = (low+high)/2;
            if(isPossible(arr,N,mid,K)){
                ans = Math.min(ans,mid);
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
};