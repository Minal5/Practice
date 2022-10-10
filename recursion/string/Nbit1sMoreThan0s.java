package recursionString;
//https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

public class Nbit1sMoreThan0s {

	public static void main(String[] args) {
		int n = 3;
		solve(0,0,n,"");
	}
	
	public static void solve(int ones,int zeros,int n,String s) {
		if(n == 0) {
			System.out.println(s);
			return;
		}
		
		String op2 = s + "1";
		solve(ones+1,zeros,n-1,op2);
		
		if(ones > zeros) {
			String op1 = s + "0";
			solve(ones,zeros+1,n-1,op1);
		}
	}

}
