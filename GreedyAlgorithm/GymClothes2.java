package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GymClothes2 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        //인덱스는 사람의 번호보다 1작으니까 -1씩 해주는 거임
        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;
        System.out.println(Arrays.toString(people));

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                //한 사이즈 아래부터 체크한다. 사이즈가 0이면 실행 안하고 그 사이즈 하나를 여분으로 가지고 있다면
                if(i-1>=0 && people[i-1] == 1) {
                    //체육복이 있는 애가 체육복을 빌림
                    people[i]++;
                    //체육복 여분을 가지고 있는 애가 하나를 빌려줌
                    people[i-1]--;
                    //한 사이즈 위를 체크한다.
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                    //체육복이 없는 애가 빌릴 수 없다면 답을 하나씩 깎는다.
                }else 
                    answer--;
            }
        }
        return answer;
    }    public static void main(String[] args) throws Exception {
        int[] l={1,2,3,4,5};
        int[] r={1,2,3,4,5};
        int n=5;
        int answer=solution(n,l,r);
        System.out.println("answer:"+answer);
    }
}
