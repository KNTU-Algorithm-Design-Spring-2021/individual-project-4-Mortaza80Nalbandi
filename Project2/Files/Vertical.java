import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vertical {
    private int[] tos;
    public Vertical(int n){
        tos = new int[n];
    }

    public void addTos(int to,int j) {
        tos[j] = to;
    }

    public int[] getTos() {
        return tos;
    }
}