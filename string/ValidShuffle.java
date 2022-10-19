package string;

public class ValidShuffle {

	public static void main(String[] args) {
		System.out.println(validShuffle("12","XY","XZY2"));
	}

	public static boolean validShuffle(String s1,String s2,String res) {
		if(s1.length() +s2.length() != res.length()) return false;
		else {
			int f=0;
			int i=0,j=0,k=0;
			while(k<res.length()) {
				if(i<s1.length() && s1.charAt(i)==res.charAt(k))i++;
				else if(j<s2.length() && s2.charAt(j)==res.charAt(k))j++;
				else {
					f=1;
					break;
				}
				k++;
			}
			if(i<s1.length() || j<s2.length()) return false;
			return true;
		}
//		return true;
	}
	
}
