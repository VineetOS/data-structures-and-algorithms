package com.dsa.src.a2zsheet.arrays.lec3;

import java.util.*;

public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k &&  arr[k] == arr[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> betterApproach(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        Set<Integer> store = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prefix = -(arr[i] + arr[j]);
                if (store.contains(prefix)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], prefix);
                    temp.sort(null);
                    uniqueTriplets.add(temp);
                }
            }
            store.add(arr[i]);
        }
        return new ArrayList<>(uniqueTriplets);
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0};
        var betterApproachResult = betterApproach(arr);
        System.out.println("Better Approach Result: ");
        printResult(betterApproachResult);
        var result = threeSum(arr);
        System.out.println("Three Sum Result: ");
        printResult(result);
    }

    private static void printResult(List<List<Integer>> resultSet) {
        for (List<Integer> result : resultSet) {
            for (var num : result) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
    }
}
