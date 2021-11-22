import java.io.*;
import java.util.*;

class Problem2 {
    static int cnt = 0;
    static int max = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][50];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int[][] temp = new int[N][50];
        copy(arr, temp, N, M);
        dfs(arr, temp,N, M, K);
        System.out.println(max);

    }

    public static void swap(int[][] arr, int row, int x, int y) {
        int temp = arr[row][x];
        arr[row][x] = arr[row][y];
        arr[row][y] = temp;
    }

    public static void move(int[][] arr, int row, int N, int M) {
        int idx = 0;
        for (int i = 49; i >= 0; i--) {
            if (arr[row][i] != 0) {
                idx = i;
                break;
            }
        }
        if (idx + 1 < 50) {
            for (int i = idx; i >= 0; i--) {
                swap(arr, row, i, i + 1);
            }   
        }
    }
    
    public static int[][] moveReverse(int[][] arr, int row, int N, int M) {
        int idx = 0;
        for (int i = 0; i < 50; i++) {
            if (arr[row][i] != 0) {
                idx = i;
                break;
            }
        }
        if (idx > 0) {
            for (int i = idx; i < 50; i++) {
                swap(arr, row, i - 1, i);
            }
        }

        return arr;
    }

    public static void copy(int[][] arr, int[][] temp, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 50; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }

    public static void print(int[][] arr) {
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void dfs(int[][] arr,int[][] temp, int N, int M, int K) {
        if (K == 0) {
            int c=0;
            for (int i = 0; i < N; i++) {
                if(arr[i][0]!=0){
                    c++;
                }
            }
            if(c==0){
                return;
            }
        
            for (int i = 0; i < 50; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(max, sum);
            }
            print(arr);
            return;
        }
        for (int i = 0; i < N; i++) {
            // print(arr);
            copy(arr,temp,N,M);
            move(arr, i, N, M);
            dfs(arr, temp, N, M, K - 1);
            copy(temp, arr,N,M);
            //arr=moveReverse(arr, i, N, M);
       // print(arr);
        }
    }
}