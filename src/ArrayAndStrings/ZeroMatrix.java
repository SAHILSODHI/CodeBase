package ArrayAndStrings;

// Test Cases
// 1. The dimensions of M and N are different
// 2. null matrix

public class ZeroMatrix {

    public static void setZeros(int[][] matrix){

        boolean isRowZero = false;
        boolean isColumnZero = false;

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                isColumnZero=true;
            }
        }

        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                isRowZero=true;
            }
        }


        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j]=0;
                }
            }
        }
        if(isRowZero){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        if(isColumnZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args){

        int[][] matrix = {{0,2,3},{4,11,5},{0,6,7},{8,9,10}};
        setZeros(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
