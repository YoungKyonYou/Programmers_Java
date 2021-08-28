package InflearnDFSBFSApplication;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class BinaryCodeUsingRecursive {
    static public String s = "";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
        System.out.println(s);
    }
    public static void solution(int n) {
        if(n%2==1 && n/2!=1)
            s = "1" + s;
        else if (n / 2 == 1) {
            s = Integer.toString(n % 2)+s;
            s =Integer.toString(1)+s;
            return;
        } else {
            s = Integer.toString(n % 2) + s;
        }
        solution(n / 2);
    }
}