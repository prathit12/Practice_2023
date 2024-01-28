public class Question_11 {
    public static void main(String[] args) {
        int x = -121;
        Solution_2 sol = new Solution_2();
        System.out.println(sol.isPalindrome(x));

    }
}
class Solution_2 {
    public boolean isPalindrome(int x) {

        String str;
        str=Integer.toString(x);
        int n = str.length();
        for (int i = 0; i< n/2; i++){
            if(str.charAt(i)!= str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}