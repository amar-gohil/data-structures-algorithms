package search;

public class LinearRecursiveSearch {

	static int linearRecursiveSearch(int arr[], int l, int r, int k) {
		if (r < l)
			return -1;
		if (arr[l] == k)
			return l;
		if (arr[r] == k)
			return r;
		return linearRecursiveSearch(arr, l + 1, r - 1, k);
	}

	public static void main(String[] args) {
		int arr[] = { 44, 33, 66, 22, 32, 1 };
		System.out.println(linearRecursiveSearch(arr, 0, arr.length - 1, 66));
	}
}
