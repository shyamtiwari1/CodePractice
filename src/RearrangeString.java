import java.util.*;

public class RearrangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int L = S.length();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        if (isValid(chars, L)) {
            System.out.println(new String(chars));
            return;
        }
        while (nextPermutation(chars)) {
            if (isValid(chars, L)) {
                System.out.println(new String(chars));
                return;
            }
        }
        System.out.println("impossible");
    }

    static boolean isValid(char[] arr, int L) {
        for (int i = 0; i < (L - 1) / 2 + 1; i++) {
            if (arr[i] == arr[L - i - 1]) return false;
        }
        return true;
    }

    static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        char temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        for (int a = i + 1, b = arr.length - 1; a < b; a++, b--) {
            temp = arr[a]; arr[a] = arr[b]; arr[b] = temp;
        }
        return true;
    }
}
