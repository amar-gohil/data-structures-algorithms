package logic;

public class TotalOccurrencesOfKInSortedArray {

	private static int linearSearch(int[] arr, int k) {
		int occurrences = 0;
		for (int i = 0; i < arr.length; i++) {
			if (k == arr[i])
				occurrences++;
		}
		return occurrences;
	}

	private static int binarySearch(int[] arr, int l, int r, int k) {
		if (r < l)
			return -1;
		int mid = l + (r - l) / 2;
		if (arr[mid] == k)
			return mid;
		if (arr[mid] > k)
			return binarySearch(arr, l, mid - 1, k);
		return binarySearch(arr, mid + 1, r, k);

	}

	private static int withBinarySearch(int[] arr, int n, int k) {
		int ind = binarySearch(arr, 0, arr.length - 1, k);
		if (ind == -1)
			return 0;

		int count = 1;

		int left = ind - 1;
		while (left > 0 && arr[left] == k) {
			count++;
			left--;
		}

		int right = ind + 1;
		while (right < n && arr[right] == k) {
			count++;
			right++;
		}
		return count;
	}

	private static int first(int[] arr, int l, int r, int n, int k) {
		if (r >= l) {
			int mid = (l + r) / 2;
			if (mid == 0 || k > arr[mid - 1] && arr[mid] == k)
				return mid;
			else if (k > arr[mid]) {
				return first(arr, mid + 1, r, n, k);
			} else {
				return first(arr, l, mid - 1, n, k);
			}
		}
		return -1;
	}

	private static int last(int[] arr, int l, int r, int n, int k) {
		if (r >= l) {
			int mid = (l + r) / 2;
			if (mid == n - 1 || k < arr[mid + 1] && arr[mid] == k)
				return mid;
			else if (k < arr[mid]) {
				return last(arr, l, mid - 1, n, k);
			} else {
				return last(arr, mid + 1, r, n, k);
			}
		}
		return -1;
	}

	private static int improvedBinarySearch(int arr[], int n, int k) {
		int i;
		int j;

		i = first(arr, 0, n - 1, n, k);

		if (i == -1)
			return i;

		j = last(arr, i, n - 1, n, k);

		return j - i + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7 };
		System.out.println("Find With linear Search = " + linearSearch(arr, 3));
		System.out.println("Find With Binary Search = " + withBinarySearch(arr, arr.length, 3));
		System.out.println("Find With Binary Search = " + improvedBinarySearch(arr, arr.length, 3));
	}
}
