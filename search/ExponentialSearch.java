package search;

import java.util.Arrays;

public class ExponentialSearch {
	static int exponentialSearch(int arr[], int n, int k) {
		if (n == 0)
			return -1;
		if (arr[0] == k)
			return 0;
		int i = 1;
		while (i < n && arr[i] <= k)
			i = i * 2;
		return Arrays.binarySearch(arr, i / 2, Math.min(i, n), k);
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
		System.out.println(exponentialSearch(arr, arr.length, 55));
	}
}
