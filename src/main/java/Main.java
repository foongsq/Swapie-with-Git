import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] wadrobeElemsSize = { 50, 75, 100, 120 };
        Wadrobe wadrobe = new Wadrobe(wadrobeElemsSize);

        wadrobe.queryCombinations(250);
    }
}
