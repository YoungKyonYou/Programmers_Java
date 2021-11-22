package KaKaoCode;


public class KaKaoFriendsColoringBook {

    static int[][] flag;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int temp;
    public static void main(String[] args) throws Exception {
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };
        int m = 6;
        int n = 4;
        int[] ans = solution(m, n, picture);
        System.out.println("FINAL ANSWER:" + ans[0]);
        System.out.println("FINAL ANSWER:" + ans[1]);
    }

    public static void dfs(int[][] picture, int v1, int v2, int m, int n, int target) {
        if (flag[v1][v2] == 0 && picture[v1][v2]==target) {
            flag[v1][v2] = picture[v1][v2];
            temp++;
            if (v1 + 1 < m) 
                dfs(picture, v1 + 1, v2, m, n,target);
            if(v1-1>=0)
                dfs(picture, v1 - 1, v2, m, n, target);
            if (v2-1>= 0) 
                dfs(picture, v1, v2 - 1, m, n, target);
            if(v2+1<n)
                dfs(picture, v1, v2 + 1,m,n, target);
        }
        
    }
    
    public static int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && flag[i][j]==0) {
                    temp = 0;
                    System.out.println("Starting Point:" + i + " " + j);
                    dfs(picture, i, j, m, n, picture[i][j]);
                    System.out.println("temp:" + temp);
                    maxSizeOfOneArea = Math.max(temp, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}