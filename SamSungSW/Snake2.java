
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Snake2 {
    static int[] ci = { 0, 1, 0, -1 };
    static int[] cj = { 1, 0, -1, 0 };
    public static class Direction {
        public int seconds;
        public char direction;

        public Direction(int seconds, char direction) {
            this.seconds = seconds;
            this.direction = direction;
        }
    }

    public static class SnakeLength {
        public int x;
        public int y;

        public SnakeLength(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Queue<Direction> direction = new LinkedList<>();
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[K][K];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken()) - 1;
            int y = Integer.parseInt(token.nextToken()) - 1;
            map[x][y] = 1;
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(token.nextToken());
            char d = token.nextToken().charAt(0);
            direction.add(new Direction(s, d));

        }
        System.out.println(solution(map, direction, K));

    }

    public static void draw(LinkedList<SnakeLength> snakeLength, boolean[][] visit, int K) {
        for (SnakeLength sn : snakeLength) {
            int x = sn.x;
            int y = sn.y;
            visit[x][y] = true;
        }

    }

    public static int solution(int[][] map, Queue<Direction> direction, int K) {
        LinkedList<SnakeLength> snake = new LinkedList<>();
        boolean[][] visit = new boolean[K][K];
        int ans = 0;
        visit[0][0] = true;
        snake.add(new SnakeLength(0, 0));
        Direction d = direction.poll();
        int s = d.seconds;
        char c = d.direction;
        int x = 0;
        int y = 0;
        int D = 0;
        int start = 0;
        int end = s;
        while (true) {
            // y만 +로 증가
            if (D == 0) {
                for (int i = start; i < end; i++) {
                    ans++;
                    if (x < 0 || x >= K || y+1 < 0 || y+1 >= K) {
                        return ans;
                    }
                    if (visit[x][y+1]) {
                        return ans;
                    }
                    if (map[x][y + 1] != 1) {
                        visit[snake.getFirst().x][snake.getFirst().y] = false;
                        int xx = snake.getLast().x;
                        int yy = snake.getLast().y;
                        snake.removeFirst();
                        snake.add(new SnakeLength(xx, yy+1));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                        
                    } else {
                        snake.add(new SnakeLength(snake.getLast().x, snake.getLast().y + 1));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                        map[snake.getLast().x][snake.getLast().y] = 0;
                    }
                    x = snake.getLast().x;

                    y= snake.getLast().y;
                    draw(snake, visit, K);
         
                }
                if (c == 'D') {
                    D = 2;
                } else {
                    D = 3;
                }

                // y만 -로 증가
            } else if (D == 1) {
                for (int i = start; i < end; i++) {
                    ans++;
                    if (x < 0 || x >= K || y-1 < 0 || y-1 >= K) {
                        return ans;
                    }
                    if (visit[x][y-1]) {
                        return ans;
                    }

                    if (map[x][y-1] != 1) {
                        visit[snake.getFirst().x][snake.getFirst().y] = false;
                        int xx = snake.getLast().x;
                        int yy = snake.getLast().y;
                        snake.removeFirst();
                        snake.add(new SnakeLength(xx, yy-1));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                    } else {
                        snake.add(new SnakeLength(x, y - 1));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                        map[snake.getLast().x][snake.getLast().y] = 0;
                    }
                    x = snake.getLast().x;
                    y= snake.getLast().y;
                   
                    draw(snake, visit, K);
              
                }
                if (c == 'D') {
                    D = 3;
                } else {
                    D = 2;
                }

                // x만 +로 증가
            } else if (D == 2) {
                for (int i = start; i < end; i++) {
                    ans++;
                    if (x+1 < 0 || x+1 >= K || y < 0 || y >= K) {
                        return ans;
                    }
                    if (visit[x+1][y]) {
                        return ans;
                    }
                    
                    if (map[x+1][y] != 1) {
                        visit[snake.getFirst().x][snake.getFirst().y] = false;
                        int xx = snake.getLast().x;
                        int yy = snake.getLast().y;
                        snake.removeFirst();
                        snake.add(new SnakeLength(xx+1,yy));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                        
                    } else {
                        snake.add(new SnakeLength(x + 1, y));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                        map[snake.getLast().x][snake.getLast().y] = 0;
                    }
                    x = snake.getLast().x;
                    y = snake.getLast().y;


                    draw(snake, visit, K);
         
                }
                if (c == 'D') {
                    D = 1;
                } else {
                    D = 0;
                }

                // x만 -로 증가
            } else {
                for (int i = start; i < end; i++) {
                    ans++;
                    if (x - 1 < 0 || x - 1 >= K || y < 0 || y >= K) {
                        return ans;
                    }
                    if (visit[x - 1][y]) {
                        return ans;
                    }
                    if (map[x-1][y] != 1) {
                        visit[snake.getFirst().x][snake.getFirst().y] = false;
                        int xx = snake.getLast().x;
                        int yy = snake.getLast().y;
                        snake.removeFirst();
                        snake.add(new SnakeLength(xx-1,yy));
                        visit[snake.getLast().x][snake.getLast().y] = true;

                    } else {
                        snake.add(new SnakeLength(x - 1, y));
                        visit[snake.getLast().x][snake.getLast().y] = true;
                        map[snake.getLast().x][snake.getLast().y] = 0;
                    }
                    x = snake.getLast().x;
                    y = snake.getLast().y;

                    draw(snake, visit, K);
             
                }
                if (c == 'D') {
                    D = 0;
                } else {
                    D = 1;
                }
            }
            start = end;
            if (!direction.isEmpty()) {
                d = direction.poll();
                s = d.seconds;
                end = s;
                c = d.direction;
            } else {
                end = 200;
            }

        }

    }
}