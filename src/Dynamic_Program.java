import java.util.Scanner;

public class Dynamic_Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for which fibbonacci number can calculated");
        int n = sc.nextInt();
        System.out.println(fibb(n));
    }
    public static int fibb(int n){
        int[] memo = new int[1000];
        if(n==1 || n == 2){
            return 1;
        }
        else {
            memo[n] = fibb(n-1)+fibb(n-2);
            System.out.println(n+" "+memo[n]);
        }
       return memo[n];
    }
}
