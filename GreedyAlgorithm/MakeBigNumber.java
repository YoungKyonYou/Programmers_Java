package GreedyAlgorithm;
import java.util.Stack;
public class MakeBigNumber {
    public static String solution(String number, int k) {
        char[] result=new char[number.length()-k];
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<number.length();i++){
            char c=number.charAt(i);
            while(!stack.isEmpty() && c>stack.peek() && k-->0){
                stack.pop();
            } 
            stack.push(c);
        }
        for(int i=0;i<result.length;i++){
            result[i]=stack.get(i);            
        }
     return new String(result);
    }
    public static void main(String[] args) throws Exception {
        String s="1924";
        int k=2;
        String answer=solution(s,k);
        System.out.println("answer:"+answer);
    }
}
