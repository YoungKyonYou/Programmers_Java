package InflearnDFSBFSApplication;

import java.util.*;

public class PizzaDeliveryDistance2 {
    private static final int BIT = 1 << 3;
    private static final int CUT = (1 << BIT) - 1;
    private static int N, M, D, houseCnt, chickenCnt;
    private static int[] house, chicken, selected;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        D = Integer.MAX_VALUE;

        house = new int[N << 1];
        chicken = new int[13];
        selected = new int[M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                int t = System.in.read();

                if (t == 49) { // house
                    house[houseCnt++] = (r << BIT) | c;
                } else if (t == 50) { // chicken
                    chicken[chickenCnt++] = (r << BIT) | c;
                }

                System.in.read();
            }
        }
        System.out.println("house:" + Arrays.toString(house));
        System.out.println("chicken:" + Arrays.toString(chicken));
        combination(0, 0, 0);

        System.out.print(D);

    }

    private static void combination(int start, int cnt, int visited) {

        if (cnt == M) {

            int t = 0;

            for (int i = 0; i < chickenCnt; i++) {
                if ((visited & (1 << i)) < 1)
                    continue;
                selected[t++] = chicken[i];
            }

            t = getDist();

            if (D > t)
                D = t;

            return;

        }

        for (int i = start; i < chickenCnt; i++) {

            visited |= (1 << i);
            combination(i + 1, cnt + 1, visited);
            visited -= (1 << i);

        }

    }

    private static int getDist() {

        int dist = 0;

        for (int i = 0; i < houseCnt; i++) {

            int r = (house[i] >> BIT) & CUT;
            int c = house[i] & CUT;

            dist += getDist(r, c, selected);

        }

        return dist;

    }

    private static int getDist(int x, int y, int[] selected) {

        int dist = Integer.MAX_VALUE;
        int M = selected.length;

        for (int i = 0; i < M; i++) {

            int r = ((selected[i] >> BIT) & CUT) - x;
            int c = (selected[i] & CUT) - y;

            if (r < 0)
                r = ~r + 1;
            if (c < 0)
                c = ~c + 1;

            int d = r + c;
            if (dist > d)
                dist = d;

        }

        return dist;

    }

    /**
     * Input Process - Only Positive Integer
     * 
     * @see https://blog.naver.com/jihogrammer/222281999239
     */
    private static int read() throws Exception {
        int c, N = System.in.read() - 48;
        while ((c = System.in.read()) > 32)
            N = 10 * N + c - 48;
        return N;
    }
}