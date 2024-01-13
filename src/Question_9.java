// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.ArrayList;
import java.util.List;

public class Question_9 {
    public static void main(String[] args) {
        int n = 3;
        combination c = new combination();
        System.out.println(c.paranthesis(n));
    }
}
class combination{
    public List<String> paranthesis(int n) {
       List<String> res  = new ArrayList<>();
       generate(n,n,res,"");
       return res;
    }

    public void generate(int left, int right, List<String> res, String curr){

        if(left == 0 && right == 0){
            res.add(curr);
        }

        if (left>0){
            generate(left-1, right, res, curr+"(" );
        }
        if(right>left ){
            generate( left, right-1, res, curr+")");
        }
    }
}
