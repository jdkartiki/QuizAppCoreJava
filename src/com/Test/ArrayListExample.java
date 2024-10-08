package com.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListExample {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();

        // Step 2: Insert elements into the ArrayList
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);
        numbers.add(2);

        //  ArrayList before sorting
        
        System.out.println("ArrayList before sorting: " + numbers);

        //  Sort the ArrayList in descending order
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // For descending order, reverse the comparison
                return o2.compareTo(o1);
            }
        });

        //  ArrayList after sorting
        System.out.println("ArrayList after sorting in descending order: " + numbers);
    }
}

