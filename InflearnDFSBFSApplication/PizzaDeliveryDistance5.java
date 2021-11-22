package InflearnDFSBFSApplication;

import java.util.*;

public class PizzaDeliveryDistance5 {
    public static class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static public int[][] map;
    public static int fans = Integer.MAX_VALUE;
    public static PriorityQueue<Integer> pq;
    public static List<Point> pList;
    public static List<Point> home;
    public static int[] combi;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new int[N][N];
        home=new LinkedList<>();
        pList = new LinkedList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                if (num == 2) {
                    map[i][j] = -2;
                    pList.add(new Point(i, j));
                }
                else 
                    map[i][j] = num;
                if(num==1)
                    home.add(new Point(i, j));
            }
        combi=new int[M];
        solution(map, 0, N, M, pList,0);
        System.out.println(fans);
    }
    public static void solution(int[][] map, int L, int N, int M, List<Point> list, int s) {
        if (L == M) {
          //  System.out.println(Arrays.toString(combi));
          //  System.out.println();
         //   System.out.println();
            int total = 0;
            for (int i = 0; i < home.size(); i++) {
                int d = Integer.MAX_VALUE;
                Point ph = home.get(i);
                int hx = ph.x;
                int hy = ph.y;
                for (int k = 0; k < combi.length; k++) {
                    Point p = list.get(combi[k]);
                    int xx = p.x;
                    int yy = p.y;
                    System.out.println("xx:"+xx+" yy:"+yy);
                    d = Math.min(d, ((Integer) Math.abs(hx - xx)) + ((Integer) Math.abs(hy - yy)));
                }
                total += d;
                System.out.println("d:" + d+" total:"+total);
            }
            System.out.println("total:"+total);
            fans = Math.min(fans, total);
        } else {
            for(int i=s;i<list.size();i++){
                combi[L]=i;
                solution(map, L + 1, N, M, list,i+1);
            }
        }
    }
}