package quicksort;

public class Quicksort1 {

	static void quickSrot(int arr[],int lb, int ub){
		if(lb < ub){
			int loc = partition(arr, lb, ub);
			quickSrot(arr,lb,loc-1);
			quickSrot(arr,loc+1,ub);
		}
	}
	static int partition(int[] arr, int lb, int ub){
		int p = arr[lb];
		int start = lb;
		int end = ub;
		while(start < end){
			while(arr[start]<=p&& start<ub){
				start ++;
			}
			while(arr[end]>p){
				end--;
			}
			if(start<end)
			{
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}			
		}		
	      arr[lb]=arr[end];
	      arr[end]=p;
		return end;
	}
	
	public static void main(String[] args) {
		int[] arr = { 16, 5, 34, 23, 2, 1 };
		quickSrot(arr,0,arr.length-1);
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
