package array;

public class InsertUpdateDeleteOnPosition {
	static int size = 0;

	static int addAtPosition(int arr[], int pos, int value, int l) {
		if (pos > size)
			return -1;
		for (int i = size; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
		arr[pos] = value;
		size++;
		return 1;
	}

	static int deleteAtPosition(int arr[], int pos, int l) {
		if (pos > size)
			return -1;
		for (int i = pos; i < size; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
		return 1;
	}

	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < 5; i++) {
			arr[i] = i + 1;
			size++;
		}
		int pos = 0, value = 8;
		addAtPosition(arr, pos, value, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		deleteAtPosition(arr, 3, arr.length);
		System.out.println("After Delete");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		int updateEl = 44;
		int updatePos = 3;
		if (updatePos < arr.length - 1)
			arr[updatePos] = updateEl;
		System.out.println("After Update");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
