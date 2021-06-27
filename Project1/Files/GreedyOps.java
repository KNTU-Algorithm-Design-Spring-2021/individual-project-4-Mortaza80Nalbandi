import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class GreedyOps {
    private int n, k, maxW;
    private int[] w;

    public GreedyOps(int n, int k, int[] w, int maxW) {
        this.n = n;
        this.k = k;
        this.w = w;
        this.maxW = maxW;
    }

    public Divided greedyOp1() {
        Trucks trucks = new Trucks();
        Map<Integer, ArrayList<Integer>> trucksM = trucks.getTruckM();
        int mean = 0, Wmax = 0;
        for (int i = 0; i < n; i++) {
            mean += w[i];
        }
        mean = mean / n;
        ArrayList<Integer> smallerThanMean = new ArrayList<Integer>();
        ArrayList<Integer> biggerThanMean = new ArrayList<Integer>();
        Arrays.sort(w);
        for (int i = 0; i < n; i++) {
            if (w[i] >= mean) {
                biggerThanMean.add(w[i]);
            } else if (w[i] < mean) {
                smallerThanMean.add(w[i]);
            }
        }
        int remainingItems = n, remainingTrucks = k, i = 0, j = 1, b = biggerThanMean.size(), s = smallerThanMean.size();
        while (remainingItems > remainingTrucks && b > 0) {
            int wSoFar = 0;
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            while (remainingItems >= remainingTrucks && wSoFar + biggerThanMean.get(i) < maxW && b > 0) {
                wSoFar += biggerThanMean.get(i);
                x.add(biggerThanMean.get(i));
                i++;
                b--;
                remainingItems--;
            }
            if (wSoFar > Wmax) {
                Wmax = wSoFar;
            }
            remainingTrucks--;
        }
        while (remainingItems > remainingTrucks && s > 0) {
            int wSoFar = 0;
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            while (remainingItems >= remainingTrucks && wSoFar + smallerThanMean.get(i) < maxW && s > 0) {
                wSoFar += smallerThanMean.get(i);
                x.add(smallerThanMean.get(i));
                i++;
                s--;
                remainingItems--;
            }
            if (wSoFar > Wmax) {
                Wmax = wSoFar;
            }
            remainingTrucks--;
        }
        while (s > 0) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            x.add(biggerThanMean.get(i));
            if (biggerThanMean.get(i) > Wmax) {
                Wmax = biggerThanMean.get(i);
            }
            i++;
            s--;
            remainingItems--;
            remainingTrucks--;
        }
        while (b > 0) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            x.add(smallerThanMean.get(i));
            if (smallerThanMean.get(i) > Wmax) {
                Wmax = smallerThanMean.get(i);
            }
            i++;
            b--;
            remainingItems--;
            remainingTrucks--;
        }
        return new Divided(trucks,Wmax);
    }
    public int greedyOp2() {
        return 0;
    }
}