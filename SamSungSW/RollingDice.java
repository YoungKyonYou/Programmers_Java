
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class RollingDice {
    public static class Dice {
        public int bottom;
        public int right;
        public int left;
        public int top;
        public int up;
        public int down;

        public Dice(int left,int right, int up, int bottom, int top,int down){
            this.left = left;
            this.right = right;
            this.up = up;
            this.bottom = bottom;
            this.top = top;
            this.down = down;
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[] direction = new int[K];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            direction[i] = Integer.parseInt(token.nextToken());
        }
        Dice dice=new Dice(0,0,0,0,0,0);
        arr[x][y] = 0;
        //남,동,북,남 
        int[] px={0,0,0,-1,1};
        int[] py = {0, 1, -1, 0, 0};
        List<Integer> ans = new ArrayList<>();
        int ix = x;
        int iy = y;
        for (int i = 0; i < K; i++) {
            ix += px[direction[i]];
            iy += py[direction[i]];
            if (ix < 0 || ix >=N || iy < 0 || iy >=M) {
                ix -= px[direction[i]];
                iy -= py[direction[i]];
                continue;
            }
            if (direction[i] == 1) {
                dice=new Dice(dice.bottom, dice.top,dice.up,dice.right,dice.left,dice.down);
            } else if (direction[i] == 2) {
                dice=new Dice(dice.top, dice.bottom,dice.up,dice.left,dice.right,dice.down);
            } else if (direction[i] == 3) {
                dice=new Dice(dice.left, dice.right,dice.top,dice.up,dice.down,dice.bottom);
            } else {
                dice=new Dice(dice.left, dice.right,dice.bottom,dice.down,dice.up,dice.top);
            }
            
            if (arr[ix][iy] == 0) {
                arr[ix][iy] = dice.bottom;
            } else {
                dice.bottom = arr[ix][iy];
                arr[ix][iy] = 0;
            }
            ans.add(dice.top);
        }
        for (int a : ans) {
            System.out.println(a);
        }

    }
}