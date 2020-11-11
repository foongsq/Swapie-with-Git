import java.util.ArrayList;

public class Wadrobe {
    private ArrayList<ArrayList<Integer>> combinations;
    private String combiString;
    private int[] wadrobeElemsSize;
    private int numOfSizes;
    private int largestWadrobeElem;

    public Wadrobe(int[] wadrobeElemsSize) {
        this.combinations = new ArrayList<>();
        this.combiString = "";
        this.wadrobeElemsSize = wadrobeElemsSize;
        this.numOfSizes = wadrobeElemsSize.length;
        this.largestWadrobeElem = wadrobeElemsSize[numOfSizes - 1];
    }

    public ArrayList<ArrayList<Integer>> getCombinations() {
        return this.combinations;
    }

    public String toString() {
        return this.combiString;
    }

    private void combinationsUtil(ArrayList<Integer> wadrobeElemsUsed, int highest,
                                       int spaceFilled, int spaceToFill) {
        if (spaceFilled == spaceToFill) {
            combinations.add(wadrobeElemsUsed);
            return;
        }
        if (spaceFilled > spaceToFill) {
            return;
        }
        for (int size : wadrobeElemsSize) {
            if (size >= highest) {
                ArrayList<Integer> nextCombi = new ArrayList<>();
                nextCombi.addAll(wadrobeElemsUsed);
                nextCombi.add(size);
                combinationsUtil(nextCombi, size, spaceFilled + size, spaceToFill);
            }
        }
    }

    private void displayCombinations(int spaceToFill) {
        this.combiString = "";
        String opening = "These are all possible combinations of wadrobe elements that fit the wall of size " + spaceToFill + "cm:\n";
        System.out.print(opening);
        this.combiString += opening;
        for (ArrayList<Integer> combination : combinations) {
            for (int size : wadrobeElemsSize) {
                int count = 0;
                for (int wadrobeElem : combination) {
                    if (wadrobeElem == size) {
                        count++;
                    }
                }
                if (size == largestWadrobeElem) {
                    System.out.print(size + "cm: " + count + " piece(s)");
                    System.out.println();
                    this.combiString += size + "cm: " + count + " piece(s)\n";
                } else {
                    System.out.print(size + "cm: " + count + " piece(s), ");
                    this.combiString += size + "cm: " + count + " piece(s), ";
                }
            }
        }
    }

    public void queryCombinations(int spaceToFill) {
        ArrayList<Integer> wadrobeElemsUsed = new ArrayList<>(); //starts with empty list
        combinationsUtil(wadrobeElemsUsed, 0, 0, spaceToFill);
        displayCombinations(spaceToFill);
    }
}
