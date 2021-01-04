package logic;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
	// time complexity is N2
	static char findFirstNonRepCharTwoLoop(char arr[], int l) {
		for(int i = 0; i < l; i ++){
			boolean flag = false;
			for(int j = 0; j < l; j ++){
				if(arr[i] == arr[j] && i != j){
					flag = true;
					break;
				}
			}
			if(!flag) return arr[i];
		}
		return '_';
	}
	// time complexity is 2N
	static char findFirstNonRepCharHashMap(char arr[], int l){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < l; i ++){
			if(map.get(arr[i]) == null) map.put(arr[i], 1);
			else {
				map.put(arr[i], map.get(arr[i])+1);
			}			
		}
		for(int i = 0; i < l; i ++){
			if(map.get(arr[i]) == 1)
				return arr[i];
		}
		
		return '_';
	}
	static char withIntArray(String s){
		int[] charCounts = new int[64];
		for(char c: s.toCharArray()){
			charCounts[c- 'A'] ++;
		}
		for(char c: s.toCharArray()){
			if(charCounts[c- 'A']==1)return c;
		}
		return '_';
	}
	static char indexOf(String s){
		for(char c : s.toCharArray()){
			if(s.indexOf(c)== s.lastIndexOf(c)) return c;
		}
		return '_';
	}
	public static void main(String[] args) {	
		char arr[] = { 'a','a','a','b','b','c','d' };
		System.out.println(findFirstNonRepCharHashMap(arr, arr.length));
		System.out.println(withIntArray("geeksforgeeks"));
	}
}
