package com.dsa.src.a2zsheet.binary_search.lec2;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMaxDistGasStations {

    private static class Pair {
        double gap;
        int section;

        Pair(double gap, int count) {
            this.gap = gap;
            this.section = count;
        }

    }

    private static double binarySearch(int[] stations, int k) {
        int n = stations.length;
        double diff = 1e-6; // Precision for floating point comparison
        double left = 0, right = 0;
        for (int i = 0; i < n - 1; i++) {
            right = Math.max(right, stations[i + 1] - stations[i]);
        }
        while(right-left>diff){
            double mid = left + (right - left) / 2;
            if (numberOfGasStationsRequired(stations, mid, k)) {
                right = mid; // Try for a smaller maximum distance
            } else {
                left = mid + diff; // Increase the minimum distance
            }
        }
        return right; // This will be the minimum maximum distance
     }


    private static boolean numberOfGasStationsRequired(int[] stations, double maxDistance, int k) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            if (gap > maxDistance) {
                count += (int) (Math.ceil(gap / maxDistance) - 1); // Calculate how many gas stations are needed
            }
            if(count>k) {
                return false; // If the count exceeds k, return false
            }
        }
        return count<= k; // Return true if the count is within the limit
    }

    private static double betterApproach(int[] stations, int k) {
        int n = stations.length;
        int[] sections = new int[n - 1];
        Queue<Pair> gaps = new PriorityQueue<>((a,b) -> Double.compare(b.gap, a.gap));
        // Calculate initial gaps between existing stations
        for (int i = 0; i < n - 1; i++) {
            gaps.offer(new Pair( (stations[i + 1] - stations[i]),i));
        }

        for(int i=1; i<=k; i++) {
            int sectionIndex;
            // Get the largest gap section
            Pair topPair = gaps.poll();
            if(Objects.nonNull(topPair))
                sectionIndex = topPair.section;
            else
                break; // No more gaps to process

            //update the section count
            sections[sectionIndex]++;

            // Divide the largest gap into two parts
            double newGap = (double) (stations[sectionIndex+1] - stations[sectionIndex])/ (sections[sectionIndex] + 1);

            // Add the new gaps back to the queue
            gaps.offer(new Pair(newGap, sectionIndex));
        }
        // After placing all gas stations, return the maximum distance
        return Objects.nonNull(gaps.peek())?gaps.peek().gap :-1;
    }

    private static double bruteForce(int[] stations, int k) {
        int n = stations.length;
        int[] gaps = new int[n-1];

        for(int j=1; j<=k; j++){
            //determine where to put each gas station
            int maxGapIndex = -1;
            double maxGap = -1;
            //calculate the gaps between existing stations and note the index with max gap
            for(int i=0; i < n - 1 ; i++) {
                double gap = (double) (stations[i + 1] - stations[i])/gaps[i]+1;
                if(gap > maxGap) {
                    maxGap = gap;
                    maxGapIndex = i;
                }
            }
            //insert a new gas station in the gap with max gap
            gaps[maxGapIndex]++;

        }
        //after all stations are placed, calculate the maximum distance between any two stations
        double maxDistance = 0;
        for(int i=0; i < n - 1; i++) {
            double distance = (double)(stations[i + 1] - stations[i]) / (gaps[i] + 1);
            maxDistance = Math.max(maxDistance, distance);
        }
        return maxDistance;
    }



    public static void main(String[] args) {
        int[] stations = {1, 5, 10};
        int k = 2;
        double result = bruteForce(stations, k);
        System.out.println("Minimum maximum distance brute force: " + result);
        result = betterApproach(stations, k);
        System.out.println("Minimum maximum distance better approach: " + result);
        result = binarySearch(stations, k);
        System.out.println("Minimum maximum distance binary search: " + result);
    }
}
