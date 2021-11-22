package InflearnGreedyAlgorithm;
import java.util.*;
public class  AssignMeetingRoom{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=1;j>=0;j--)
                arr[i][j] = sc.nextInt();
        System.out.println(solution(arr));
    }
    public static int solution(int[][] arr) {
        int answer = 1;
        Arrays.sort(arr,(o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            else
                return o1[0] - o2[0];
        });
        int end = arr[0][0];
        for (int i = 1; i < arr.length;i++) 
            if (end <= arr[i][1]) {
                end = arr[i][0];
                answer++;
            }
        return answer;
    }
}