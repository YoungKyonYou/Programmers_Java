
import java.util.*;
public class  OpenChat{
    public static void main(String[] args) throws Exception {
        String[] s = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };
        solution(s);
    }

    public static String[] solution(String[] record) {
        List<String> answer=new ArrayList<>();
        HashMap<String, String> map=new HashMap<>();
        List<String> idList=new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            int idx = record[i].indexOf(" ");
            idx++;
            int idx2 = record[i].indexOf(" ", idx);
            if(record[i].contains("Leave")){
                idList.add(record[i].substring(idx,record[i].length()));
                continue;
            }
            idList.add(record[i].substring(idx, idx2));
            map.put(record[i].substring(idx, idx2), record[i].substring(idx2 + 1, record[i].length()));
        }
        for (int i = 0; i < record.length; i++) {

            if (record[i].contains("Enter")) {
                answer.add(map.get(idList.get(i)) + "님이 들어왔습니다.");
            } else if (record[i].contains("Leave")) {
                answer.add(map.get(idList.get(i)) + "님이 나갔습니다.");
            }
        }
        
        String[] a = answer.toArray(new String[answer.size()]);
        return a;
    }
}