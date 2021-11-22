package InflearnGreedyAlgorithm;

import java.util.*;
public class Marriage {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n * 2][2];
        for (int i = 0; i < n*2; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i%2;   
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int answer = 1;
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0]==o2[0])
                return o2[1]-o1[1];
            else 
                return o1[0]-o2[0];
        });

        for(int[] a:arr)
            System.out.println(Arrays.toString(a));
        int cnt = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i][1]==0)
                cnt++;
            else if (arr[i][1] == 1)
                cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
