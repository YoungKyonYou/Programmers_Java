
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  Treasure{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arrB[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += (arrA[arrA.length - i - 1] * arrB[i]);
        }
        System.out.println(sum);
    }
        
        
    

}