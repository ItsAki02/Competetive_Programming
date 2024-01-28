//{ Driver Code Starts
import java.io.*;
import java.util.*;
public class Main{
 
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());
        Solution soln = new Solution();
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            ot.println(soln.findNthNumer(n, k));
        }
        ot.close();
    }
  
} 
// } Driver Code Ends


class Solution{
    private long nCr(long n, long r) {
        if (r > n) return 0;
        if (r == 0 || n == r) return 1;

        double res = 0;
        for (long i = 0; i < r; i++) {
            res += Math.log(n - i) - Math.log(i + 1);
        }
        return Math.round(Math.exp(res));
    }

    private long noBitRequired(long n, long k) {
        long l = 1, r = 64;
        long ans = -1;
        while (l <= r) {
            long mid = (l + r) / 2;
            long total = 0;
            for (long i = 0; i <= k; i++) {
                total += nCr(mid, i);
                if (total > n)
                    break;
            }
            if (total >= n) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    public long findNthNumer(int n, int k){
        // Code Here.
        long len = noBitRequired(n, k);
        StringBuilder ans = new StringBuilder();
        n--;

        for (int pos = 0; pos < len; pos++) {
            int rem = (int) (len - pos) - 1;
            long total = 0;
            for (long i = 0; i <= k; i++) {
                total += nCr(rem, i);
            }
            if (total <= n) {
                n -= total;
                ans.append("1");
                k--;
            } else
                ans.append("0");
        }

        long res = 0;
        long power = 1;
        for (int i = (int) len - 1; i >= 0; i--) {
            if (ans.charAt(i) == '1')
                res += power;

            power *= 2;
        }

        return res;
    }
}