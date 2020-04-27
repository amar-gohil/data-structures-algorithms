package search;

public class JumpSearch {
	static int jumpSearch(int arr[], int k) {
		int n = arr.length;
		int step = (int) Math.floor(Math.sqrt(n));
		int prev = 0;
		while (arr[Math.min(step, n) - 1] < k) {
			prev = step;
			step = step + (int) Math.floor(Math.sqrt(n));
			if (prev >= n)
				return -1;
		}
		while (arr[prev] < k) {
			prev++;
			if (prev == Math.min(step, n))
				return -1;
		}
		if (arr[prev] == k)
			return prev;

		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
		System.out.println(jumpSearch(arr, 55));
	}

}
