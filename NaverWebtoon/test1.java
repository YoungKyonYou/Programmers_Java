package NaverWebtoon;

public class test1 {
    public static void main(String[] args) throws Exception {
        String s="ababccccccabab";
        String[] s2=solution(s);
        for(String ss:s2){
            System.out.print(ss+" ");
        }
    }
    public static String[] solution(String s) {
        String[] answer = new String[1001];
        int idx=0;
        int d=0;
        while(!s.isEmpty()){
            int cnt=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(0)==s.charAt(s.length()-1-j)){
                    cnt=j;
                    break;
                }
            }
            if(cnt+1==s.length()){
                answer[idx++]=s;
                d=1;
                break;
            }
            answer[idx++]=s.substring(0, cnt+1);
            s=s.substring(cnt+1, s.length()-(cnt+1));
        }
        int l=idx-d;
        for(int i=0;i<l;i++)
            answer[idx++]=answer[l-1-i];
        int len=0;
        for(int i=0;i<answer.length;i++)
            if(answer[i]!=null)
                len++;
        String[] nAnswer=new String[len];
        for(int i=0;i<len;i++)
            nAnswer[i]=answer[i];
        return nAnswer;
    }
}
