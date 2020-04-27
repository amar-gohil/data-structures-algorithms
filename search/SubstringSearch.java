package search;

public class SubstringSearch {
	static boolean exactMatchexactMatch(char[] text, char[] pet, int textIndex, int petIndex) {
		if (textIndex == text.length && petIndex != pet.length)
			return false;
		if (petIndex == pet.length)
			return true;
		if (text[textIndex] == pet[petIndex])
			return exactMatchexactMatch(text, pet, textIndex + 1, petIndex + 1);
		return false;
	}

	static boolean contains(char[] text, char[] pet, int textIndex, int petIndex) {
		if (textIndex == text.length)
			return false;
		if (text[textIndex] == pet[petIndex]) {
			if (exactMatchexactMatch(text, pet, textIndex, petIndex))
				return true;
			else {
				contains(text, pet, textIndex + 1, petIndex);
			}
		}
		return contains(text, pet, textIndex + 1, petIndex);
	}

	public static void main(String[] args) {
		String text = "abcabcd";
		String pet = "abcd";
		System.out.println(contains(text.toCharArray(), pet.toCharArray(), 0, 0));
	}
}
