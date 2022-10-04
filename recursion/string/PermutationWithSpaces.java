public class StringRecursion{ 
  public static void main(String[] args) {
    String s="ABC";
    //pass string first character as output and Input as substring from 1 
    //Because we only have 2 choices instead of 4.
		permutationWithSpaces("A","BC");
	}

  public static void permutationWithSpaces(String op,String ip) {
	  	if(ip.length() == 0) {
		  	System.out.println(op);
			  return;
	  	}
		
		  String op1 = op + " "+ip.charAt(0);
		  String op2 = op +ip.charAt(0);
		  permutationWithSpaces(op1, ip.substring(1));
		  permutationWithSpaces(op2, ip.substring(1));
		  return;
	  }
}
