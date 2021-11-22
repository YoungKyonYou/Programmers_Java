package KDigital;
import java.util.*;
public class  problem2{
    public static void main(String[] args) throws Exception {
        int[] deposit = { 500, 1000, -300, 200, -400, 100, -100 };
        int[] ans = solution(deposit);
        System.out.println("answer:" + Arrays.toString(ans));
    }

    public static int[] solution(int[] deposit) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < deposit.length; i++) {
            if (deposit[i] > 0)
                answer.add(deposit[i]);
            else {
                while (deposit[i] != 0) {
                    int cmp = answer.get(answer.size() - 1);
                    if (cmp < deposit[i] * (-1)) {
                        answer.remove(answer.size() - 1);
                        deposit[i] += cmp;
                    } else {
                        int remain = deposit[i] * (-1);
                        if (cmp - remain == 0)
                            answer.remove(answer.size() - 1);
                        else
                            answer.set(answer.size() - 1, cmp - remain);
                        deposit[i] = 0;
                    }
                }
            }
        }
        int[] t = answer.stream().mapToInt(x -> x).toArray();
        return t;
    }
}