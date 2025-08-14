package Code.A_LEVEL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusinessTrip {
    /*
    * 5
        1 1 1 1 2 2 3 2 2 1 1 1
    * 1 1 1 1 1 1 1 1 2 2 2 2 3
    * k= 5
    *
    *
    *
    *
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
         sc.nextLine();
         String s = sc.nextLine();
        String [] numbers = s.split(" ");
        List<Integer> growthOfEachMonth = new ArrayList<>();
        for(int i =0 ; i<numbers.length ; i++){
            growthOfEachMonth.add(Integer.parseInt(numbers[i]));
        }
        Collections.sort(growthOfEachMonth);
        int sum1 = 0 ;
        int j = growthOfEachMonth.size()-1 ;
        int numberOfMonth = 0;
        while(sum1<k && j>=0){
            sum1+=growthOfEachMonth.get(j);
            j--;
            numberOfMonth++;
        }
        if(sum1<k){
            System.out.println(-1);

        }else{
            System.out.println(numberOfMonth);
        }


    }
}
