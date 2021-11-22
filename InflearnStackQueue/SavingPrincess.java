package InflearnStackQueue;
import java.util.*;
public class  SavingPrincess{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) 
            list.add(i);    
        int cnt=1;
        while(list.size()!=1){
            for (int j=0;j<list.size();j++) {
                if (cnt % M == 0) {
                    Integer temp = list.get(j);
                    list.remove(temp);
                    j--;
                }
                cnt++;
            }
        }
        System.out.println(list.peek());

    }
    public static void solution() {

    }
}