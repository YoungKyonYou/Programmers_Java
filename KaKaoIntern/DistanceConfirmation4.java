import java.util.*;

public class DistanceConfirmation4 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] visit;

    static int[] answer;

    public static void main(String[] args) throws Exception {
        String[][] arr = { { "POOOP", "OXXOX", "OPXPX", "OOXOX",
                "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
        int[] ans = solution(arr);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static class Seat {
        public int px;
        public int py;
        public int count=0;

        public Seat(int px, int py, int count) {
            this.px = px;
            this.py = py;
            this.count = count;
        }

        public int addCount() {
            count++;
            return count;
        }
    }
    


    public static int[] solution(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            Queue<Seat> queue = new LinkedList<>();
            int count = 0;
            loop:
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        queue.add(new Seat(j, k, 0));
                        visit[j][k] = true;
                        while (!queue.isEmpty()) {
                            Seat seat = queue.poll();
                            if (seat.count <= 2 && seat.count > 0 && places[i][seat.px].charAt(seat.py) == 'P') {
                                answer[i] = 0;
                                break loop;
                            }
                            if (seat.count + 1 > 2) {
                                continue;
                            }
                            for (int r = 0; r < 4; r++) {
                                int xx = seat.px + dx[r];
                                int yy = seat.py + dy[r];
                                int cc = seat.count;
                                if (xx >= 0 && xx < 5 && yy >= 0 && yy < 5 && !visit[xx][yy]
                                        && places[i][xx].charAt(yy) != 'X') {
                                    visit[xx][yy] = true;
                                    queue.add(new Seat(xx, yy, cc + 1));
                                }
                            }

                        }
                    }
                    
                }
            }
        }
        return answer;
    }
}