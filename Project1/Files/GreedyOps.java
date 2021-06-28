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
        while (remainingItems > remainingTrucks && i < b) {
            int wSoFar = 0;
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            while (remainingItems >= remainingTrucks && wSoFar + biggerThanMean.get(b-i-1) < maxW ) {
                wSoFar += biggerThanMean.get(b-i-1);
                x.add(biggerThanMean.get(b-i-1));
                i++;
                remainingItems--;
                if(i >= b){
                    break;
                }
            }
            if (wSoFar > Wmax) {
                Wmax = wSoFar;
            }
            remainingTrucks--;
        }
        int k = 0;
        while (remainingItems > remainingTrucks && k < s) {
            int wSoFar = 0;
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            while (remainingItems >= remainingTrucks && wSoFar + smallerThanMean.get(s-k-1) < maxW ) {
                wSoFar += smallerThanMean.get(s-k-1);
                x.add(smallerThanMean.get(s-k-1));
                k++;
                remainingItems--;
                if(k>=s){
                    break;
                }
            }
            if (wSoFar > Wmax) {
                Wmax = wSoFar;
            }
            remainingTrucks--;
        }
        while (i < b) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            x.add(biggerThanMean.get(b-i-1));
            if (biggerThanMean.get(b-i-1) > Wmax) {
                Wmax = biggerThanMean.get(b-i-1);
            }
            i++;
            remainingItems--;
            remainingTrucks--;
        }
        while (k < s) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            trucksM.put(j, x);
            x.add(smallerThanMean.get(s-k-1));
            if (smallerThanMean.get(s-k-1) > Wmax) {
                Wmax = smallerThanMean.get(s-k-1);
            }
            k++;
            remainingItems--;
            remainingTrucks--;
        }
        return new Divided(trucks, Wmax);
    }

    public int greedyOp2() {
        return 0;
    }
}