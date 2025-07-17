package com.manindra.array_leetcode2;

import java.util.Arrays;

public class SortArray { //solution 912

    public static void main(String[] args) {

        SortArray obj=new SortArray();
        int[] nums1 = {5, 2, 3, 1};
        int[] sorted1 = obj.sortArray(nums1);
        System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(sorted1));

        int[] nums2 = {10, -1, 7, 4, 0};
        int[] sorted2 = obj.sortArray(nums2);
        System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(sorted2));
    }
    public int[] sortArray(int[] nums) { //Merge Sort
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public int[] sortArray2(int[] nums) { //Quick Sort
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(nums, low, high);
            quickSort(nums, low, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    ✅ Merge Sort
Time Complexity (TC):

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n log n)

Auxiliary Space (AS):

O(n) → for the temporary array used during merging.

Why:

It always divides the array into two halves → log n levels.

Each level requires O(n) time to merge elements.

✅ Quick Sort
Time Complexity (TC):

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n²) (when pivot always picks smallest or largest)

Auxiliary Space (AS):

O(log n) on average (recursive stack)

O(n) in the worst case (for highly unbalanced partitions)

Why:

Recursively partitions the array around a pivot.

Good performance on average, especially with randomized or median-of-three pivot.
     */
}


