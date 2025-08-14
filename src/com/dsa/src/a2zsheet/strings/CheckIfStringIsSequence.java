package com.dsa.src.a2zsheet.strings;

public class CheckIfStringIsSequence {

    private static boolean checkSequenceOptimalSpace(String s){
        int n=s.length();
        for(int len = 1; len<=Math.min(18,n/2); len++){
            if (len > 1 && s.charAt(0) == '0') break;

            long first = Long.parseLong(s.substring(0, len));
            int i=0;

            while(i<n){
                String next = String.valueOf(first);
                if(i + next.length() > n || !s.startsWith(next,i)) break;
                i+=next.length();
                first++;
            }
            if(i==n) return true;
        }
        return false;
    }

    private static boolean checkSequenceOptimal(String s) {
        int n = s.length();
        // limit first number length so that parsing into long is safe
        for (int len = 1; len <= Math.min(18, n / 2); len++) {
            if (len > 1 && s.charAt(0) == '0') break; // leading zero case

            long first = Long.parseLong(s.substring(0, len));
            StringBuilder expected = new StringBuilder();
            long num = first;

            // build sequence until we reach or exceed original length
            while (expected.length() < n) {
                expected.append(num);
                num++;
            }

            if (expected.toString().equals(s)) return true;
        }
        return false;
    }

    private static boolean checkSequenceBruteForce(String s){
        int n=s.length(),currentNumLen=1;
        while(currentNumLen<=s.length()/2){

            int i=0;
            long currentNum=-1;

            while(i<n){
                int tempNumLen = (currentNum > 0) ? countDigits(currentNum + 1) : currentNumLen;
                if(i+tempNumLen>n) break;

                long newNum = Long.parseLong(s.substring(i,i+tempNumLen));
                if(currentNum<0 || currentNum+1 == newNum) currentNum = newNum;
                else break;
                i+=tempNumLen;
            }
            if(i==n) return true;
            currentNumLen++;
        }
        return false;
    }

    private static int countDigits(long num){
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "789101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990919293949596979899100101";
        String s2 = "9999991000000";
        System.out.println("Check if sequence 2 brute force: "+ checkSequenceBruteForce(s2));
        System.out.println("Check if sequence 1 brute force: "+ checkSequenceBruteForce(s));
        System.out.println("Check if sequence 2 optimal: "+ checkSequenceOptimal(s2));
        System.out.println("Check if sequence 1 optimal: "+ checkSequenceOptimal(s));
        System.out.println("Check if sequence 2 optimal space: "+ checkSequenceOptimalSpace(s2));
        System.out.println("Check if sequence 1 optimal space: "+ checkSequenceOptimalSpace(s));

    }
}
