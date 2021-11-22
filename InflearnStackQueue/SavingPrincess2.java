package InflearnStackQueue;
import java.util.*;
public class  SavingPrincess2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) 
            queue.add(i);
        int cnt=0;
        while (queue.size() != 1) {
            int temp = queue.poll();
            cnt++;
            if(cnt%M==0)
                continue;
            queue.add(temp);
        }
        System.out.println(queue.peek());
    }
}