package RECURSION.BACKTRACKING.Type2_YesNoCall;
import java.util.*;

public class maxScore {

    // Max Score
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if (idx == words.length)
            return 0;

        // no call
        int no_ans = solution(words, farr, score, idx + 1);

        // yes call
        String word = words[idx];
        int myScore = 0;
        boolean flag = true;
        // exhaust frequency + make score for current
        for (int i = 0; i < word.length(); i++) {
            int charIndx = word.charAt(i) - 'a';
            myScore += score[charIndx];

            if (farr[charIndx] <= 0) {
                flag = false;
            }
            farr[charIndx]--;
        }
        int yes_ans = 0;
        if (flag == true) {
            yes_ans = myScore + solution(words, farr, score, idx + 1);
        }
        // reset frequencies
        for (int i = 0; i < word.length(); i++) {
            int charIndx = word.charAt(i) - 'a';
            farr[charIndx]++;
        }
        return Math.max(no_ans, yes_ans);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            scn.close();

            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

        scn.close();
    }
}