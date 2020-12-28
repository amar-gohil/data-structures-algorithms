package heapsort;

public class HeapSortWithMinHeap {

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

	static void heapSort(int[] arr, int n) {
		// create max heap for array from last but remove leaf element
		for (int i = (int) Math.floor(n / 2 - 1); i >= 0; i--) {
			heapify(arr, n, i);
		}
		// swap first element to last element one by one and call heapify
		for (int i = n - 1; i > 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 9, 3, 2, 10, 23, 56, 23, 31, 25, 75, 31 };
		heapSort(arr, arr.length);
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
