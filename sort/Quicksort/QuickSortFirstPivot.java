package quicksort;

public class QuickSortFirstPivot {
	static void quickSort(int arr[],int lb,int ub){
		if(lb<ub){
			int loc = partition(arr,lb,ub);
			partition(arr,lb,loc-1);
			partition(arr,loc+1,ub);
		}
	}
	static int partition(int arr[],int lb, int ub){
		int p = arr[lb];
		int start = lb;
		int end = ub;
		while(start<end){
			while(arr[start]<=p && start < ub){
				start++;
			}
			while(arr[end]>p){
				end--;
			}
			if(start<end){
				int temp =arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}}
		arr[lb]=arr[end];
	    arr[end]=p;
		return end;
		
	}
	public static void main(String[] args) {
		int[] arr = {5,6,4,2,1};
		quickSort(arr,0,arr.length-1);
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
