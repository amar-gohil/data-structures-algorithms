
public class CountSort {

	static void countSort(int arr[], int l) {
		int count[] = new int[10];
		int b[] = new int[l];
		for (int i = 0; i < l; i++)
			++count[arr[i]];

		for (int i = 1; i < 10; i++)
			count[i] = count[i] + count[i - 1];

		for (int i = l - 1; i >= 0; i--)
			b[--count[arr[i]]] = arr[i];

		for (int i = 0; i < l; i++)
			arr[i] = b[i];
	}

	public static void main(String[] args) {
		int arr[] = { 2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9 };
		countSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
	}
}
