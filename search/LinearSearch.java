package com.amar.search;

public class LinearSearch {

	int linearSearch(int[] arr, int key){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == key) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		LinearSearch binarySearch = new LinearSearch();
		int key = 40;
		int arr[] = {2,3,4,10,40};
		
		int index = binarySearch.linearSearch(arr, key);
		if(index > -1){
			System.out.println(key +" is on index "+index);
		}
		else {
			System.out.println(key +" is not found");
		}
		
	}	
}
