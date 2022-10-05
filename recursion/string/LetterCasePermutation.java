import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1B1"));
	}

public static List<String> letterCasePermutation(String s){
		return helper("" ,s.toLowerCase());
	}

	public static List<String> helper(String op, String s) {
		if(s.length() == 0) {
			List<String> ans = new ArrayList<>();
			ans.add(op);
			return ans;
		}
		
		if(Character.isAlphabetic(s.charAt(0))) {
			String op1 = String.valueOf(s.charAt(0));
			String op2 = String.valueOf(s.charAt(0)).toUpperCase();
			List<String> left = helper(op+op1,s.substring(1));
			List<String> right = helper(op+op2,s.substring(1));
			left.addAll(right);
			return left;
		}
		if(Character.isDigit(s.charAt(0))) {
			String op3 = String.valueOf(s.charAt(0));
			List<String> digit =helper(op+op3,s.substring(1));
			return digit;
		}
		
		return null;
	}
  
  //Output: [a1b1, a1B1, A1b1, A1B1]
}
