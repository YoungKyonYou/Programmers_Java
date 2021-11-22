package NaverWebtoon;

import java.util.*;

public class test2 {
    public static void main(String[] args) throws Exception {
        int[] prices = { 13000, 88000, 10000 };
        int[] discounts = { 30, 20 };
        solution(prices, discounts);
    }

    public static int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        for (int i = 0; i < prices.length; i++) {
            if (i >= prices.length - discounts.length){
                int minus=prices[i] * discounts[i - (prices.length - discounts.length)]/100;
                answer += prices[i]-minus;
            }
            else
                answer += prices[i];
        }
        return answer;
    }
}
