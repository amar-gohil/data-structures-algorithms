
public class Bubble {
	static void bubbleSort(int arr[], int l) {
		for (int i = 0; i < l - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < l - i - 1; j++) {
				if (arr[j] >= arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
	}

	static void recursiveBubbleSort(int arr[], int n) {
		if (n == 1)
			return;
		for (int j = 0; j < n - 1; j++) {
			if (arr[j] >= arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		recursiveBubbleSort(arr, n - 1);
	}

	public static void main(String[] args) {
		int arr[] = { 15, 16, 6, 8, 5 };
		recursiveBubbleSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
	}

}
