package KDigital;
import java.util.*;
public class  problem1{
    public static void main(String[] args) throws Exception {
        int[] d = { 2, 2, 4, 3};
        int m = 6;
        int ans = solution(d,m);
        System.out.println("answer:"+ans);
    }
    public static int solution(int[] d, int m) {
        int answer = 0, box = 1;
        for (int i = 0; i < d.length; i++) {
            if (d[i] >= box) {
                m -= box;
                box *= 2;
            } else 
                box = 1;
            answer++;
            if (m <= 0)
                break;
        }
        return m <= 0 ? answer : -1;
    }
}