
public class Radix {
	static int getMax(int arr[], int l) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	static void redixSort(int arr[], int l) {
		int max = getMax(arr, l);
		for (int pos = 1; max / pos > 0; pos = pos * 10) {
			countSort(arr, l, pos);
		}

	}

	static void countSort(int arr[], int l, int pos) {
		int count[] = new int[l];
		int b[] = new int[l];

		for (int i = 0; i < l; i++)
			++count[(arr[i] / pos) % 10];

		for (int i = 1; i < l; i++)
			count[i] = count[i] + count[i - 1];

		for (int i = l - 1; i >= 0; i--)
			b[--count[(arr[i] / pos) % 10]] = arr[i];

		for (int i = 0; i < l; i++)
			arr[i] = b[i];

	}

	public static void main(String[] args) {
		int arr[] = { 432, 8, 530, 90, 88, 231, 11, 45, 677, 199 };
		redixSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
	}
}
