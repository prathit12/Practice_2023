// Two Sum Problem


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question_10 {
    public static void main(String[] args) {

        int n = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] arr = new int[n];


        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        Solution_1 s = new Solution_1();
        int[] res = s.twoSum(arr, 4);
        System.out.println(Arrays.toString(res));
    }
}
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
       /* int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){

                if( nums[i]+nums[j]==target){

                    return new int []{i, j};
                }
            }
        }
        return new int[] {}; */
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i=0; i<n; i++){
            numMap.put(nums[i], i);
        }

        for( int i=0;i<n;i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement) && numMap.get(complement) != i){
                return new int[] { i, numMap.get(complement)};
            }
        }
        return new int[] {};
    }
}