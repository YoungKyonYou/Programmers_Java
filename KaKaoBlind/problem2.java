package KaKaoBlind;
import java.util.*;

public class problem2 {
    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a));
        }
        System.out.println();
    }

    public static void printArrOne(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printMap(HashMap<Integer, Integer> map) {
        for (Integer a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int n = 437674;
        int k = 3;

        int n2 = 110011;
        int k2 = 10;

        int n3 = 234351233;
        int k3 = 4;

        int n4 = 2;
        int k4 = 3;

        int n5 = 9934523;
        int k5 = 9;

        int n6 = 202020202;
        int k6 = 10;
        System.out.println(solution(n6, k6));
    }

    public static boolean isPrime(Long n) {
        if (n == 1)
            return false;
        for (int i =2; i < (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int solution(int n, int k) {
        int answer = 0;
        String ans = "";
        while (n > 0) {
            ans = (n % k) + ans;
            n /= k;
        }
        System.out.println("ans:" + ans);
        String tempStr = "";
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0'){
                tempStr += Character.toString(ans.charAt(i));
                if (i == ans.length() - 1) {
                    Long tempInt = Long.parseLong(tempStr);
                    System.out.println("tempInt:" + tempInt);
                    if (isPrime(tempInt)) {
                        answer++;
                    }
                }
            }
            else if(!tempStr.equals("")){
                Long tempInt = Long.parseLong(tempStr);
                System.out.println("tempInt:" + tempInt);
                if (isPrime(tempInt)) {
                    answer++;
                }
                tempStr = "";
            }

        }
        
        return answer;
    }
}