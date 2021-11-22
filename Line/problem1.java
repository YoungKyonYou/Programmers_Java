package Line;
import java.util.*;
public class  problem1{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr={0,1,0,0};
        int k=1;
        solution(arr, k);
    }

    public static int solution(int[] student, int k) {
        int answer = 0;
        int curStu=0;
        int fresh=0;
        for(int i=0;i<student.length;i++){
            for(int j=i;j<student.length;j++){
                if(student[j]==1){
                    curStu++;
                }
                if(curStu==k){
                    answer++;
                }
            }
            curStu=0;
        }
        return answer;
    }

}