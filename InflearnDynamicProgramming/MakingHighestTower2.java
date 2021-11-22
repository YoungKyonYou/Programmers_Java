package InflearnDynamicProgramming;

import java.util.*;

public class  MakingHighestTower2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> narr = new ArrayList<>();
            for (int j = 0; j < 3; j++)
                narr.add(sc.nextInt());
            arr.add(narr);
        }
        Collections.sort(arr, (o1, o2) -> {
            return o2.get(0) - o1.get(0);
        });
        System.out.println(solution(arr));
    }

    public static int solution(List<List<Integer>> arr) {
        Integer[] height = new Integer[arr.size()];
        int answer = arr.get(0).get(1);
        Arrays.fill(height, 0);
        height[0] = arr.get(0).get(1);
        for (int i = 1; i < arr.size(); i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) 
                if ((arr.get(i).get(2) < arr.get(j).get(2)) && height[j] > temp)
                    temp = height[j];
            height[i] = arr.get(i).get(1) + temp;
            answer = Math.max(answer, height[i]);
        }
            return answer;
    }
}