package Code.CodeForces.A_LEVEL;

import java.util.Scanner;

public class ChoosingTeams {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            int x = scanner.nextInt();
            arr[i] = x;
        }
        int p = numberOfTeams(arr , k);
        System.out.println(p);
    }
    public static int numberOfTeams(int[] arr , int k){
        int count = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i]+k<=5){
                count++;
            }
        }
        return count/3;
    }
}