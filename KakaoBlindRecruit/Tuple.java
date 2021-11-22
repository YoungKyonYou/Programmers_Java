
import java.util.*;
public class  Tuple{
    public static void main(String[] args) throws Exception {
        String str = "{{20,111},{111}}";
        List<Integer> list = solution(str);
        for (int a : list) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(String s) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> temp=new ArrayList();
        s=s.substring(1,s.length()-1);
        List<Integer> list = new ArrayList<>();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                list = new ArrayList<>();
            } else if (s.charAt(i) == '}') {
                list.add(Integer.parseInt(str));
                temp.add(list);
            } else if (s.charAt(i) == ',') {
                if(str.length()!=0)
                    list.add(Integer.parseInt(str));
                str = "";
                continue;
            } else {
                str += Character.toString(s.charAt(i));
               // list.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        Collections.sort(temp,(o1, o2)->{
            return o1.size()-o2.size();
        });
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                if(!ans.contains(temp.get(i).get(j))){
                    ans.add(temp.get(i).get(j));
                }
            }
        }
        for (List<Integer> a : temp) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        return ans;
    }
}