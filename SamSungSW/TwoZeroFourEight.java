
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TwoZeroFourEight {
    static int max = 5;
    static int num;
    static int ans = -1;

    public static class Node {
        public int[][] arr;
        public int count;

        public Node(int[][] arr, int count) {
            this.arr = arr;
            this.count = count;
        }
    }

    public static void swap(int[][] arr, int x, int y, int xx, int yy) {
        int temp = arr[x][y];
        arr[x][y] = arr[xx][yy];
        arr[xx][yy] = temp;
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean visit[][];
        num = Integer.parseInt(st.nextToken());
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            String token = br.readLine();
            String[] ss = token.split(" ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(ss[j]);
            }
        }
      
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(arr, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 상 좌 우 하 순서로
            for (int i=0;i<4;i++) {
                visit = new boolean[num][num];
                int[][] tempArr = new int[num][num];
                
                /*for (int m = 0; m < num; m++) {
                    for (int n = 0; n < num; n++) {
                        tempArr[m][n] = node.arr[m][n];
                    }
                }*/
                int cc = node.count;
                if (cc == 5) {
                    for (int p = 0; p < num; p++) {
                        for (int q = 0; q < num; q++) {
                            ans = Math.max(ans, tempArr[p][q]);
                        }
                    }
                    continue;
                }
                //상
                if (i == 0) {
                    for (int r = 0; r < num; r++) {
                        for (int j = 1; j < num; j++) {
                            if (tempArr[j][r] != 0) {
                                int t = j;
                                while (t > 0 && tempArr[t - 1][r] == 0) {
                                    t--;
                                }
                                if (tempArr[t][r] != tempArr[j][r]) {
                                    tempArr[t][r] = tempArr[j][r];
                                    tempArr[j][r] = 0;
                                }
                                if (t - 1 >= 0 && tempArr[t - 1][r] == tempArr[t][r] && !visit[t - 1][r]) {
                                    tempArr[t - 1][r] *= 2;
                                    tempArr[t][r] = 0;
                                    visit[t - 1][r] = true;
                                }
                            }
                        }
                    }
                    
                } else if (i == 1) {
                    for (int r = 0; r < num; r++) {
                        for (int j = 1; j < num; j++) {
                            if (tempArr[r][j] != 0) {
                                int t = j;
                                while (t > 0 && tempArr[r][t - 1] == 0) {
                                    t--;
                                }
                                if (tempArr[r][j] != tempArr[r][t]) {
                                    tempArr[r][t] = tempArr[r][j];
                                    tempArr[r][j] = 0;
                                }
                                if (t - 1 >= 0 && tempArr[r][t - 1] == tempArr[r][t] && !visit[r][t - 1]) {
                                    tempArr[r][t - 1] *= 2;
                                    tempArr[r][t] = 0;
                                    visit[r][t - 1] = true;
                                }
                               
                            }
                        }
                    }

                } else if (i == 2) {
                    for (int r = 0; r < num; r++) {
                        for (int j = num - 2; j >= 0; j--) {
                            if (tempArr[r][j] != 0) {
                                int t = j;
                                while (t < num - 1 && tempArr[r][t + 1] == 0) {
                                    t++;
                                }
                                if (tempArr[r][t] != tempArr[r][j]) {
                                    tempArr[r][t] = tempArr[r][j];
                                    tempArr[r][j] = 0;
                                }
                                if (t + 1 < num && tempArr[r][t + 1] == tempArr[r][t] && !visit[r][t + 1]) {
                                    tempArr[r][t + 1] *= 2;
                                    tempArr[r][t] = 0;
                                    visit[r][t + 1] = true;
                                }
                            }
                        }
                    }

                } else if (i == 3) {
                    for (int r = 0; r < num; r++) {
                        for (int j = num - 2; j >= 0; j--) {
                            if (tempArr[j][r] != 0) {
                                int t = j;
                                while (t < num - 1 && tempArr[t + 1][r] == 0) {
                                    t++;
                                }
                                if (tempArr[t][r] != tempArr[j][r]) {
                                    tempArr[t][r] = tempArr[j][r];
                                    tempArr[j][r] = 0;
                                }
                                if (t + 1 < num && tempArr[t + 1][r] == tempArr[t][r] && !visit[t + 1][r]) {
                                    tempArr[t + 1][r] *= 2;
                                    tempArr[t][r] = 0;
                                    visit[t + 1][r] = true;
                                }
                            }
                        }
                    }

                }
                
                queue.add(new Node(tempArr, cc + 1));
            }

        }

        System.out.println(ans);
    }

}