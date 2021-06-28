import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.*;
public class SheepAndWolf{
    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Verticals : ");
        int n = scanner.nextInt();
        int x;
        Vertical[] verticals = new Vertical[n];
        for(int i=1;i<=n;i++){
            System.out.println("Enter number of out-go edges from V" + i);
            int m = scanner.nextInt();
            verticals[i-1] = new Vertical(m);
            System.out.println("Enter the Verticals");
            for(int j=0;i<m;i++){
                x = scanner.nextInt();
                verticals[i-1].add(x,j)
            }
        }
    }
}