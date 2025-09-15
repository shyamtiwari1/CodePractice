package Test;

public class Test5 {




public static void main(String[] args) {

    String[] strs = new String[]{"dog","racecar","car"};
    System.out.println(longestCommonPrefix(strs));

}



        public static String longestCommonPrefix(String[] strs) {
            String prefix = strs[0];

            for(int i = 1; i <strs.length;i++){
                int j = 0 ; int k = 0 ;
                while(j<prefix.length() && k<strs[i].length() && prefix.charAt(j)==strs[i].charAt(k)){
                    j++;
                    k++;
                }
                prefix = strs[i].substring(0,j);
            }
            return prefix;

        }
    }
