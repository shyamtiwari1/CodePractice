package Code.CodeForces.A_LEVEL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/230/A
public class Dragons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> dragonStrength = new ArrayList();
        List<Integer> bonus = new ArrayList();
        /*
        s= 2 , n=2
        * dr 1  - 1 , bonus - 99
        * dr 2 - 100 , bonus - 0
        *
        * */
        for(int i = 0 ;i<n ; i++){
            int x = sc.nextInt(); // dragon strength
            int y = sc.nextInt();// bonus for defeating it
            dragonStrength.add(x);
            bonus.add(y);
        }
        List<List<Integer>> strengthBonusList = new ArrayList<>();
        for(int i = 0 ; i<n ;i++){
            strengthBonusList.add(List.of(dragonStrength.get(i) , bonus.get(i)));
        }
        strengthBonusList.sort(Comparator.comparingInt(list -> list.get(0)));

            for(int i = 0 ; i <n ; i++){
                if(s<=strengthBonusList.get(i).get(0)){
                    System.out.println("NO");
                    return;
                }else{
                    s= s+strengthBonusList.get(i).get(1);
                }
            }
            System.out.println("YES");
        }



    }
