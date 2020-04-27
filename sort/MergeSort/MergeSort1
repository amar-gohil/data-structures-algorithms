package mergeSort;

public class MergeSort1 {
	void mergeSort(int arr[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	void merge(int arr[], int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		int temp[] = new int[end - start + 1];

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			} else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		while (i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while (j <= end) {
			temp[k] = arr[j];
			k++;
			j++;
		}

		/*
		 * for(int zi = start; zi <= end; zi += 1) { arr[zi] = temp[zi - start];
		 * }
		 */
		for (int fv = 0; fv < k; fv++) {
			arr[start++] = temp[fv];
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 4, 3, 2, 1 };
		System.out.print("before sort ==>  ");
		printArray(arr);
		MergeSort1 obj = new MergeSort1();
		obj.mergeSort(arr, 0, arr.length - 1);
		System.out.println();
		System.out.print("after sort ==>  ");
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
