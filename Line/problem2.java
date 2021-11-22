package Line;

import java.util.*;

public class problem2 {
    class Alptest {
        public char c;
        public int num;

        public Alptest(char ac, int num) {
            this.c = ac;
            this.num = num;
        }

        public Alptest() {
            
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] s = { "abaaaa", "aaa", "abaaaaaa", "fzfffffffa" };
        String[] s2 = { "yxxy", "xxyyy" };
        String[] s3 = { "xy", "xy" };
        int n2 = 2;
        int k2 = 1;
        int n = 2;
        int k = 2;
        int n3 = 1;
        int k3 = 1;
        // String ans = solution(s, n, k);
        //String ans = solution(s2, n2, k2);
        String ans = solution(s3, n3, k3);
    }

    public static String solution(String[] research, int n, int k) {
        String answer = "";
        int ms = 2 * (n * k);
        int[][] alpha = new int[research.length][26];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < research.length; i++) {
            for (int j = 0; j < research[i].length(); j++) {
                int idx = research[i].charAt(j) - 'a';
                alpha[i][idx]++;
            }
        }

        for (int i = 0; i < research.length - (n - 1); i++) {

            for (int j = 0; j < 26; j++) {
                int cnt = 0;
                int sum = 0;
                for (int r = 0; r < n; r++) {
                    if (alpha[i + r][j] >= k) {
                        cnt++;
                        sum += alpha[i + r][j];
                    }
                }
                // 연속으로 k이상 썼을 경우
                if (sum >= ms && cnt == n) {
                    char c = (char) ('a' + j);
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }
        System.out.println("map size:"+map.size());
        if (map.size() == 0)
            return "None";

        int[][] arr = new int[26][2];

        int idxC = 0;
       
        int num = 0;
        char ch='a';
        for (Character key : map.keySet()) {
            // list.add(new Alp('a', 3));
            if (ch < key && num < map.get(key)) {
                ch = key;
                num = map.get(key);
            }
            // arr[key - 'a'][idxC++] = map.get(key);
            System.out.println("key:" + key + " value:" + map.get(key));
        }
        
        /*
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();*/


        // for(int)
        answer += (char) (ch + 'a');
        System.out.println("answer:" + ch);
        return answer;
    }
}