package com.dsa.src.a2zsheet.arrays.lec2;

public class RearrangeArrayElementsBySign {

    private static void rearrangeArray(int[] arr){
        int i=0, j=1;
        for(int k: arr){
            if(k<0){
                arr[j] = k;
                j+=2;
            }else{
                arr[i] = k;
                i+=2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6};
        rearrangeArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
