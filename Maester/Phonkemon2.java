package Maester;

import java.util.stream.*;

public class Phonkemon2 {
    public static void main(String[] args) throws Exception {
        int[] nums = { 3, 1, 2, 3 };
        int ans;
        ans = solution(nums);
        System.out.println(ans);
    }

    public static int solution(int[] nums) {
        int n = (int) (nums.length / 2);
        nums = IntStream.of(nums).distinct().toArray();
        // list = (ArrayList) list.stream().distinct().collect(Collectors.toList());
        return n > nums.length ? nums.length : n;
    }
}