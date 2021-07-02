import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.util.*;
 public class PostCompany{
     public static void main(String[] args ){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter number of Items : ");
         int n = scanner.nextInt();
         System.out.println("Enter number of Trucks : ");
         int k = scanner.nextInt();
         int[] w = new int[n];
         System.out.println("Enter Weights of items : ");
         for(int i=0;i<n;i++){
             w[i] = scanner.nextInt();
         }
         GreedyOps go = new GreedyOps(n,k,w);
         Divided d1 =  go.greedyOp1();
         System.out.println("Max possible weight for a truck is equal : " + d1.getwMax() );
         Map<Integer, ArrayList<Integer>> trucks =d1.getTrucks().getTruckM();
         for(int i=1;i<=trucks.size();i++){
             System.out.println("Truck#" +i+" : "+trucks.get(i));
         }
     }
 }