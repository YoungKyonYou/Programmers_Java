package Maester;
import java.util.stream.*;
public class  Phonkemon{
    public static void main(String[] args) throws Exception {
        int[] nums = { 3, 1, 2, 3 };
        int ans;
        ans = solution(nums);
        System.out.println(ans);
    }
    public static int solution(int[] nums) {
        return (int) (nums.length / 2) > IntStream.of(nums).distinct().toArray().length
                ? IntStream.of(nums).distinct().toArray().length
                : (int) (nums.length / 2);
    }
}