package KaKaoBlind;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

public class problem3 {

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
    
    public static void printMap(HashMap<String, Integer> map) {
        for (String a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        //기본 시간(분)  기본 요금(원)  단위 시간(분)  단위 요금(원)
        int[] fees={180, 5000, 10, 600};
        int[] fees2 = { 120, 0, 60, 591 };
        int[] fees3 = { 1, 461, 1, 10 };
        String[] records={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records2 = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
        String[] records3 = { "00:00 1234 IN" };
        System.out.println(Arrays.toString(solution(fees3, records3)));
    }
    
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int idx = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int[] flag = new int[records.length];
        List<String> carSet = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            if(!carSet.contains(records[i].substring(6, 11)))
                carSet.add(records[i].substring(6, 11));
        }
        answer = new int[carSet.size()];
        for (String type : carSet) {
            String temp = type;
            int hour1 = 0, minute1 = 0, hour2 = 0, minute2 = 0, total = 0;
            int statusInt = 0;
            for (int i = 0; i < records.length; i++) {
                String status = records[i].substring(records[i].indexOf(" ", 7) + 1, records[i].length());
                String carType = records[i].substring(6, 11);

                if (temp.equals(records[i].substring(6, 11))) {
                    if (status.equals("IN")) {
                        statusInt = 1;
                        hour1 = Integer.parseInt(records[i].substring(0, 2));
                        minute1 = Integer.parseInt(records[i].substring(3, 5));
                        map.put(temp, map.getOrDefault(temp, 0));
                    } else {
                        statusInt = 0;
                        hour2 = Integer.parseInt(records[i].substring(0, 2));
                        minute2 = Integer.parseInt(records[i].substring(3, 5));
                        total = map.getOrDefault(temp, 0);
                    //    System.out.println("default total:" + total);
                        total += (((hour2 - hour1) * 60) + (minute2 - minute1));
                    //    System.out.println("after total:" + total);

                        map.put(temp, total);
                    }
                }
            }
            if (statusInt == 1) {
                total = map.get(temp);
                total += (((24 - hour1) * 60) - Math.abs(00 - (minute1 + 1)));
               // System.out.println("statusInt total:" + (((24 - hour1) * 60) - Math.abs(00 - (minute1 + 1))));
                map.put(temp, total);
            }
            printMap(map);
        }
        // 기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금(원)
       //int[] fees = { 180, 5000, 10, 600 };
       for (String s : map.keySet()) {
           int total = map.get(s);
           if (total > fees[0]) {
               if ((total - fees[0]) % fees[2] != 0) {
                   total = (total - fees[0]) / fees[2];
                   total++;
               } else {
                   total = (total - fees[0]) / fees[2];
               }
               System.out.println("final total:" + total);
               map.put(s,(total * fees[3]) + fees[1]);
           } else {
               map.put(s,fees[1]);
           }
       }
       int[] fanswer = new int[answer.length];
       Collections.sort(carSet);
       for (String s:map.keySet()) {
           int idx2 = carSet.indexOf(s);
           fanswer[idx2] = map.get(s);
       }
       
        return fanswer;
    }
}