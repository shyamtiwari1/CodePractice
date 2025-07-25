package LeetCode.Array;

public class RotateArrayBy90 {

//    https://leetcode.com/problems/rotate-image/description/



    public void rotate(int[][] matrix) {

        for(int i = 0 ; i<matrix.length;i++){
            for(int j = i+1 ; j < matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0 ; i <matrix.length;i++){
            matrix[i] = reverseRow(matrix[i]);
        }
    }

    public int[] reverseRow(int[] row){
        int i = 0 ; int j = row.length-1;
        while(i<=j){
            int tmp = row[i];
            row[i] = row[j];
            row[j]=tmp;
            i++;
            j--;
        }
        return row;
    }
}
