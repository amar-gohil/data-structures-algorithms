package logic;

public class FindKthSmallestNumber {
	@SuppressWarnings("unused")
	private static int findSmallestNumber(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	@SuppressWarnings("unused")
	private static int find2thSmalletstNumber(int[] arr) {
		int min1 = arr[0];
		int min2 = arr[1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min1) {
				min2 = min1;
				min1 = arr[i];
			} else if (arr[i] < min2) {
				min2 = arr[i];
			}
		}
		return min2;
	}

	static void swap(int[] arr, int fpos, int spos) {
		int temp = arr[fpos];
		arr[fpos] = arr[spos];
		arr[spos] = temp;
	}

	static void heapify(int[] arr, int n, int i) {
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		// check if left child is smallest than root
		if (l < n && arr[l] < arr[smallest]) {
			smallest = l;
		}

		// check if right child is smallest than root
		if (r < n && arr[r] < arr[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			swap(arr, smallest, i);
			// call heapify method Recursively for new created(change) sub array
			heapify(arr, n, smallest);
		}

	}

	static int usingMinHeap(int[] arr, int n, int k) {
		// create min heap for array from last but remove leaf element
		for (int i = (int) Math.floor(n / 2 - 1); i >= 0; i--) {
			heapify(arr, n, i);
		}
		// swap first element to last element one by one and call heapify
		for (int i = n - 1; i > n - k - 1; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
		return arr[n - k];
	}

	// Quick-Select : Approach similar to quick sort
	// Original value for left = 0 and right = n-1
	private static int findKthSmalletstNumberWithPartition(int[] arr, int left, int right, int k) {
		if (left == right)
			return arr[left];
		int pos = partition(arr, left, right);
		int count = pos - left + 1;
		if (count == k)
			return arr[pos];
		else if (count > k)
			return findKthSmalletstNumberWithPartition(arr, left, pos - 1, k);
		else
			return findKthSmalletstNumberWithPartition(arr, pos + 1, right, k - 1);
	}

	private static int partition(int arr[], int left, int right) {
		int x = arr[right];
		int index = left - 1;
		for (int j = left; j < right - 1; j++) {
			if (arr[j] <= x) {
				index = index + 1;
				int temp = arr[index];
				arr[index] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[index + 1];
		arr[index + 1] = arr[right];
		arr[right] = temp;
		return index + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 9, 7, 2, 3, 8, 1, 5, 4 };
		System.out.println(findKthSmalletstNumberWithPartition(arr, 0, arr.length - 1, 3));
		System.out.println("with min heap " + usingMinHeap(arr, arr.length, 3));
	}
}
