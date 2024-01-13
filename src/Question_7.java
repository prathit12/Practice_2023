class MaximumSubarraySum{
    public int sum (int[] arr, int k){
        int n = arr.length;

        int[] memo = new int[n];
        for (int i=1;i<n;i++){
            memo[i] = Math.max(arr[i], memo[i-i]+arr[i]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int val : memo){
            maxSum=Math.max(maxSum, val);
        }
        return maxSum;
    }
}
public class Question_7 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k=3;
        MaximumSubarraySum sol = new MaximumSubarraySum();

        int res = sol.sum(arr, k);
        System.out.println(res);
    }

}
