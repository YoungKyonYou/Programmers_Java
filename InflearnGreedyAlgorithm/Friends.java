package InflearnGreedyAlgorithm;
import java.util.*;

public class Friends {
    public static int[] people ;
    public static int[] rank;
    public static int find(int x) {
        if (people[x] == x)
            return x;
        return people[x] = find(people[x]);
    }

    public static void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        people[yy] = xx;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        people = new int[n + 1];
        rank = new int[n + 1];
        for(int i=0;i<n;i++)
            people[i+1]=i+1;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(solution(a,b));
    }
    public static String solution(int a, int b) {
        if (find(a) != find(b))
            return "NO";
        else
            return "YES";
    }
}