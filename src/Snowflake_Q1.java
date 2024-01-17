import java.util.Scanner;

public class Snowflake_Q1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numserver = new int[n];

        for(int i=0;i<n;i++){
            numserver[i]= sc.nextInt();
        }
        int[] moneyAllocated = new int[n];

        for(int i=0;i<n;i++){
            moneyAllocated[i]= sc.nextInt();
        }
        int[] sell = new int[n];

        for(int i=0;i<n;i++){
            sell[i]= sc.nextInt();
        }
        int[] upgrade = new int[n];

        for(int i=0;i<n;i++){
            upgrade[i]= sc.nextInt();
        }
        ServerInvestment sol = new ServerInvestment();
        int[] ans;
        ans = sol.getUpgrade(numserver, moneyAllocated, sell, upgrade);
        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }


    }
}
class ServerInvestment{
    public int[] getUpgrade(int[] num_servers, int[] moneyAllocted, int[] sell, int[] upgrade){

        int no_servers = num_servers.length;
        int[] noServerCanBeUpgraded = new int[no_servers];

        for (int i=0; i<no_servers;i++){

            noServerCanBeUpgraded[i] = moneyAllocted[i]/upgrade[i];
            System.out.println(noServerCanBeUpgraded[i]);
            if(noServerCanBeUpgraded[i]<=num_servers[i]){
                int servers = num_servers[i];
                while (servers>noServerCanBeUpgraded[i]){
                    moneyAllocted[i] = sell[i];
                    servers--;
                    noServerCanBeUpgraded[i]++;
                }
            }
            else {
                return noServerCanBeUpgraded;
            }
        }
        return noServerCanBeUpgraded;
    }
}