import java.util.Scanner;
// GridTraveller in 2D space with end state as 1,1 and start state is give by user!!
public class DP_GridTraveller {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();  //take m in mxn
        int n = sc.nextInt(); // Take n in mxn
        int[][] memo = new int[m+1][n+1];
        System.out.println(Grid(m,n,memo));

    }
    public static int Grid(int m, int n, int[][] memo){

        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        if (m==1 && n==1){
            return 1;
        }
        if (m==0||n==0) {
            return 0;
        }
        memo[m][n]=Grid(m-1,n,memo)+Grid(m,n-1,memo);
        return memo[m][n];
    }
}

