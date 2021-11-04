import java.io.BufferedReader;
import java.io.InputStreamReader;
public class  LaundryShop{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.printf("%d %d %d %d\n", num / 25, (num % 25) / 10, ((num % 25) % 10) / 5,
                    (((num % 25) % 10) % 5) / 1);
        }
    }
}