package heapsort;

public class HeapSortWithMaxHeap {
	static void swap(int[] arr, int fpos, int spos) {
		int tmp;
		tmp = arr[fpos];
		arr[fpos] = arr[spos];
		arr[spos] = tmp;
	}

	static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		// check if left child is largest than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// check if right child is largest than root
		if (r < n && arr[r] > arr[largest])
			largest = r;

		if (largest != i) {
			swap(arr, largest, i);

			// call heapify method Recursively for new created(change) sub array
			heapify(arr, n, largest);
		}
	}

	static void heapSort(int[] arr, int n) {
		// create max heap for array from last but remove leaf element
		for (int i = (int) Math.floor(n / 2 - 1); i >= 0; i--)
			heapify(arr, n, i);
		for (int i = n - 1; i > 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 7, 1, 9, 3, 2, 10 ,23 ,56,23,31,25,75,31 };
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
