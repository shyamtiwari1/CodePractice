package smartcoin_preparation.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTempratures {



        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;

            int[] ans = new int[n];

            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> mpp = new HashMap<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    mpp.put(stack.pop(), i);
                }
                stack.add(i);
            }

            for(int i = 0 ; i <n;i++){
                if(mpp.containsKey(i)){
                    ans[i]= mpp.get(i)-i;
                }else{
                    ans[i] = 0 ;
                }

            }

            return ans;
    }
}
