
import java.util.*;

public class MarbleEscape2 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    

    public static class Coordinate {
        public int rx;
        public int ry;
        public int bx;
        public int by;
        public int count;

        public Coordinate(int rx, int ry, int bx, int by, int count ) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        int[] hole = new int[2];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            arr[i] = str.toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if (arr[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                } else if (arr[i][j] == 'O') {
                    hole[0] = i;
                    hole[1] = j;
                }
            }
        }
        // System.out.println("redX:" + red[0] + " redY:" + red[1]);
        // System.out.println("blueX:" + blue[0] + " blueY:" + blue[1]);
        /*
         * for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) {
         * System.out.print(arr[i][j] + " "); } System.out.println(); }
         */
        //System.out.println("ans:" + solution(arr, red[0], red[1], blue[0], blue[1], N, M, hole[0],hole[1]));
        System.out.println(solution(arr, red[0], red[1], blue[0], blue[1], N, M, hole[0], hole[1]));
    }

    public static void print(char[][] arr, int N, int M, int num) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("num:"+num);
        System.out.println();
        System.out.println();

    }

    public static boolean[][] visitInitialize(boolean[][] temp,int N, int M) {
        boolean[][] newVisit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newVisit[i][j] = temp[i][j];

            }
        }
        return newVisit;
    }

    public static int solution(char[][] arr, int rx, int ry, int bx, int by, int N, int M, int hx, int hy) {
        int ans = Integer.MAX_VALUE;
        List<String> visit = new ArrayList<>();
        Queue<Coordinate> queue = new LinkedList<>();
        
       // boolean[][] rsVisit=new boolean[N][M];
       // boolean[][] bsVisit = new boolean[N][M];
        visit.add(Integer.toString(rx) + Integer.toString(ry) + Integer.toString(bx) + Integer.toString(by));
        //rsVisit[rx][ry] = true;
       // bsVisit[bx][by] = true;
        queue.add(new Coordinate(rx, ry, bx, by, 0));
        int rFlag = 0;
        int bFlag = 0;
        while (!queue.isEmpty()) {
            Coordinate cord = queue.poll();
            int prx = cord.rx;
            int pry = cord.ry;
            int pbx = cord.bx;
            int pby = cord.by;
            int cc = cord.count;
           // rsVisit = visitInitialize(cord.rVisit, N, M);
            //bsVisit = visitInitialize(cord.bVisit, N, M);
            rFlag = 0;
            bFlag = 0;
            // 상우하좌
            for (int i = 0; i < 4; i++) {
                arr[prx][pry] = 'R';
                arr[pbx][pby] = 'B';
                arr[hx][hy] = 'O';
                rFlag = 0;
                bFlag = 0;
                print(arr, N, M,cc);
                int tempRX = prx+dx[i];
                int tempRY = pry+dy[i];
                int tempBX = pbx+dx[i];
                int tempBY = pby+dy[i];
                
               while (tempRX >= 0 && tempRX < N && tempRY >= 0 && tempRY < M && arr[tempRX][tempRY] != '#'
                       && arr[tempRX][tempRY] != 'B' && rFlag == 0) {

                   arr[tempRX - dx[i]][tempRY - dy[i]] = '.';

                   if (arr[tempRX][tempRY] == 'O') {
                       rFlag = 1;
                       arr[tempRX][tempRY] = 'O';

                   } else {
                       arr[tempRX][tempRY] = 'R';
                   }
                   tempRX += dx[i];
                   tempRY += dy[i];
                   print(arr, N, M,cc);
               }

               while (tempBX >= 0 && tempBX < N && tempBY >= 0 && tempBY < M && arr[tempBX][tempBY] != '#'
                       && arr[tempBX][tempBY] != 'R' && bFlag == 0) {
                   arr[tempBX - dx[i]][tempBY - dy[i]] = '.';

                   if (arr[tempBX][tempBY] == 'O') {
                       bFlag = 1;

                   } else {
                       arr[tempBX][tempBY] = 'B';
                   }
                   tempBX += dx[i];
                   tempBY += dy[i];

                   print(arr, N, M, cc);
               }


               while (tempRX >= 0 && tempRX < N && tempRY >= 0 && tempRY < M && arr[tempRX][tempRY] != '#'
                       && arr[tempRX][tempRY] != 'B' && rFlag == 0) {

                   arr[tempRX - dx[i]][tempRY - dy[i]] = '.';

                   if (arr[tempRX][tempRY] == 'O') {
                       rFlag = 1;
                       arr[tempRX][tempRY] = 'O';

                   } else {
                       arr[tempRX][tempRY] = 'R';
                   }
                   tempRX += dx[i];
                   tempRY += dy[i];
                   print(arr, N, M, cc);
               }



               while (tempBX >= 0 && tempBX < N && tempBY >= 0 && tempBY < M && arr[tempBX][tempBY] != '#'
                       && arr[tempBX][tempBY] != 'R' && bFlag == 0) {
                   arr[tempBX - dx[i]][tempBY - dy[i]] = '.';

                   if (arr[tempBX][tempBY] == 'O') {
                       bFlag = 1;

                   } else {
                       arr[tempBX][tempBY] = 'B';
                   }
                   tempBX += dx[i];
                   tempBY += dy[i];

                   print(arr, N, M, cc);
               }
               

                if (tempRX-dx[i] != prx || tempRY-dy[i] != pry || tempBX-dx[i] != pbx || tempBY-dy[i] != pby) {
                    if (rFlag == 1 && bFlag != 1) {
                        ans = Math.min(ans, cc);
                    }
                    String str = Integer.toString(tempRX - dx[i]) + Integer.toString(tempRY - dy[i])
                            + Integer.toString(tempBX - dx[i]) + Integer.toString(tempBY - dy[i]);
                    System.out.println("str:" + str);
                    if (rFlag != 1 && bFlag != 1 && !visit.contains(str)) {
                      //  rsVisit[tempRX - dx[i]][tempRY - dy[i]] = true;
                      //  bsVisit[tempBX - dx[i]][tempBY - dy[i]] = true;
                      visit.add(str);
                        queue.add(new Coordinate(tempRX-dx[i], tempRY-dy[i], tempBX-dx[i], tempBY-dy[i], cc + 1));
                    }

                }
                arr[tempRX-dx[i]][tempRY-dy[i]] = '.';
                arr[tempBX-dx[i]][tempBY-dy[i]] = '.';
                print(arr, N, M,cc);
            }
            
        }
        if (ans!=Integer.MAX_VALUE) {
            return ans + 1;
        }
        return -1;
    }
}