import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class GreedyOps {
    private int n, k;
    private int[] w;

    public GreedyOps(int n, int k, int[] w) {
        this.n = n;
        this.k = k;
        this.w = w;
    }

    public Divided greedyOp1() {
        Trucks trucks = new Trucks();
        Map<Integer, ArrayList<Integer>> trucksM = trucks.getTruckM();
        int mean = 0, Wmax = 0;
        for (int i = 0; i < n; i++) {
            mean += w[i];
        }
        mean = mean / k;
        Arrays.sort(w);
        int dir = 0, i = 0, j = 1;
        while (i < n) {
            int wSoFar = 0;
            ArrayList<Integer> x = new ArrayList<Integer>();
            if (trucksM.containsKey(j)) {
                x = trucksM.get(j);
                for (int y = 0; y < x.size(); y++) {
                    wSoFar += x.get(y);
                }
            } else {
                trucksM.put(j, x);
            }

            wSoFar += w[n - i - 1];
            x.add(w[n - i - 1]);
            i++;
            while (i < n && wSoFar + w[n - i - 1] <= mean) {
                wSoFar += w[n - i - 1];
                x.add(w[n - i - 1]);
                i++;
            }
            if (wSoFar > Wmax) {
                Wmax = wSoFar;
            }
            if (dir == 0) {
                j++;
            }
            if (dir == 1) {
                j--;
            }
            if (j == k+1) {
                j=j-2;
                dir = 1;
            }
            if (j == 0) {
                j=j+2;
                dir = 0;
            }
        }
        trucks.setTruckM(trucksM);
        return new Divided(trucks, Wmax);
    }
}