package RECURSION.BACKTRACKING.Cryptarithmetic;
import java.util.*;

public class cryptarithmetic {

    // s1 -> SEND, s2 -> MORE, s3-> MONEY, String unique -> SENDMORY
    //idx to traverse on unique String
    public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
                                String s1, String s2, String s3) {
        if (idx == unique.length()) {
            int n1 = IntegerFromMap(s1, charIntMap);
            int n2 = IntegerFromMap(s2, charIntMap);
            int n3 = IntegerFromMap(s3, charIntMap);

            if (n1 + n2 == n3) {
                // print mapping in sorted order
                for (int i = 0; i < 26; i++) {
                    char ch = (char) (i + 'a');
                    if (charIntMap.containsKey(ch) == true) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch = unique.charAt(idx); // to denote each level

        for (int i = 0; i < 10; i++) {
            if (usedNumbers[i] == false) {

                //MARK
                usedNumbers[i] = true;
                charIntMap.put(ch, i);

                //LEVEL
                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);

                //UNMARK
                charIntMap.remove(ch);
                usedNumbers[i] = false;
            }
        }
    }

    public static int IntegerFromMap(String str, HashMap<Character, Integer> map) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int n = map.get(ch);

            num = (num * 10 + n);
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);

        scn.close();
    }
}
