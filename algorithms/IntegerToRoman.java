package logic;

public class IntegerToRoman {
	public static String romanToInt(int number) {
		String s = new String();
		while (number > 0) {
			if (number >= 1000) {
				number = number - 1000;
				s = s.concat("M");
			} else if (number >= 900) {
				number = number - 900;
				s = s.concat("CM");
			} else if (number >= 500) {
				number = number - 500;
				s = s.concat("D");
			} else if (number >= 400) {
				number = number - 400;
				s = s.concat("CD");
			} else if (number >= 100) {
				number = number - 100;
				s = s.concat("C");
			} else if (number >= 90) {
				number = number - 90;
				s = s.concat("XC");
			} else if (number >= 50) {
				number = number - 50;
				s = s.concat("L");
			} else if (number >= 40) {
				number = number - 40;
				s = s.concat("XL");
			} else if (number >= 10) {
				number = number - 10;
				s = s.concat("X");
			} else if (number >= 9) {
				number = number - 9;
				s = s.concat("IX");
			} else if (number >= 5) {
				number = number - 5;
				s = s.concat("V");
			} else if (number >= 4) {
				number = number - 4;
				s = s.concat("IV");
			} else {
				number = number - 1;
				s = s.concat("I");
			}
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt(3999));
	}
}
