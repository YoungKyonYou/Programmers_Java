package KakaoPayIntern;
import java.util.*;
public class  practice1{
    public static void main(String[] args) throws Exception {

        int[][] swipes = { { 3,1,1,1,2 }, { 1,1,2,2,2 }, { 4,2,1,2,2 }, { 2,1,1,2,1 } };
        int rows = 2;
        int columns = 2;
        int[] ans = solution(swipes, rows, columns);
        System.out.println("FINAL ANSWER:" + Arrays.toString(ans));
    }

    public static int[][] swap(int[][] metrix, int x1, int y1, int x2, int y2) {
        int temp = metrix[x1][y1];
        metrix[x1][y1] = metrix[x2][y2];
        metrix[x2][y2] = temp;
        return metrix;
    }

    public static void printArray(int[][] metrix) {
        for (int[] a : metrix) {
            System.out.print(Arrays.toString(a));
            System.out.println();
        }
    }
    public static int[] solution(int[][] swipes, int rows, int columns) {
        int[] answer = new int[swipes.length];
        int cnt = 1;
        int[][] metrix = new int[rows][columns];
        int idx=0;
        for (int i = 0; i < rows; i++) {
            for(int j=0;j<columns;j++){
                metrix[i][j] = cnt++;
            }
        }
        for (int i = 0; i < swipes.length; i++) {
                           
            //down
            System.out.println("answer:");
            if (swipes[i][0] == 1) {

                //1~
                for (int j = swipes[i][2] - 1; j <= (swipes[i][4])-1; j++) {
                    answer[idx] += metrix[swipes[i][3] - 1][j];
                    System.out.print(metrix[swipes[i][3] - 1][j] + " ");
                }
                idx++;
                     System.out.println();

                     //1~2

                for (int j = swipes[i][2] - 1; j <= swipes[i][4] -1; j++) {
                    //3~0
                    for (int k = swipes[i][3] -1; k > swipes[i][1]-1; k--) {
                        metrix = swap(metrix, k, j, k - 1, j);
                        //  printArray(metrix);
                    }
                }
                   printArray(metrix);
            }
            //up 
            else if (swipes[i][0] == 2) {

                //0~2
                for (int j = swipes[i][2] - 1; j <= (swipes[i][4]-1); j++) {
                    answer[idx] += metrix[swipes[i][1] - 1][j];
                    System.out.print(metrix[swipes[i][1] - 1][j] + " ");
                }
                idx++;
                    System.out.println();
               
                // 0~2 column
                for (int j = swipes[i][2] - 1; j <= swipes[i][4]-1 ; j++) {
                    // 1
                    for (int k = swipes[i][1] - 1; k < swipes[i][3] -1; k++) {
                        metrix = swap(metrix, k, j, k + 1, j);
                        // printArray(metrix);
                    }
                }
                     printArray(metrix);
            }
            //right
            else if (swipes[i][0] == 3) {
                
                // 0~3
                for (int j = swipes[i][1] - 1; j <= swipes[i][3] - 1; j++) {
                    answer[idx] += metrix[j][swipes[i][4] - 1];
                    System.out.print(metrix[j][swipes[i][4] - 1] + " ");
                }
                idx++;
                System.out.println();

                // 0~2 column
                
                //// { 3,1,2,2,4}
                //첫 { 3, 2, 1, 2, 3 }
                for (int j = swipes[i][1] - 1; j <=swipes[i][3] - 1; j++) {
                    // 2~1
                    for (int k = swipes[i][4] - 1 ; k > swipes[i][2] - 1; k--) {
                        metrix = swap(metrix, j, k, j, k - 1);
                        // printArray(metrix);
                    }
                }
                printArray(metrix);
            }
            //left
        
            else if (swipes[i][0] == 4) {
               
                for (int j = swipes[i][1] - 1; j <= (swipes[i][3] -1) ; j++) {
                    answer[idx] += metrix[j][swipes[i][2] - 1];
                    System.out.print(metrix[j][swipes[i][2] - 1] + " ");
                }
                idx++;
                System.out.println();
                // 0~2 column
                // { 4,2,1,2,3 }
                for (int j = swipes[i][1] - 1; j <= swipes[i][3]-1; j++) {
                    // 2~1
                    for (int k = swipes[i][2] - 1; k < swipes[i][4] - 1; k++) {
                        metrix = swap(metrix, j, k, j, k + 1);
                        // printArray(metrix);
                    }
                }
                 printArray(metrix);
            }

        }
        


        return answer;
    }
}