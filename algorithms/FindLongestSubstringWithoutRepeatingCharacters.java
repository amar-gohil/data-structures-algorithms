package logic;

import java.util.HashSet;

public class FindLongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		int start = 0;
		int end = 0;
		int max = 0;
		HashSet<Character> set = new HashSet<Character>();
		while (end < s.length()) {
			if(!set.contains(s.charAt(end))){
				set.add(s.charAt(end));
				end ++;
				max = Math.max(set.size(), max);
			}else {
				set.remove(s.charAt(start));
				start ++;
			}
		}
		System.out.println(max);
	}
}
