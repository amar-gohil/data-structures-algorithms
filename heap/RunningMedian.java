package com.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RunningMedian {
    private static void addValue(int num, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || num < lower.peek()) lower.add(num);
        else higher.add(num);
    }

    private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;
        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double) smallerHeap.peek() + biggerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    private static void reliance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double[] runningMedian(int[] a) {
        int len = a.length;
        double[] median = new double[len];
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> higher = new PriorityQueue<Integer>();
        for (int i = 0; i < len; i++) {
            addValue(a[i], lower, higher);
            reliance(lower, higher);
            median[i] = getMedian(lower, higher);
        }
        return median;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(runningMedian(array)).forEach(e -> {
            System.out.print(e + " ");
        });
    }
}
