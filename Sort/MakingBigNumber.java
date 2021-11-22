package Sort;

import java.util.Arrays;
public class MakingBigNumber {

    public static String solution(int[] numbers) {
        String answer = "";
        String[] v=new String[numbers.length];
        for(int i=0;i<numbers.length;i++)
            v[i]=Integer.toString(numbers[i]);
        Arrays.sort(v,(o1,o2)->{
           return (o1+o2).compareTo(o2+o1); 
        });
        for(int i=0;i<v.length;i++)
            answer+=v[i];
        return answer.charAt(0)=='0'?"0":answer;
    }   
    public static void main(String[] args) throws Exception {
        int[] l={0, 0, 0};
        String s=solution(l);
        System.out.println(s);
    }
}
