package logic;

import java.util.Arrays;

public class TwoElementsWhoseSumClosestToZero {

	// Time complexity: O(n^2), two for loop with check element with other
	static void minAbsSumPairWithTwoLoop(int[] arr, int n) {
		int minL = arr[0];
		int minR = arr[1];
		int min_sum = minL + minR;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];
				if (Math.abs(sum) < Math.abs(min_sum)) {
					min_sum = sum;
					minL = i;
					minR = j;
				}
			}
		}
		System.out.println(" minAbsSumPairWithTwoLoop " + arr[minL] + " and " + arr[minR]);
	}

	// complexity to sort + complexity of finding the optimum pair = O(nlogn) +
	// O(n) = O(nlogn)
	static void minAbsSumPairWithSortArray(int[] arr, int n) {
		if (n < 2)
			return;
		int sum, min_sum = 999999999;
		Arrays.sort(arr);
		int l = 0;
		int r = n - 1;
		int minL = l;
		int minR = r;
		while (l < r) {
			sum = arr[r] + arr[l];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				minL = l;
				minR = r;
			}
			if (sum < 0) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println("minAbsSumPairWithSortArray The two elements whose sum is minimum are " + arr[minL] + " and "
				+ arr[minR]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		minAbsSumPairWithTwoLoop(arr, arr.length);
		minAbsSumPairWithSortArray(arr, arr.length);
	}
}
