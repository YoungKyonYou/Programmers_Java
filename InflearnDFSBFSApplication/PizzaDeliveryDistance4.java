package InflearnDFSBFSApplication;

import java.util.*;

public class PizzaDeliveryDistance4 {
    public static class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static public int[][] map;
    public static int total = 0;
    public static int fans = Integer.MAX_VALUE;
    public static PriorityQueue<Integer> pq;
    public static List<Point> list;
    public static List<Point> home;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new int[N][N];
        home=new LinkedList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                if (num == 2) 
                    map[i][j] = -2;
                else 
                    map[i][j] = num;
                if(num==1)
                    home.add(new Point(i, j));
            }
        list = new LinkedList<>();
        solution(map, 0, N, M, list,0,0);
        System.out.println(fans);
    }
    public static void solution(int[][] map, int L, int N, int M, List<Point> list, int px, int py) {
        if (L == M) {
            pq = new PriorityQueue<>();
            int len = list.size();
            for (int i = 0; i < home.size(); i++) {
                Point ph = home.get(i);
                int hx = ph.x;
                int hy = ph.y;
                for (int k = 0; k < len; k++) {
                    Point p = list.get(k);
                    int xx = p.x;
                    int yy = p.y;
                    pq.add(((Integer) Math.abs(hx - xx)) + ((Integer) Math.abs(hy - yy)));
                }
                total += pq.poll();
            }
            if(total!=0)
                fans = Math.min(fans, total);
            total = 0;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -2) {
                        map[i][j] = 2;
                        if (L + 1 <= M)
                            list.add(new Point(i, j));
                        solution(map, L + 1, N, M, list, i, j);
                        list = new LinkedList<>();
                        map[i][j] = -2;
                    }
                }
            }   
        }
    }
}