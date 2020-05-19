package quicksort;

public class QuickSort2 {

	static void quickSrot(int arr[], int lb, int ub) {
		if (lb < ub) {
			int loc = partition(arr, lb, ub);
			quickSrot(arr, lb, loc - 1);
			quickSrot(arr, loc + 1, ub);
		}
	}

	static int partitionFirstPivort(int arr[], int lb, int ub) {
		int p = arr[lb];
		int start = lb;
		int end = ub;
		while(start<end){
			while(arr[start]<=p && start<ub){
				start ++;
			}
			while(arr[end]>p){
				end --;
			}
			if(start<end)
			{
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
			}
		}
		arr[lb]=arr[end];
	    arr[end]=p;
		return end;
	}
	static int partition(int arr[],int lb, int ub){
		int p = arr[ub];
		int i = lb-1;
			for(int j = lb; j < ub; j ++){
				if(p>=arr[j]){
					i++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			int temp = arr[i+1];
			arr[i+1] = p;
			arr[ub]= temp;
		return i+1;
	}
	public static void main(String[] args) {
		int arr[] = { 4, 32, 5, 63, 3 };
		quickSrot(arr, 0, arr.length - 1);
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
