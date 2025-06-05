package LeetCode.DP;

public class CoinChange {

//    https://leetcode.com/problems/coin-change/description/

    public static void main(String args[]){
        int [] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChangeTopDown(coins,amount , coins.length));

    }

    public static int coinChangeRecursive(int[] coins, int amount , int n ){
        if(amount ==0){
            return 0;
        }
        if(n==0){
            return Integer.MAX_VALUE - 1;
        }

        if(coins[n-1]<=amount){
            return Math.min(coinChangeRecursive(coins , amount , n-1) , 1+coinChangeRecursive(coins,amount-coins[n-1] , n));
        }else{
            return coinChangeRecursive(coins , amount , n-1);
        }
    }
    public static int coinChangeTopDown(int[] coins, int amount , int n){

        int [][] x = new int[n+1][amount+1];
        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j< amount+1 ; j++){
                if(i==0){
                    x[i][j] = Integer.MAX_VALUE - 1;
                }
                if(j==0){
                    x[i][j] = 0;
                }
            }
        }
        // amount -- > j , coins --> i
        for(int i = 1 ; i< n+1 ; i++){
            for(int j = 1 ; j< amount+1 ; j++){{
            if(coins[i-1]<=j){
                x[i][j] = Math.min(x[i-1][j] , 1+x[i][j-coins[i-1]]);
            }else{
                x[i][j] = x[i-1][j];
            }
            }
            }
        }
        return (x[n][amount] ==Integer.MAX_VALUE - 1) ? -1 : x[n][amount];
    }
}
