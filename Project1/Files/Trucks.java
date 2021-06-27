import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class Trucks {
    private  Map<Integer,ArrayList<Integer>> truckM;
    public Trucks(){
      truckM = new HashMap<Integer,ArrayList<Integer>>();
    }

    public Map<Integer, ArrayList<Integer>> getTruckM() {
        return truckM;
    }
}