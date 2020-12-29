package logic;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutations {

	static List<List<Integer>> permutations(int[] nums) {
		List<Integer> tmpList = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, tmpList, result);
		return result;
	}

	static private void backtrack(int[] nums, List<Integer> tmpList, List<List<Integer>> result) {
		if (tmpList.size() == nums.length) {
			result.add(new ArrayList<>(tmpList));
			return;
		}
		for (int num : nums) {
			if (tmpList.contains(num))
				continue;
			tmpList.add(num);
			backtrack(nums, tmpList, result);
			tmpList.remove(tmpList.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> list = permutations(new int[] { 1, 2, 3 });
		list.forEach(e -> {
			e.forEach(v -> {
				System.out.print(v + ", ");
			});
			System.out.println();
		});
	}
}
