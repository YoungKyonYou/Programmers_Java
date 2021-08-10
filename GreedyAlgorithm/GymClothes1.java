package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.List;

public class GymClothes1 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> l=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        for(int e:lost)
            l.add(e);
        for(int e:reserve)
            r.add(e);
        for(int i=0;i<lost.length;i++){
            Integer ll=lost[i];
            if(r.contains(ll)){
                r.remove(ll);
                l.remove(ll);
            }
        }
        for(int i=0;i<r.size();i++){
            Integer f=r.get(i)-1;
            Integer b=r.get(i)+1;
            if(l.contains(f))
                l.remove(f);
            else if(l.contains(b))
                l.remove(b);
        }
        System.out.println(l.toString());
        return n-l.size();
    }    public static void main(String[] args) throws Exception {
        int[] l={1,2,3,4,5};
        int[] r={1,2,3,4,5};
        int n=5;
        int answer=solution(n,l,r);
        System.out.println("answer:"+answer);
    }
}
