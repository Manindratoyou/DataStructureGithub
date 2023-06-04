package com.manindra.array;

public class MaximumAppearingElement {

    public static void main(String[] args) {
        int [] left={1,2,5,15};
        int [] right={5,8,7,18};
        //System.out.println(maxAppearSolOne(left,right));
        System.out.println(maximumOccurredElement(left,right,left.length));

    }
    static int maxAppearSolOne(int [] left,int [] right){ //check this solution
        int n= left.length;
        int [] frequency=new int[100];
        for (int i=0;i<n;i++)
            for (int j=left[i];j<=right[i];i++)
                frequency[j]+=1;
        int result=0;
        for (int i=1;i<100;i++)
            if (frequency[i]>frequency[result])
                result =i;
        return result;
    }
    static int MAX = 1000000;

    // Return the maximum occurred element in all ranges.
    static int maximumOccurredElement(int[] L, int[] R,
                                      int n)
    {
        // Initialising all element of array to 0.
        int[] arr = new int[MAX];

        // Adding +1 at Li index and
        // subtracting 1 at Ri index.
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
            if (R[i] > maxi) {
                maxi = R[i];
            }
        }

        // Finding prefix sum and index
        // having maximum prefix sum.
        int msum = arr[0];
        int ind = 0;
        for (int i = 1; i < maxi + 1; i++) {
            arr[i] += arr[i - 1];
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }

        return ind;
    }
}
