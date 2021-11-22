package InflearnStackQueue;
import java.util.*;
public class  CurriculumPlan{
    public static void main(String[] args) throws Exception {
        String ans = "YES";
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str1.length(); i++)
            queue.add(str1.charAt(i));
        for (int i = 0; i < str2.length(); i++) {
            if (queue.contains(str2.charAt(i))) {
                if (queue.poll() != str2.charAt(i)){
                    ans = "NO";
                    break;
                }
            }
        }
        if (!queue.isEmpty())
            ans = "NO";
        System.out.println(ans);
    }
}