package march05;

import java.util.Arrays;

public class MergeSort{
    public static void main(String[] args){
        int[] arr1 = {5,4,3,2,1};
        MergeSortInPlace(arr1,0,arr1.length);
        System.out.println(Arrays.toString(arr1));



//        int[] ans = Mergesort(arr);
//        System.out.println(Arrays.toString(ans));





    }

    static int[] Mergesort(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] Left  = Mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] Right = Mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return Merge(Left,Right);
    }
    static int[] Merge(int[] first , int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }
            else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one array is not complete
        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;

    }
    public static void MergeSortInPlace(int[] arr, int s, int e){
        if (e - s == 1){
            return;
        }

        int mid = (s + e)/ 2;

        MergeSortInPlace(arr,s,mid);
        MergeSortInPlace(arr,mid,e);

        MergeInPlace(arr,s,mid,e);
    }

    private static void MergeInPlace(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e -s];

        int i = s;
        int j = mid;
        int k = 0;

        while(i < mid && j < e){
            if (arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length ; l++) {
            arr[s+l] = mix[l];
            
        }

    }
}