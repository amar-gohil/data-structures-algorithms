package mergeSort;

public class MergeSort3 {

		  void merge_sort (int A[ ] , int start , int end )
		   {
		           if( start < end ) {
		           int mid = (start + end ) / 2 ;           // defines the current array in 2 parts .
		           merge_sort (A, start , mid ) ;                 // sort the 1st part of array .
		           merge_sort (A,mid+1 , end ) ;              // sort the 2nd part of array.

		         // merge the both parts by comparing elements of both the parts.
		           mergezz(A,start , mid , end );   
		   }                    
		}
		
		 void mergezz(int A[ ] , int start, int mid, int end) {
			 //stores the starting position of both parts in temporary variables.
			int p = start ,q = mid+1;

			int Arr[] = new int[end-start+1];
			int k=0;

			for(int i = start ;i <= end ;i++) {
			    if(p > mid)      //checks if first part comes to an end or not .
			       Arr[ k++ ] = A[ q++] ;

			   else if ( q > end)   //checks if second part comes to an end or not
			       Arr[ k++ ] = A[ p++ ];

			   else if( A[ p ] < A[ q ])     //checks which part has smaller element.
			      Arr[ k++ ] = A[ p++ ];

			   else
			      Arr[ k++ ] = A[ q++];
			 }
			  for (int fv=0 ; fv< k ;fv ++) {
			   /* Now the real array has elements in sorted manner including both 
			        parts.*/
			     A[ start++ ] = Arr[ fv ] ;                          
			  }
			}
		 


		public static void main(String[] args) {
			int arr [] = {5,4,3,2,1};
			System.out.print("before sort ==>  ");
			printArray(arr);
			MergeSort3 obj = new MergeSort3();
			obj.merge_sort(arr, 0 , arr.length -1);
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
