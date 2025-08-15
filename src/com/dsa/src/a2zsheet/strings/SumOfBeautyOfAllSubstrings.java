package com.dsa.src.a2zsheet.strings;

public class SumOfBeautyOfAllSubstrings {


     public static int beautySum(String s) {
         int res = 0;
         for (int i = 0; i < s.length(); i++) {
             int[] freq = new int[26];
             for (int j = i; j < s.length(); j++) {
                 freq[s.charAt(j) - 'a']++;
                 int maxFreq = 0;
                 int minFreq = Integer.MAX_VALUE;
                 for (int k = 0; k < 26; k++) {
                     if (freq[k] > 0) {
                         maxFreq = Math.max(maxFreq, freq[k]);
                         minFreq = Math.min(minFreq, freq[k]);
                     }
                 }
                 res += (maxFreq - minFreq);
             }
         }
         return res;
     }


    private static int beautyOptimised(String s){
        int n=s.length(), sum=0;
        //handle edge cases
        if(n<=1) return 0;

        //aabcb
        for(int i=0; i<n; i++){
            //put starting element in the map
            int[] freqMap = new int[26];
            for(int j=i; j<n; j++){
                freqMap[s.charAt(j) - 'a']++;
                int maxFreq = 0, minFreq=n;
                for(int f: freqMap){
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }
                sum+=maxFreq-minFreq;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautyOptimised(s));
        System.out.println(beautySum(s));
    }
}
