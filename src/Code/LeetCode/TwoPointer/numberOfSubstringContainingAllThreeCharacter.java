package Code.LeetCode.TwoPointer;

public class numberOfSubstringContainingAllThreeCharacter {
//    https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

    public static void main (String args[]){
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));

    }

    public static int numberOfSubstrings(String s) {
        int[] lastSeen = new int[]{-1,-1,-1};
        int j = 0 ; int n = s.length();
        int count = 0 ;
        while(j<n){
            lastSeen[s.charAt(j)-'a'] = j;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                int minLastSeen = Math.min(Math.min(lastSeen[0] ,lastSeen[1]),  lastSeen[2]);
                count = count +minLastSeen+1;
            }

            j++;
        }
        return count;

    }
}
