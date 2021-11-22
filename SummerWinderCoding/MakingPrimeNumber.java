package SummerWinderCoding;

import java.util.*;

public class MakingPrimeNumber {
    public static void main(String[] args) throws Exception {
        int[] nums = { 1, 2, 7, 6, 4 };
        int ans = solution(nums);
        System.out.println(ans);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int p, m, n, sum, flag;
        for (int i = 0; i < nums.length; i++) {
            m = nums[i];
            flag = 0;
            for (int j = i + 1; j < nums.length; j++) {
                n = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    flag = 0;
                    p = nums[k];
                    sum = m + n + p;
                    for (int r = (int) Math.sqrt(sum); r < sum; r++) {
                        if (sum % r == 0) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0)
                        answer++;
                }
            }
        }
        // System.out.println(answer);

        return answer;
    }
}