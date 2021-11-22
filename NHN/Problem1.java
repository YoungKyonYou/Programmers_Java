
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Problem1 {
    
    public static void main(String[] args) throws Exception {
        int N;
        int M;
        LinkedList<Integer> list = new LinkedList<>();
        list.remove(3);
        Queue<Integer> queue = new LinkedList<>();
        int[][] a = new int[2][3];
        HashMap<Integer, Integer> map = new HashMap<>();
        

        StringBuilder sb = new StringBuilder();
        sb.append("test");
        String s = sb.toString();
        System.out.println(s);
        
        //int[][] arr=new int[][];
    }

    public static void solution() {

    }
    
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
}