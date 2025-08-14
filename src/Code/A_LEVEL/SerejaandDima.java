package Code.A_LEVEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerejaandDima {
//    https://codeforces.com/problemset/problem/381/A

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        List<Integer> inputnumbers = new ArrayList<>();
        for(int i = 0 ; i<t ; i++){
            inputnumbers.add(sc.nextInt());
        }
        int leftIndex = 0 ;
        int rightIndex = t-1;
        int seerjaScore = 0 ;
        int deemaaScore = 0 ;
        int turnCount = 1;
        while(leftIndex<=rightIndex){
           if(turnCount%2==0){
               //deematurn
               if(inputnumbers.get(leftIndex)>=inputnumbers.get(rightIndex)){
                   deemaaScore+=inputnumbers.get(leftIndex);
                   leftIndex++;
               }else{
                   deemaaScore+=inputnumbers.get(rightIndex);
                   rightIndex--;
               }
           }else{
//               seerjaTurn
               if(inputnumbers.get(leftIndex)>=inputnumbers.get(rightIndex)){
                   seerjaScore+=inputnumbers.get(leftIndex);
                   leftIndex++;
               }else{
                   seerjaScore+=inputnumbers.get(rightIndex);
                   rightIndex--;
               }
           }
           turnCount++;

        }
        System.out.println(seerjaScore +" " + deemaaScore);

    }
}
