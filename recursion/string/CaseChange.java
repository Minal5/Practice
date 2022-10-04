public class CaseChange {

	public static void main(String[] args) {
		permutationWithCaseChange("","ab");
	}
	public static void permutationWithCaseChange(String op,String ip) {
		if(ip.length() == 0) {
			System.out.print(op+" ");
			return;
		}
		String op1 = String.valueOf(ip.charAt(0));
		String op2 = String.valueOf(ip.charAt(0)).toUpperCase();
		permutationWithCaseChange(op+op1,ip.substring(1));
		permutationWithCaseChange(op+op2,ip.substring(1));
		return;
	}

  //Output: ab aB Ab AB
  
}
