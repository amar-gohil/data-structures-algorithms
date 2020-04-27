
package array;

public class InsertUpdateDeleteOnPosition {
	static int addAtPosition(int arr[], int pos, int value, int l) {
		if (pos > l - 1)
			return -1;
		for (int i = l - 1; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
		arr[pos] = value;
		return 1;
	}

	static int deleteAtPosition(int arr[], int pos, int l) {
		if (pos > l - 1)
			return -1;
		for (int i = 0; i < l - 1; i++) {
			if (i < pos)
				continue;
			arr[i] = arr[i + 1];
		}
		return 1;
	}

	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < 5; i++)
			arr[i] = i + 1;
		int pos = 0, value = 8;
		addAtPosition(arr, pos, value, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		deleteAtPosition(arr, pos, arr.length);
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
