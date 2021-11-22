import java.util.*;
public class  DistanceConfirmation{
    public static void main(String[] args) throws Exception {
        String[][] arr={{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        List<Integer> ans=solution(arr);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(String[][] places) {
        List<Integer> ans = new ArrayList<>();
        int[] upDownLeftRightX = { -1, 0, 1, 0 };
        int[] upDownLeftRightY = { 0, 1, 0, -1 };
        int[] doubleUpDownLeftRightX = { -2, 0, 2, 0 };
        int[] doubleUpDonwLeftRightY = { 0, 2, 0, -2 };
        int[] crossUpDownLeftRightX = { -1, 1, 1, -1 };
        int[] crossUpDownLeftRightY = { 1, 1, -1, -1 };
        for (int i = 0; i < places.length; i++) {
            char[][] arr = new char[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    arr[j][k] = places[i][j].charAt(k);
                }
            }
            loop: for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int r = 0; r < 4; r++) {
                        if (arr[j][k] == 'P') {
                            if (j + upDownLeftRightX[r] >= 0 && k + upDownLeftRightY[r] >= 0
                                    && k + upDownLeftRightY[r] < 5 && j + upDownLeftRightX[r] < 5
                                    && arr[j + upDownLeftRightX[r]][k + upDownLeftRightY[r]] == 'P') {
                                ans.add(0);
                                break loop;
                            }
                            if (j + doubleUpDownLeftRightX[r] >= 0 && k + doubleUpDonwLeftRightY[r] >= 0
                                    && k + doubleUpDonwLeftRightY[r] < 5 && j + doubleUpDownLeftRightX[r] < 5
                                    && arr[j + doubleUpDownLeftRightX[r]][k + doubleUpDonwLeftRightY[r]] == 'P') {
                                if (arr[j + upDownLeftRightX[r]][k + upDownLeftRightY[r]] != 'X') {
                                    ans.add(0);
                                    break loop;
                                }
                            }
                            if (j + crossUpDownLeftRightX[r] >= 0 && k + crossUpDownLeftRightY[r] >= 0
                                    && k + crossUpDownLeftRightY[r] < 5 && j + crossUpDownLeftRightX[r] < 5
                                    && arr[j + crossUpDownLeftRightX[r]][k + crossUpDownLeftRightY[r]] == 'P') {
                                if (arr[j+upDownLeftRightX[r]][k+upDownLeftRightY[r]] != 'X'
                                        || arr[j+upDownLeftRightX[(r + 1) % 4]][k+upDownLeftRightY[(r + 1) % 4]] != 'X') {
                                    ans.add(0);
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
            if (ans.size() == i) {
                ans.add(1);
            }
        }
        return ans;
    }
}