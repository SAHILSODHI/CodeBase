package ArrayAndStrings;

// Test Cases
// 1. Clockwise or anti-clockwise
// 2. N range from 0 to N
// 3. null values of elements
// 4. Both odd and even N


public class RotateMatrix {

    public static void swapMatrixElements(int[][] originalMatrix, int elementOne_i,int elementOne_j, int elementTwo_i, int elementTwo_j){
        int temp = originalMatrix[elementOne_i][elementOne_j];
        originalMatrix[elementOne_i][elementOne_j] = originalMatrix[elementTwo_i][elementTwo_j];
        originalMatrix[elementTwo_i][elementTwo_j] = temp;
    }

    public static void rotateMatrixClockwise(int[][] originalMatrix, int N){


        int numberOfLevels = N/2;
        int level = 0;
        int last = N-1;
        while(level< numberOfLevels){
            for(int i=level;i<last;i++){
                swapMatrixElements(originalMatrix,level, i, last-i+level, level);
                swapMatrixElements(originalMatrix,level, i, last, last-i+level);
                swapMatrixElements(originalMatrix,level, i, i, last);

            }
            level++;
            last--;
        }
    }

    public static void main(String[] args){

        int[][] originalMatrix = {{1,2,3,4},
                                  {5,6,7,8},
                                  {9,10,11,12},
                                  {13,14,15,16}};

        int[][] originalMatrixOdd = {{1,2,3},
                                     {4,5,6},
                                     {7,8,9}};

        rotateMatrixClockwise(originalMatrix, originalMatrix.length);
        for(int i=0;i<originalMatrix.length;i++){
            for(int j=0;j<originalMatrix[i].length;j++){
                System.out.print(originalMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
