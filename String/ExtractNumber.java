import java.util.*;

public class ExtractNumber {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));

    }

    public static int solution(String str) {
        str = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(str);
    }
}