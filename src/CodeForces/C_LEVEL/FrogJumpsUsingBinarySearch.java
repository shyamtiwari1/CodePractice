package CodeForces.C_LEVEL;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class FrogJumpsUsingBinarySearch {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < t; i++) {
//            String s = reader.readLine();
//            int n = s.length();
//
//            int result = 0;
//            int left = 1 ; int right = s.length()+1; int answer = n+1 ;
//            while(left <= right){
//                int mid = (left +right)/2;
//                if(canReach(s, mid)){
//                    answer = mid;
//                    right = mid-1;
//                }else{
//                    left = mid+1;
//                }
//            }
//            result = answer;
//            System.out.println(result);
//        }
//    }
//
//    private static boolean canReach(String s, int mid) {
//        int n = s.length();
//        int lastPosition = 0;
//        for(int i = 0 ; i<n ; i++){
//            if(s.charAt(i)== 'R'){
//                if(i-lastPosition>mid){
//                    return false;
//                }
//                lastPosition = i;
//            }
//        }
//        return n+1-lastPosition<=mid;
//    }
//}


import java.io.*;
import java.util.*;

public class FrogJumpsUsingBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String s = reader.readLine();
            int n = s.length();

            // Binary search for the minimum value of d
            int left = 1, right = n + 1, answer = n + 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (canReach(s, mid)) {
                    answer = mid; // If mid works, try for a smaller d
                    right = mid - 1;
                } else {
                    left = mid + 1; // Otherwise, try for a larger d
                }
            }
            result.append(answer).append("\n");
        }

        System.out.print(result);
    }

    // Check if the frog can reach n+1 with a maximum jump of d
    private static boolean canReach(String s, int d) {
        int lastPos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                if (i - lastPos > d) return false; // Jump constraint violated
                lastPos = i; // Update the last reachable position
            }
        }
        return (s.length() + 1 - lastPos <= d); // Check the final jump
    }
}

