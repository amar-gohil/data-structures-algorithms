package quicksort;

public class QuickSortLastPivot {

	static void quickSort(int arr[], int lb, int ub) {
		if (lb < ub) {
			int loc = partition(arr, lb, ub);
			partition(arr, lb, loc - 1);
			partition(arr, loc + 1, ub);
		}
	}

	static int partition(int arr[], int lb, int ub) {
		int i = (lb - 1);
		int p = arr[ub];
		for (int j = lb; j < ub; j++) {

			if (arr[j] <= p) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[ub];
		arr[ub] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();

	}
}
