package string;

import java.util.Arrays;

public class ReplaceOccurenceWithCount {

	public static void main(String[] args) {
		System.out.println(replaceOccuranceWithCount("onetwot",'t'));
	}

	public static String replaceOccuranceWithCount(String s,char c) {
		int count=1;
		
		if(s.indexOf(c)==-1) {
			System.out.println("Does not contains character");
			System.exit(0);
		}
		char[] ch=s.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(ch[i]==c) {
				ch[i]=String.valueOf(count).charAt(0);
				count++;	
			}
		}
		//String ans=new String(ch);
		//String.valueOf(ch);
		return String.valueOf(ch);
	}
	
}
