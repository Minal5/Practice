package string;

public class StringReverse {

	public static void main(String[] args) {
      System.out.println(reverseString(s));


  }
  
  //Using recursion reverse string
  public static String reverseString(String s) {
	  	if(s.length()==1) {
		  	return s;
		  }
		  char ch = s.charAt(0);
		  return reverseString(s.substring(1)) + ch;
	}
  
  //Reversing string using iteration
  public static String reverse(String s){
		  StringBuilder sb= new StringBuilder();
		  for(int i=s.length()-1;i>=0;i--) {
			  sb.append(s.charAt(i));
		  }
		  return sb.toString();
	  }
}
