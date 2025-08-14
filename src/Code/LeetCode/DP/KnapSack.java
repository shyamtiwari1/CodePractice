package Code.LeetCode.DP;

public class KnapSack {


    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSackTopDown(W, weight, profit, n));
    }


 static int [][] t = new int [1001][1001];
//    void memset(t,-1,sizeof(t));
//    for (int i = 0; i < 1001; i++) {
//        Arrays.fill(t[i], -1);
//    }

    public static int knapSackRecursion(int W, int wt[], int val[], int n) {

        if(W==0 || n==0 ){
            return 0;
        }
        if(t[n][W]!=0){
            return t[n][W];
        }
        if(wt[n-1]<= W){
            return t[n][W] = Math.max(val[n-1]+ knapSackRecursion(W-wt[n-1] , wt, val , n-1) , knapSackRecursion(W , wt , val , n-1));
        }else{
            return t[n][W] = knapSackRecursion(W , wt , val , n-1);
        }
    }

    public static int knapSackTopDown(int W, int wt[], int val[], int n) {
        int [][] x = new int[n+1][W+1];
        for(int i = 0 ; i< n+1 ; i++){
            for(int j = 0 ; j< W+1;j++){
                if(i==0 || j==0 ){
                    x[i][j] = 0;
                }
            }
        }
            for(int i = 1 ; i< n+1 ; i++){
                for(int j = 1; j <W+1;j++){
                    if(wt[i-1]<=j){
                        x[i][j] = Math.max(val[i-1]+x[i-1][j-wt[i-1]] , x[i-1][j]);
                }else{
                        x[i][j] = x[i-1][j];
                    }
            }
        }
        return x[n][W];

    }
}
