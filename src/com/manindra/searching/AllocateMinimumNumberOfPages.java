package com.manindra.searching;

/*
minimize the maximum pages allocated
only contiguous pages can be allocated
 */
public class AllocateMinimumNumberOfPages {

    public static void main(String[] args) {
        int [] arr={10,20,30,40}; int k=2;//(no of student) op 60(10+20+30)
        int [] arr1={10,5,30,1,2,5,10,10}; int k1=3;//(no of student) op 30,(10+5)(30)(1+2+5+10+10)
        System.out.println(minimumPagesSolOne(arr,arr.length,k));
        System.out.println(minimumPagesSolTwoEfficient(arr,arr.length,k));
    }

    static int minimumPagesSolOne(int [] arr,int n,int k){
        if (k==1)
            return sum(arr,0,n-1);
        if (n==1)
            return arr[0];
        int result=Integer.MAX_VALUE;
        for (int i=1;i<n;i++)
            result=Math.min(result,Math.max(minimumPagesSolOne(arr, i, k-1),sum(arr, i, n-1)));
        return result;
    }
    static int sum(int [] arr, int b, int e){
        int sum=0;
        for (int i=b;i<=e;i++) {
            sum += arr[i];
        }
        return sum;
    }
    static int minimumPagesSolTwoEfficient(int [] arr,int n,int k){ //tc O(n*logn(sum-mx))
       int sum=0,mx=0;
       for (int i=0;i<n;i++){
           sum+=arr[i];
           mx=Math.max(mx,arr[i]);
       }
       int low=mx,high=sum,res=0;
       while (low<=high){
           int mid=(low+high)/2;
           if (isFeasible(arr,n,k,mid)){
               res=mid;
               high=mid-1;
           }else
               low=mid+1;
       }
       return res;
    }

    static boolean isFeasible(int [] arr,int n,int k,int ans){
        int req=1,sum=0;
        for (int i=0;i<n;i++){
            if (sum+arr[i]>ans){
                req++;
                sum=arr[i];
            }else
                sum+=arr[i];
        }
        return (req<=k);
    }
}
