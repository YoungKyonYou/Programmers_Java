package InflearnDynamicProgramming;
import java.util.*;

public class StairClimb {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
        System.out.println(answer);
    }
    
    public static int stairs(int num, int target) {
        if(num==target)
            answer++;
        else if (num > target)
            return 0;
        return stairs(num+1, target)+stairs(num+2, target);
    }
    public static int solution(int n) {
        stairs(0, n);
        return answer;
    }
}