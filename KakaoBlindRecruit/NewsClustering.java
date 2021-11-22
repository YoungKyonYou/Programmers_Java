
import java.util.*;

public class NewsClustering {
    public static void main(String[] args) throws Exception {
        //String str1 = "aa1+aa2";
       // String str2 = "AAAA12";
        //String str1 = "FRANCE";
       // String str2 = "french";
       String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        int ans = solution(str1, str2);
        System.out.println("FINAL ANSWER: " + ans);
    }

    public static int count(List<String> str, String string) {
        int cnt = 0;
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).equals(string))
                cnt++;
        }
        return cnt;
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> strList1 = new ArrayList<>();
        List<String> strList2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2);
            temp = temp.replaceAll("[^a-z]", "");
            if (temp.length() != 2 || temp == null)
                continue;
            strList1.add(temp);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2);
            temp = temp.replaceAll("[^a-z]", "");
            if (temp.length() != 2 || temp == null)
                continue;
            strList2.add(temp);
        }
        Collections.sort(strList1);
        Collections.sort(strList2);
        Set<String> set1 = new HashSet<>(strList1);
        Set<String> set2 = new HashSet<>(strList2);
        int numerator = 0;
        int denominator = 0;// 분모
        int num1 = 0;
        int num2 = 0;
        for (String s : set1) {
            num1 = count(strList1, s);
            num2 = count(strList2, s);
            denominator += Math.max(num1, num2);
            numerator += Math.min(num1, num2);
        }
        for (String s : set2) {
            if (count(strList1, s) != 0)
                continue;
            num2 = count(strList2, s);
            denominator += num2;
        }
        if (denominator == 0 && numerator == 0) {
            denominator = 1;
            numerator = 1;
        }
        answer = (int) (((double) numerator / (double) denominator) * 65536);
        return answer;
    }
}