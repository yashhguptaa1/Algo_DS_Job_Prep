package RECURSION.BACKTRACKING.Type1_PlaceUnplace;

import java.io.*;
import java.util.*;

public class q9PEP {

    public static void generateWords(int currIndex, String str, Character[] boxes,
            HashMap<Character, Integer> lastOccurence) {

        if (currIndex == str.length()) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(currIndex);

        // CONCEPT USED in combinations when we have identical items
        // lastBoxVis : to ensure identical items are placed after curr
        int lo = lastOccurence.get(ch);

        // OPTIONS
        for (int i = lo + 1; i < boxes.length; i++) {
            // isValid
            if (boxes[i] == null) {
                // PLACE
                boxes[i] = ch;
                // COMBINATION2 concept
                lastOccurence.put(ch, i);

                // LEVELS
                generateWords(currIndex + 1, str, boxes, lastOccurence);

                // UNPLACE
                boxes[i] = null;
                lastOccurence.put(ch, lo);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, spots, lastOccurence);
    }
}
