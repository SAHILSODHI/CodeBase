package Sorting;

class MergeSortClass{

    public static void merge(int[] A, int p, int q, int r){
        int n1 = q-p+1;                                                                 //if q=0, p=0, we want length 1.
        int n2 = r-q;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = A[p+i];                                                              // note
        }

        for(int j=0;j<n2;j++){
            R[j] = A[q+1+j];                                                            // note
        }

        int i=0;
        int j=0;
        int k=p;

        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++;
            } else{
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            A[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            A[k]=R[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] A, int p, int r){

        if(p<r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void printArray(int[] A){

        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+" ");
        }
    }

    public static void main(String[] args){

        int[] unsortedArray = {12, 11, 13, 5, 6, 7};
        mergeSort(unsortedArray,0,unsortedArray.length-1);
        printArray(unsortedArray);
    }
}