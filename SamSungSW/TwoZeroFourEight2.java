
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class TwoZeroFourEight2 {
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

    public static void print(int[][] arr, int num) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(arr, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[][] tempArr = new int[num][num];
            for (int i = 0; i < arr.length; i++) {
                tempArr[i] = Arrays.copyOf(node.arr[i], node.arr[i].length);
            }
            int cc = node.count;
            if (cc == 5) {
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        ans = Math.max(ans, tempArr[i][j]);
                    }
                }
                continue;
            }

            //상 좌 하 우 순서로
            for (int i = 0; i < 4; i++) {
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
                            }
                        }
                    }



                    for (int r = 0; r < num - 1; r++) {
                        for (int j = r; j < num - 1; j++) {
                            for (int k = 0; k < num; k++) {
                                if (tempArr[j][k] == tempArr[j + 1][k]) {
                                    tempArr[j][k] *= 2;
                                    tempArr[j + 1][k] = 0;
                                } else if (tempArr[j][k] == 0) {
                                    swap(tempArr, j, k, j + 1, k);
                                }
                            }
                        }
                    }

                } else if (i == 1) {
                    for (int r = 0; r < num; r++) {
                        for (int j = 1; j < num; j++) {
                            if (tempArr[r][j] != 0) {
                                int t = j;
                                while (t >0 && tempArr[r][t - 1] == 0) {
                                    t--;
                                }
                                if (tempArr[r][j] != tempArr[r][t]) {
                                    tempArr[r][t] = tempArr[r][j];
                                    tempArr[r][j] = 0;
                                }
                            }
                        }
                    }





                    for (int r = 0; r < num - 1; r++) {
                        for (int j = r; j < num; j++) {
                            for (int k = 0; k < num - 1; k++) {
                                if (tempArr[j][k] == tempArr[j][k + 1]) {
                                    tempArr[j][k] *= 2;
                                    tempArr[j][k + 1] = 0;
                                } else if (tempArr[j][k] == 0) {
                                    swap(tempArr, j, k, j, k + 1);
                                }
                            }
                        }
                    }
                } else if (i == 2) {
                    for (int r = 0; r < num; r++) {
                        for (int j = num - 2; j >=0; j--) {
                            if (tempArr[r][j] != 0) {
                                int t = j;
                                while (t < num-1 && tempArr[r][t+1] == 0) {
                                    t++;
                                }
                                if (tempArr[r][t] != tempArr[r][j]) {
                                    tempArr[r][t] = tempArr[r][j];
                                    tempArr[r][j] = 0;
                                }
                            }
                        }
                    }





                    for (int r = num - 1; r > 0; r--) {
                        for (int j = r; j > 0; j--) {
                            for (int k = 0; k < num; k++) {
                                if (tempArr[j][k] == tempArr[j - 1][k]) {
                                    tempArr[j][k] *= 2;
                                    tempArr[j - 1][k] = 0;
                                } else if (tempArr[j][k] == 0) {
                                    swap(tempArr, j, k, j - 1, k);
                                }
                            }
                        }
                    }
                } else if (i == 3) {
                    for (int r = 0; r < num; r++) {
                        for (int j = num-2; j>=0; j--) {
                            if (tempArr[j][r] != 0) {
                                int t = j;
                                while (t < num - 1 && tempArr[t + 1][r] == 0) {
                                    t++;
                                }
                                if (tempArr[t][r] != tempArr[j][r]) {
                                    tempArr[t][r] = tempArr[j][r];
                                    tempArr[j][r] = 0;
                                }
                            }
                        }
                    }



                    for (int r = num - 1; r > 0; r--) {
                        for (int j = r; j >= 0; j--) {
                            for (int k = num - 1; k > 0; k--) {
                                if (tempArr[j][k] == tempArr[j][k - 1]) {
                                    tempArr[j][k - 1] *= 2;
                                    tempArr[j][k] = 0;
                                } else if (tempArr[j][k] == 0) {
                                    swap(tempArr, j, k, j, k - 1);
                                }
                            }
                        }
                    }
                }
                print(tempArr, num);
                queue.add(new Node(tempArr, cc + 1));
            }

        }


        System.out.println(ans);
    }

}