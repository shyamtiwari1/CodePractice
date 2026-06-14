package smartcoin_preparation.leetcode.greedy;

public class CanPlaceFlowers {


    public static void main(String args[]){
        int[]flowerbed = new int[]{1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));

    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {


        for(int i = 0 ; i <flowerbed.length;i++){
            boolean leftempty = (i==0 || flowerbed[i-1]==0);
            boolean rightempty = (i==flowerbed.length-1 || flowerbed[i+1]==0);



            if(leftempty && rightempty && flowerbed[i]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;
    }
}
