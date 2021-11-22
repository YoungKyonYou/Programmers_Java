package InflearnDFSBFSApplication;
import java.util.*;
public class  Combination{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] combination = new int[M];
        solution(combination, 0,N,M, 1);
    }
    public static void solution(int[] combination, int L,int N, int M, int s) {
        if (L == M) {
            for(int a: combination)
                System.out.print(a + " ");
            System.out.println(); 
        }else{
            for(int i=s;i<=N;i++){
                combination[L]=i;
                solution(combination,L+1,N, M,i+1);
            }
        }
    }
}