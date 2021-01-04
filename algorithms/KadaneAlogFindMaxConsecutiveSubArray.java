package logic;

public class KadaneAlogFindMaxConsecutiveSubArray {
	static int findMaxSubArray(int arr[]){
		int maxSum = arr[0];
		int currentSum = maxSum;
		for(int i = 0; i < arr.length-1; i++){
			currentSum = Math.max(arr[i]+currentSum, arr[i]);
			maxSum = Math.max(currentSum, maxSum);
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int arr[] = {-2,2,5,-11,6};
		System.out.println(findMaxSubArray(arr));
	}
}
