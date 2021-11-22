
import java.util.*;

public class ParenthesisTransition {

    public static void main(String[] args) throws Exception {
        String p = "()))((()";
        String pp = ")()()()(";
        String ppp = "(()())()";
        System.out.println("ans:" + solution(ppp));
    }

    public static boolean isRight(String u) {
        int lCnt = 0;
        int rCnt = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') 
                lCnt++;
            else 
                rCnt++;
            if (rCnt > lCnt) 
                return false;
        }
        return true;
    }

    public static String recursive(String u, String v) {
        String uu = "";
        String vv = "";
        int leftCnt = 0;
        int rightCnt = 0;
        String ss = "";
        if (v.equals("")) {
            return "";
        }
        for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == '(') {
                leftCnt++;
            } else {
                rightCnt++;
            }
            if (leftCnt == rightCnt) {
                uu = v.substring(0, i + 1);
                vv = v.substring(i + 1, v.length());

                
                if (uu.length() > 0 && isRight(uu)) {
                    uu = uu + recursive("", vv);
                    return uu;
                } else {
                    uu = uu.substring(1, uu.length() - 1);
                    String temp = "";
                    for (int j = 0; j < uu.length(); j++) {
                        if (uu.charAt(j) == '(') {
                            temp += ")";
                        } else {
                            temp += "(";
                        }
                    }
                    ss = "(" + recursive("", vv) + ")" + temp;
                    break;
                }
            }
        }
        return ss;
    }

    public static String solution(String p) {
        String ans = recursive("", p);
        return ans;
    }
}