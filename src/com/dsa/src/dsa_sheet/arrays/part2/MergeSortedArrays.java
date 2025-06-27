package com.dsa.src.dsa_sheet.arrays.part2;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void mergeSortedArrays(int[] a, int[] b){
		int i=a.length - 1, j=0; 
		while(i>=0 && j<b.length) {
			if(a[i] <= b[j]) {
				break;
			} else {
				// swap 
				int temp = a[i];
				a[i] = b[j];
				b[j] = temp;
				i--;
				j++;
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);
		for(int val: a)
			System.out.print(val + " ");
		System.out.println();
		for(int val: b) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 4, 8, 10, 13, 15, 18};
		int[] b = {2, 3, 9, 11, 14, 15, 32};
		mergeSortedArrays(a,b);
	}
}
