import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.*;

public class SheepAndWolf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Verticals : ");
        int n = scanner.nextInt();
        int x;
        boolean valid = true;
        Vertical[] verticals = new Vertical[n];
        verticals[n - 1] = new Vertical();
        for (int i = 1; i < n; i++) {
            System.out.println("Enter number of out-go edges from V" + i);
            int m = scanner.nextInt();
            verticals[i - 1] = new Vertical();
            System.out.println("Enter the Verticals");
            for (int j = 0; j < m; j++) {
                x = scanner.nextInt();
                verticals[i - 1].addTos(x);
            }
        }
        ArrayList<Integer> road1 = new ArrayList<Integer>();
        road1.add(1);
        ArrayList<Integer> road2 = new ArrayList<Integer>();
        road2.add(1);
        if (!findRoad(verticals, road1, n, 1,1,road2)) {
            System.out.println("Impossible");
            valid = false;
        }
        if (valid) {
            System.out.println("Road For Goat :" + road1);
            System.out.println("Road For Wolf :" + road2);
        }
    }

    public static boolean findRoad(Vertical[] verticals, ArrayList<Integer> road, int n, int i,int z,ArrayList<Integer> backupRoad) {
        if (i == n&&z==2) {
            return true;
        }
        if (i == n&&z==1) {
           return findRoad(verticals, backupRoad, n, 1,z+1,road);
        }
        ArrayList<Integer> tos = verticals[i - 1].getTos();
        int x;
        for (int j = 0; j < tos.size(); j++) {
            x = tos.get(0);
            road.add(x);
            tos.remove(0);
            if (findRoad(verticals, road, n, x,z,backupRoad)) {
                return true;
            }
            tos.add(x);
            road.remove(Integer.valueOf(x));
        }
        return false;
    }
}