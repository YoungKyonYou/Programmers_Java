
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  DongJoonMadeGame{
    public static void main(String[] args) throws Exception {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                while (arr[j - 1] >= arr[j]) {
                    arr[j - 1]--;
                    cnt++;
                }   
            }
        }
        System.out.println(cnt);
    }
}