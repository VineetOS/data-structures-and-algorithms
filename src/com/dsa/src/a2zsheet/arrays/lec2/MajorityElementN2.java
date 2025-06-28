package com.dsa.src.a2zsheet.arrays.lec2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementN2 {

    private static int findMajorityMooreAlgorithm(int[] arr) {
        int n = arr.length, count = 0, element = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];
                count++;
            } else if (element == i) count++;
            else count--;
        }
        //verify if it is > n/2
        count = 0;
        for (int i : arr)
            if (i == element) count++;

        return count > n / 2 ? element : -1;
    }

    private static int findMajorityElementBetter(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int j : arr)
            frequencyMap.put(j, frequencyMap.getOrDefault(j, 0) + 1);

        //iterate through the frequency amp to find the element with frequency > n/2
        for (Map.Entry<Integer, Integer> element : frequencyMap.entrySet())
            if (element.getValue() > n / 2) return element.getKey();

        return -1;

    }

    private static int findMajorityElementBruteForce(int[] arr) {
        int n = arr.length;
        for (int j : arr) {
            int count = 0;
            for (int k : arr)
                if (j == k) count++;
            if (count > n / 2) return j;
        }
        return -1; // No majority element found
    }


    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4};
        System.out.println(findMajorityElementBruteForce(arr));
        System.out.println(findMajorityElementBetter(arr));
        System.out.println(findMajorityMooreAlgorithm(arr));
    }
}
