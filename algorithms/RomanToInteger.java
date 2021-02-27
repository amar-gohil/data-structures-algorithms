package logic;

public class RomanToInteger {
	public static int romanToInt(String s) {
		int I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;
		int sum = 0;
		int l = s.length();
		for (int i = 0; i < l; i++) {
			char ch = s.charAt(i);
			boolean isLast = i + 1 == l ? false : true;
			char next = 0;
			if (isLast) {
				next = s.charAt(i + 1);
			}
			if (ch == 'I') {
				if (isLast && (next == 'V' || next == 'X')) {
					if (s.charAt(i + 1) == 'V') {
						sum = sum + 4;
					} else {
						sum = sum + 9;
					}
					i++;
				} else {
					sum = sum + I;
				}
			} else if (ch == 'V') {
				sum = sum + V;
			} else if (ch == 'X') {
				if (isLast && (next == 'L' || next == 'C')) {
					if (s.charAt(i + 1) == 'L') {
						sum = sum + 40;
					} else {
						sum = sum + 90;
					}
					i++;
				} else {
					sum = sum + X;
				}
			} else if (ch == 'L') {
				sum = sum + L;
			} else if (ch == 'C') {
				if (isLast && (next == 'D' || next == 'M')) {
					if (s.charAt(i + 1) == 'D') {
						sum = sum + 400;
					} else {
						sum = sum + 900;
					}
					i++;
				} else {
					sum = sum + C;
				}
			} else if (ch == 'D')
				sum = sum + D;
			else if (ch == 'M')
				sum = sum + M;
		}
		return sum;
	}

	static int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

	static int romanToIntBestWay(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int s1 = value(s.charAt(i));
			if (i + 1 < s.length()) {
				int s2 = value(s.charAt(i + 1));
				if (s1 >= s2) {
					sum = sum + s1;
				} else {
					sum = sum + s2 - s1;
					i++;
				}
			} else {
				sum = sum + s1;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
