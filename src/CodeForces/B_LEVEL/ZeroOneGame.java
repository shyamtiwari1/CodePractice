package CodeForces.B_LEVEL;

import java.util.*;

public class ZeroOneGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            processGame(s);
        }
    }
    private static void processGame(String s) {
        if (s.length() <= 1 || countDistinctCharacters(s) == 1) {
            System.out.println("NET");
            return;
        }
        int turnCount = 0;
        while (s.length() > 1) {
            int indexToRemove = findAdjacentPairIndex(s);
            if (indexToRemove == -1) {
                break;
            }
            s = s.substring(0, indexToRemove) + s.substring(indexToRemove + 2);
            turnCount++;
        }
        if (turnCount % 2 == 0) {
            System.out.println("NET");
        } else {
            System.out.println("DA");
        }
    }
    private static int countDistinctCharacters(String s) {
        Set<Character> distinctCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            distinctCharacters.add(c);
        }
        return distinctCharacters.size();
    }
    private static int findAdjacentPairIndex(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i) == '0' && s.charAt(i + 1) == '1') ||
                    (s.charAt(i) == '1' && s.charAt(i + 1) == '0')) {
                return i;
            }
        }
        return -1;
    }
}
