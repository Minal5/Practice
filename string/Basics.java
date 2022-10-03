//https://www.java67.com/2018/06/data-structure-and-algorithm-interview-questions-programmers.html

package string;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Basics {

	public static void main(String[] args) {
		String s = "aabcd1e09fbcd1e09f";
//		duplicate(s);
//		String s1="race";
//		String s2="care";
//		System.out.println(anagram(s1,s2));
//		firstNonRepeatedChar(s);
//		System.out.println(reverseString(s));
//		System.out.println(containsDigits(s));
//		System.out.println(reverse(s));
//		String[] ch = s.split("\\s+");
		countVowelConsonant(s);
		
	}
	
	public static void duplicate(String s) {
		char[] ch=s.toCharArray();
		Arrays.sort(ch);
		for(int i=0;i<ch.length-1;i++) {
			if(ch[i] == ch[i+1]) {
				System.out.println(ch[i]);
			}
		}
	}
	
	public static boolean anagram(String s1,String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		char[] ch1=s1.toCharArray();
		Arrays.sort(ch1);
		char[] ch2=s2.toCharArray();
		Arrays.sort(ch2);
		for(int i=0;i<s1.length();i++) {
			if(ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void firstNonRepeatedChar(String s) {
		for(int i=0;i<s.length()-1;i++) {
			boolean unique = true;
			for(int j = 0;j<s.length();j++) {
				if(i != j && s.charAt(i) == s.charAt(j)) {
					unique = false;
					break;
				}
			}
			if(unique) {
				System.out.println(s.charAt(i));
				break;
			}
		}
		System.out.println("");
	}
	
	public static String reverseString(String s) {
		if(s.length()==1) {
			return s;
		}
		char ch = s.charAt(0);
		return reverseString(s.substring(1)) + ch;
	}

	  public static String reverse(String s){
		  StringBuilder sb= new StringBuilder();
		  for(int i=s.length()-1;i>=0;i--) {
			  sb.append(s.charAt(i));
		  }
		  return sb.toString();
	  }
	//Check if a String contains only digits? 
    //System.out.println(Pattern.matches("\\d", "0987")); // for only digits
	//Check if a String contains digits 
	public static boolean containsDigits(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) >= '0' && s.charAt(i)<='9') {
				return true;
			}
		}
		return false;
		
	}
	
	public static void countVowelConsonant(String s) {
		s = s.replaceAll("[^a-zA-Z]", "");
		int countv=0;
		int countc;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == 'a' ||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u' )
				countv++;
			
		}
		countc = s.length() - countv;
		System.out.println("vowel: " +countv +" consonant: " +countc);
	}
	
	

}

