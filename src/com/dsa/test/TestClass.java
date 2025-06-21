package com.dsa.test;

public class TestClass {

    public static void main(String[] args) {
        Iterable<Integer> iterable = new Iterable<Integer>() {
            @Override
            public java.util.Iterator<Integer> iterator() {
                return new java.util.Iterator<Integer>() {
                    private int current = 0;

                    @Override
                    public boolean hasNext() {
                        return current < 5;
                    }

                    @Override
                    public Integer next() {
                        return current++;
                    }
                };
            }
        };
    }
}

