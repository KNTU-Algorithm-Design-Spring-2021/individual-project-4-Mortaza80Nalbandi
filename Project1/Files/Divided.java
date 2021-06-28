import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class Divided {
    private  Trucks trucks;
    private int wMax;
    public Divided( Trucks trucks,int wMax){
        this.trucks = trucks;
        this.wMax=wMax;
    }

    public int getwMax() {
        return wMax;
    }

    public Trucks getTrucks() {
        return trucks;
    }
}