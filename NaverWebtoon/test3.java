package NaverWebtoon;

public class test3 {
    public static void main(String[] args) throws Exception {
        String s="aabcbcd";
        String t="abc";
        int a=solution(s,t);
        System.out.println(a);
    }
    public static int solution(String s, String t) {
        int result = 0;
        String str=s;
        System.out.println("str:"+str);
        while(true){
            System.out.println("contains:"+str.contains(t));
            if(str.contains(t)){
                
                int idx=str.indexOf(t);
                str=str.substring(0,idx)+str.substring(idx+t.length(), str.length());
                System.out.println("reform:"+str);
                result++;
            }
            else
                break;
        }
        return result;
    }
}
