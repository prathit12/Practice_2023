import java.util.Scanner;

public class Snowflake_Q3 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String src;
        String tar;
        src =  sc.nextLine();
        tar = sc.nextLine();
        StringBuilder srcB =  new StringBuilder(src);
        StringBuilder tarB =  new StringBuilder(tar);
        substringTransformation sol = new substringTransformation();
        int n = sol.numOfWays(srcB, tarB, 2);
        System.out.println(n);
    }
}
class  substringTransformation{
    public int numOfWays(StringBuilder src, StringBuilder target, int k) {
        int count = 0;
        int n = src.length();

        // Check if src can be transformed into target by taking a substring from the start
        // and placing it at the end for each rotation
        for (int i = 0; i < n; i++) {
            String rotatedSrc = rotateString(src.toString(), i);
            if (canTransform(rotatedSrc, target.toString(), k)) {
                count++;
            }
        }

        return count;
    }

    // Rotate the string to the right by k positions
    private String rotateString(String s, int k) {
        int n = s.length();
        k = k % n;
        return s.substring(n - k) + s.substring(0, n - k);
    }

    // Check if src can be transformed into target in exactly k steps
    private boolean canTransform(String src, String target, int k) {
        return rotateString(src, k).equals(target);
    }
}