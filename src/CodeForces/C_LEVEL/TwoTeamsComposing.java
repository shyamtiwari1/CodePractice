package CodeForces.C_LEVEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwoTeamsComposing {

    /*
    * bith teams should have same size
    * 1st team should have members with distinct skills
    * 2nd team should have members with same skills
    *case 1 : any member of second team has similar skills as of team one member -> {
    * lets say x distinct skills are there
    * x-1   = size of team a
    * y = size of team b (y be the count of same skill)
    * } which ever is greater
    *case 2 : no member of team two has same skill as of members of team one
    * x-1 = size of team a
    *
    *
    * */



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int  t = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i<t ; i++){
            int n = Integer.parseInt(reader.readLine());
            String[] input  = reader.readLine().split(" ");
            Map<Integer , Integer> strengthCount = new HashMap<>();
            for(int j= 0 ;j<n ; j++){
                int skill = Integer.parseInt(input[j]);
                strengthCount.put(skill , strengthCount.getOrDefault(skill , 0)+1);
            }
            List<Map.Entry<Integer , Integer>> list = new ArrayList<>(strengthCount.entrySet());
            list.sort(Map.Entry.comparingByValue());
            int x = Math.min(list.size()-1 , list.get(list.size()-1).getValue());
            if(list.get(list.size()-1).getValue() -1 >= list.size()){
                System.out.println(list.size());
        }else{
                System.out.println(x);
            }
            }
    }
}
