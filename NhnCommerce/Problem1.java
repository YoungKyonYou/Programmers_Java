import java.io.*;
import java.util.*;
import java.lang.*;

class Problem1 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt(); // 송수신 기록의 수
        String[] logs = new String[n]; // 송수신 기록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            logs[i] = br.readLine();
        }

        for (String s : logs) {
            System.out.println("test:" + s);
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (j < n && logs[i].equals(logs[j])) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > 1) {
                list.add(logs[i] + " (" + Integer.toString(cnt) + ")");
                i += cnt - 1;
            } else {
                list.add(logs[i]);
            }
        }
        list.add(logs[logs.length - 1]);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }

    }
}