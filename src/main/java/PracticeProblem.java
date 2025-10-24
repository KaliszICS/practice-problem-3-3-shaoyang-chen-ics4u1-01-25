import java.util.ArrayList;
import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static ArrayList<String> perms (String word) {
		ArrayList<String> result = new ArrayList<>();
		if (word == null || word.isEmpty()) {
			return result;
		}
		allPerms(word.toCharArray(), 0, result);
		return result;
	}
	public static void allPerms(char[] chars, int start, ArrayList<String> result) {
		if (start == chars.length) {
			result.add(new String(chars));
			return;
		}
		for (int i = start; i < chars.length; i++) {
			swap(chars, start, i);
			allPerms(chars, start + 1, result);
			swap(chars, start, i);
		}
	}
	public static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
	public static ArrayList<String> permsUnique(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str == null || str.length() == 0) {
			return result;
		}
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		trackUP(chars, 0, result);
		return result;
	}
	public static void trackUP(char[] chars, int start, ArrayList<String> result) {
		if (start == chars.length) {
			result.add(new String(chars));
			return;
		}
		boolean[] used = new boolean[256];
		for (int i = start; i < chars.length; i++) {
			if (used[chars[i]]) {
				continue;
			}
			used[chars[i]] = true;
			swap(chars, start, i);
			trackUP(chars, start + 1, result);
			swap(chars, start, i);
		}
	}


}
