package com.example.comparesorting;

import java.util.*;

public class CompareSorting {

    public static void main(String[] args) {

        BubbleSort bubble = new BubbleSort();

        Integer[] arrayData = new Integer[100];
        Random rand = new Random();

        for (int k = 0; k < arrayData.length; k++) {
            arrayData[k] = rand.nextInt(1500);
        }

        //Bubble Sort
        final long startTime = System.currentTimeMillis();
        bubble.bubbleSort(arrayData);
        System.out.println("Bubble Sort");
        for (int i = 0; i < arrayData.length; i++) {
            System.out.print(arrayData[i] + " ");
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("\nTotal execution time for Bubble Sort: " + (endTime - startTime) + " ms");

        //Top Down Sort
        final long startTimeTD = System.currentTimeMillis();
        List<Integer> topDownResult = TopDownSort.topDownSort(Arrays.asList(arrayData));
        System.out.println("\nTop Down Sort");
        for (int j = 0; j < topDownResult.size(); j++) {
            System.out.print(topDownResult.get(j) + " ");
        }
        final long endTimeTD = System.currentTimeMillis();
        System.out.println("\nTotal execution time for Top Down Sort: " + (endTimeTD - startTimeTD) + " ms");
    }

    static class BubbleSort {
        void bubbleSort(Integer arrayData[]) {
            int bubbleSortSize = arrayData.length;
            for (int i = 0; i < bubbleSortSize - 1; i++) {
                for (int j = 0; j < bubbleSortSize - i - 1; j++) {
                    if (arrayData[j] > arrayData[j + 1]) {
                        int temp = arrayData[j];
                        arrayData[j] = arrayData[j + 1];
                        arrayData[j + 1] = temp;
                    }
                }
            }
        }

    }

    static class TopDownSort {
        public static <T extends Comparable<T>> List<T> topDownSort(List<T> topDown) {

            if (topDown == null) throw new NoSuchElementException("List is empty.");

            if (topDown.size() <= 1) return topDown;

            //make lists
            List<T> left = new ArrayList<>();
            List<T> right = new ArrayList<>();

            //get midpoint
            int midpoint = topDown.size() / 2;

            //fill left list
            for (int i = 0; i < midpoint; i++) {
                if (topDown.get(i) != null) {
                    left.add(topDown.get(i));
                }
            }

            //fill right list
            for (int j = midpoint; j < topDown.size(); j++) {
                if (topDown.get(j) != null) {
                    right.add(topDown.get(j));
                }
            }

            //recursion
            left = topDownSort(left);
            right = topDownSort(right);

            return merge(left, right);
        }

        private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
            List<T> result = new ArrayList<>();

            // merge
            while (!left.isEmpty() && !right.isEmpty()) {
                if (left.get(0).compareTo(right.get(0)) <= 0) {
                    result.add(left.remove(0));
                } else {
                    result.add(right.remove(0));
                }
            }

            // Elements leftover
            while (!left.isEmpty()) {
                result.add(left.remove(0));
            }
            while (!right.isEmpty()) {
                result.add(right.remove(0));
            }
            return result;
        }
    }
}
