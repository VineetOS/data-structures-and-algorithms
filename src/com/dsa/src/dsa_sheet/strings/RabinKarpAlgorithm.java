package com.dsa.src.dsa_sheet.strings;

public class RabinKarpAlgorithm {
    public static int rabinKarp(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int d = 256; // Number of characters in the input alphabet
        int q = 101; // A prime number
        int p = 0; // Hash value for pattern
        int t = 0; // Hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern.
            if (p == t) {
                // Check for characters one by one
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i; // Pattern found at index i
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0) {
                    t += q;
                }
            }
        }

        return -1; // Pattern not found
    }
}
