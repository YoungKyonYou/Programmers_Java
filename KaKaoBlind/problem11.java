package KaKaoBlind;
import java.util.*;

public class problem11 {
    public static void printArrTwo(int[][] arr){
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
    
    public static void printMap2(HashMap<String, List<String>> map) {
        for (String a : map.keySet()) {
            for(String b:map.get(a))
                System.out.println("key: " + a + " value:" + b);
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        
        String[] id_list2 = { "con", "ryan" };
        String[] report2 = { "ryan con", "ryan con", "ryan con", "ryan con" };

        String[] id_list3 = { "muzi", "frodo", "apeach", "neo" ,"young", "sung", "dong"};
       String[] report3 = { "muzi frodo", "apeach frodo", "frodo muzi", "muzi frodo", "apeach frodo", "neo apeach", "neo muzi", "neo frodo","young sung", "young sung", "dong sung", "dong sung"};
        int k=2;
        int k2 = 3;
        int k3 = 1;
        int[] ans=solution(id_list2,report2, k2);
        System.out.println(Arrays.toString(ans));
        
    }
    
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int iidx=0;
        HashMap<String, Integer> reportMap = new HashMap<>();

        //누가 누구한테 신고했는지 저장 
        HashMap<String, List<String>> whoReportedMap = new HashMap<>();

        

        //차단 당한 사람들 리스트
        List<String> blockList = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            int idx = report[i].indexOf(" ");

            //tempFrom: 신고자
            String tempFrom = report[i].substring(0, idx);
            //tempTo: 신고대상
            String tempTo = report[i].substring(idx + 1, report[i].length());
            if (whoReportedMap.containsKey(tempFrom)) {
                //신고자가 신고한 사람의 스트링을 계속 만들어 나감
                List<String> target = whoReportedMap.get(tempFrom);
                if (target.contains(tempTo)) {
                    continue;
                }
                target.add(tempTo);
                whoReportedMap.put(tempFrom, target);
            } else {
                List<String> whoReportedList = new ArrayList<>();
                whoReportedList.add(tempTo);
                whoReportedMap.put(tempFrom, whoReportedList);
            }
            //  reportMap에다가 사람마다 신고 당한 개수 넣기
            reportMap.put(tempTo, reportMap.getOrDefault(tempTo, 0) + 1);
        }
        printMap(reportMap);
        printMap2(whoReportedMap);
        for (String s:reportMap.keySet()) {
            if (reportMap.get(s) >= k) {
                blockList.add(s);
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            if (whoReportedMap.containsKey(id_list[i])) {
                int cnt = 0;
                List<String> temp = whoReportedMap.get(id_list[i]);
                for (String s : blockList) {
                    if (temp.contains(s)) {
                        cnt++;
                    }
                }
                answer[iidx++] = cnt;
            } else {
                answer[iidx++] = 0;
            }
        }

        return answer;
    }
}