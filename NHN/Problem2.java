
import java.util.*;
public class  Problem2{
    public static void main(String[] args) throws Exception {
        int N=4;
        int M = 3;
        int[][] arr = { { 18, 16, 17, 2, 9, 19 }, { 2, 16, 3, 11, 6, 19, 15, 17 }, { 19, 1, 4, 17, 7 },
                { 16, 3, 6, 19, 14, 12 } };
        int[] a = new int[40];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("get:" + map.get(arr[i][j]));
                map.put(arr[i][j], map.getOrDefault(arr[i][j],0)+1);
            }
        }
        int idx = 0;
        for (Integer i : map.keySet()) {
            a[idx++] = map.get(i);
        }

        for (Integer i : map.keySet()) {
            System.out.print(pq.poll()+" ");
        }
        
        System.out.println();
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