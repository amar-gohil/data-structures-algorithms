package lnsertionSort;

public class InsertionSort {
	void  insertionSort1(int arr[]){
		int l = arr.length;
		for(int i = 1; i < l; i++){
			int key = arr[i];
			int j = i -1;
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	void insertionSortForLoop(int arr[]){
		int l = arr.length;
		for(int i = 1 ; i < l ; i ++){
			for(int j = i; j > 0 && arr[j - 1] > arr[j]; j--){
				int temp = arr[j];
				arr[j] =arr[j-1];
				arr[j - 1] = temp;
			}
		}
	}
	void insertionSortWhileOnly(int arr[]){
		int l = arr.length;
		int i = 1;
		while(i<l){
			int key = arr[i];
			int j = i -1;
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
			i++;
		}
	}
	public static void main(String[] args) {
		int arr [] = {5,4,3,2,1};
		System.out.print("before sort ==>  ");
		printArray(arr);
		InsertionSort is1 = new InsertionSort();
		is1.insertionSortForLoop(arr);
		System.out.println();
		System.out.print("after sort ==>  ");
		printArray(arr);
	}
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
  
}
