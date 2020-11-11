import org.junit.Assert;
import org.junit.Test;

public class WadrobeTest {
    @Test
    public void queryCombinations_success() {
        String expectedResult = "These are all possible combinations of wadrobe elements that fit the wall of size 250cm:\n" +
                "50cm: 5 piece(s), 75cm: 0 piece(s), 100cm: 0 piece(s), 120cm: 0 piece(s)\n" +
                "50cm: 3 piece(s), 75cm: 0 piece(s), 100cm: 1 piece(s), 120cm: 0 piece(s)\n" +
                "50cm: 2 piece(s), 75cm: 2 piece(s), 100cm: 0 piece(s), 120cm: 0 piece(s)\n" +
                "50cm: 1 piece(s), 75cm: 0 piece(s), 100cm: 2 piece(s), 120cm: 0 piece(s)\n" +
                "50cm: 0 piece(s), 75cm: 2 piece(s), 100cm: 1 piece(s), 120cm: 0 piece(s)";

        int[] wadrobeElemsSize = { 50, 75, 100, 120 };
        Wadrobe wadrobe = new Wadrobe(wadrobeElemsSize);

        wadrobe.queryCombinations(250);

        Assert.assertEquals(expectedResult, wadrobe.toString());
    }
}
