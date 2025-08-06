package com.dsa.src.a2zsheet.binary_search.lec2;

public class BookAllocationProblem {

    private static int allocateBooksBinarySearch(int[] books, int students){
        int maxPages = 0, totalPages = 0;
        for (int pages : books) {
            maxPages = Math.max(maxPages, pages);
            totalPages += pages;
        }
        int left = maxPages, right = totalPages;
        int minMaxPages = totalPages; // Initialize to the maximum possible pages
        while (left<=right){
            int mid = left + (right - left) / 2;
            if (canAllocate(books, students, mid)) {
                minMaxPages = mid; // Found a valid allocation, try for a smaller max pages
                right = mid - 1;
            } else {
                left = mid + 1; // Increase the max pages limit
            }
        }
        return minMaxPages; // This will be the minimum maximum pages allocation
    }

    private static int allocateBooks(int[] books, int students) {
        int maxPages = 0, totalPages = 0;
        for (int pages : books) {
            maxPages = Math.max(maxPages, pages);
            totalPages += pages;
        }
        for(int i = maxPages; i <= totalPages; i++) {
            if (canAllocate(books, students, i)) {
                return i; // Found the minimum maximum pages allocation
            }
        }
        return -1; // If no valid allocation is found
    }

    private static boolean canAllocate(int[] books, int students, int maxPages) {
        int allocatedStudents = 1;
        int currentPages = 0;

        for (int pages : books) {
            if (currentPages + pages > maxPages) {
                allocatedStudents++;
                currentPages = pages; // Allocate this book to the new student
                if (allocatedStudents > students) {
                    return false; // More students needed than available
                }
            } else {
                currentPages += pages; // Allocate to the current student
            }
        }
        return true; // Allocation is possible within the given max pages
    }

    public static void main(String[] args) {
        int[] books = {25, 46, 28, 49, 24};
        int students = 4;
        int result = allocateBooks(books, students);
        System.out.println("The maximum number of pages allocated to a student is: " + result);
        result = allocateBooksBinarySearch(books, students);
        System.out.println("The maximum number of pages allocated to a student using binary search is: " + result);
    }
}
