import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of series:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n;i++){
            nums[i] = sc.nextInt();
        }
        Solution s = new Solution();
        System.out.println(s.numberOfArithmeticSlices(nums));
    }
}
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;

        Map<Integer, Integer>[] dp = new HashMap[n];

        for(int i =0 ;i<n; i++){
            dp[i] = new HashMap<>();
            for(int j =0;j<i;j++){
                long diff = (long) nums[i] - nums[j];

                if (diff>=Integer.MIN_VALUE && diff<=Integer.MAX_VALUE){
                    int d = (int) diff;
                    int cnt = dp[j].getOrDefault(d,0);
                    res+=cnt;
                    dp[i].put(d, dp[i].getOrDefault(d,0)+cnt+1);
                }
            }

        }
        return res;
    }
}