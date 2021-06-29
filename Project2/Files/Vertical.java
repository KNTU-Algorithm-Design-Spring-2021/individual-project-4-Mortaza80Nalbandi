import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vertical {
    private ArrayList<Integer> tos;

    public Vertical() {
        tos = new ArrayList<Integer>();
    }

    public void addTos(int to) {
        tos.add(to);
    }

    public void removeTos(int to) {
        tos.remove(Integer.valueOf(to));
    }

    public ArrayList<Integer> getTos() {
        return tos;
    }
}