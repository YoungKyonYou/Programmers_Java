package InflearnStackQueue;
import java.util.*;

public class EmergencyRoom2 {
    public static class Patient {
        public int risk;
        public int rank;

        public Patient(int risk, int rank) {
            this.risk = risk;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) 
            queue.add(new Patient(sc.nextInt(), i));
        while(true) {
            Patient temp = queue.poll();
            for (Patient a : queue) {
                if (temp.risk < a.risk) {
                    queue.add(temp);
                    temp = null;
                    break;
                }
            }
            if (temp != null) {
                cnt++;
                if(temp.rank==M)
                    break;
            }
        }
        System.out.println(cnt);
    }
}