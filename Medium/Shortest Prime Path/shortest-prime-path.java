//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    int solve(int num1,int num2){
        //code here
        if (num1 == num2) {
            return 0;
        }

        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num1);
        visited[num1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k <= 9; k++) {
                        if (j == 0 && k == 0) {
                            continue; // Skip leading zero
                        }

                        int[] digits = getDigits(current);
                        digits[j] = k;

                        int nextNumber = getNumber(digits);

                        if (nextNumber == num2) {
                            return steps + 1;
                        }

                        if (isPrime(nextNumber) && !visited[nextNumber]) {
                            visited[nextNumber] = true;
                            queue.offer(nextNumber);
                        }
                    }
                }
            }

            steps++;
        }

        return -1; // Unreachable
    }

    private int[] getDigits(int number) {
        int[] digits = new int[4];
        for (int i = 3; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private int getNumber(int[] digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends