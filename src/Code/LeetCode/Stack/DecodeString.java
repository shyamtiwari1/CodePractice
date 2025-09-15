package Code.LeetCode.Stack;

import java.util.Stack;

public class DecodeString {


//https://leetcode.com/problems/decode-string/description/

    public static void main(String[] args) {


        String s1 = "3[a]2[bc]";

        System.out.println(decodeString(s1));

    }




        public static String decodeString(String s) {
            Stack<Integer> numberstack = new Stack<>();
            Stack<StringBuilder> stringstack = new Stack<>();
            StringBuilder curr = new StringBuilder();
            int num = 0 ;


            for(Character c : s.toCharArray()){
                if(Character.isDigit(c)){
                    num = num*10+(c-'0');
                }else if(c=='['){
                    numberstack.push(num);
                    stringstack.push(curr);
                    num = 0 ;
                    curr = new StringBuilder();
                }else if(c==']'){
                    int count = numberstack.pop();
                    StringBuilder prev = stringstack.pop();
                    StringBuilder temp = new StringBuilder(prev);
                    for(int i = 0 ; i <count ;i++){
                        temp.append(curr);
                    }
                    curr = temp;

                }else{
                    curr.append(c);

                }
            }
            return curr.toString();

        }
    }
