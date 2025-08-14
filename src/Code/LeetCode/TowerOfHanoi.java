package Code.LeetCode;

public class TowerOfHanoi {



    public static void towerOfHanoi(int n, int p, int q, int r) {
        if(n==0){
            return;
        }
        towerOfHanoi(n-1, p, r,q);
        System.out.println("moved "+String.valueOf(n) +" disc from "+String.valueOf(p) +" to "+ String.valueOf(r)+" using "+String.valueOf(q));
        towerOfHanoi(n-1, q,p,r);

    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        towerOfHanoi(n, 1, 2, 3);
    }
}
