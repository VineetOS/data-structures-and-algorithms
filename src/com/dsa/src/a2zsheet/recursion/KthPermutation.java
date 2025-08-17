package com.dsa.src.a2zsheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutation {

    static String optimalSolution(int n, int k){
        int index=0, k1=k-1, temp=1;
        int[] totalCombos = new int[n];
        StringBuilder res = new StringBuilder();
        List<Integer> number = new ArrayList<>();
        for(int i=1; i<=n; i++){
            temp*=i;
            totalCombos[i-1] = temp;
            number.add(i);
        }
        while(index<n){
            int partition = totalCombos[n-index-1]/(n-index);
            int startIndex = k1/partition;
            k1 = k1%partition;
            res.append(number.get(startIndex));
            number.remove(startIndex);
            index++;
        }
        return res.toString();
    }

    static String kthPermutation(int n, int k){
        StringBuilder str = new StringBuilder();
        ArrayList < String > res = new ArrayList < > ();
        for (int i = 1; i <= n; i++) {
            str.append(i);
        }
        permHelper(str.toString().toCharArray(),0,res);
        Collections.sort(res);
        return res.get(k-1);
    }

    static void permHelper(char[] str,int index, List<String> perms){
        if(index == str.length){
            perms.add(new String(str));
        }else{
            for(int i=index; i< str.length; i++){
                swap(str, i, index);
                permHelper(str, index+1, perms);
                swap(str, i, index);
            }
        }
    }

    static void swap(char[] s, int a, int b){
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public static void main(String[] args) {
        int n=4, k=17;
        System.out.println("Brute force: "+ kthPermutation(n,k));
        System.out.println("Optimal approach: "+ optimalSolution(n,k));
    }
}
