public class BinarySearch {
  
  	int binarySearchRecursive(int[] arr,int firstIndex,int lastIndex,int key){
		if(lastIndex >= firstIndex){
			int mid = firstIndex + (lastIndex - firstIndex) / 2;
			if(arr[mid] == key){
				return mid;
			}
			if(arr[mid] < key){
				return binarySearchRecursive(arr, mid +1 , lastIndex, key);
			}else {
				return binarySearchRecursive(arr,firstIndex , mid -1 , key);
			}
		}
		return -1;
	}
	int binarySearchWhile(int[] arr,int firstIndex,int lastIndex,int key){
		while(lastIndex >= firstIndex){
			int mid = firstIndex + (lastIndex - firstIndex) / 2;
			if(arr[mid] == key){
				return mid;
			}
			if(arr[mid] < key){
				firstIndex = mid +1;
			}else {
				lastIndex=  mid -1 ;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int key =20;
		int arr[] = {2,3,4,10,40};
		int firstIndex = 0;
		int lastIndex = arr.length-1;
		int index = binarySearch.binarySearchRecursive(arr,firstIndex,lastIndex,key);
		if(index > -1){
			System.out.println(key +" is on index "+index);
		}
		else {
			System.out.println(key +" is not found");
		}
		
	}
}
