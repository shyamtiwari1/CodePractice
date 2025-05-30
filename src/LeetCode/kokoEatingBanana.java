package LeetCode;

public class kokoEatingBanana {

    public static void main(String args[]){
        int []arr = new int[]{30,11,23,4,20};
        int  h = 6;
        System.out.println(minEatingSpeed(arr, h));

    }
    public static int minEatingSpeed(int[] piles, int h) {

        int maximum = Integer.MIN_VALUE;
        for(int i = 0 ; i< piles.length; i++){
            if(piles[i]>maximum){
                maximum = piles[i];
            }
        }

        if(h==piles.length){
            return maximum;
        }
//        for(int i = 1 ; i<maximum;i++){
//            int time = 0;
//            time = getTime(piles, (double) i, time);
//            if(time<=h){
//                return (int)i;
//            }
//
//        }

        int left = 1; int right = maximum;
        while(left<=right){
            int mid = left+(right-left)/2;
            int time = getTime(piles , mid);
            if(time >h){
                right = mid-1;
            }
            if(time <=h){
                right = mid;
            }else{
                left = mid+1;
            }

        }
        return left;

    }

    private static int getTime(int[] piles, int i) {
        int time = 0 ;
        for(int j = 0; j< piles.length; j++){
            time +=Math.ceil((double)piles[j]/ i);
        }
        return time;
    }
}




