
public class SingleElementInASortedArray {
    public static int singleNonDuplicate(int[] arr) {
        int ans = -1;
        int n = arr.length - 1;
        if (arr.length == 1)
            return arr[0];
        for (int i = 0; i < n; i += 2) {
            if (arr[i] != arr[i + 1]) {
                ans = arr[i];
                break;
            }
        }
        if (arr[n - 1] != arr[n]) {
            ans = arr[n];
        }
        return ans;
    }

    public static int singleNonDuplicateWithBS(int[] arr) {
        int ans = -1;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 4, 4, 5};
        System.out.println(singleNonDuplicate(arr));
    }
}
