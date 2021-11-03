import java.util.*;

public class AirPort {
    
    public static void merge(int u, int v, int[] parent) {
        u = find(u,parent);
        v = find(v,parent);
        parent[u] = v;
    }
    
    public static int find(int u, int[] parent) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u],parent);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        int ans = 0;
        int[] parent = new int[g+1];

        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= p; i++) {
            int gi = sc.nextInt();

            int docking = find(gi,parent);
            if (docking != 0) {
                merge(docking, docking - 1,parent);
                ++ans;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

}