package recursion;

public class CountZeros {

	public static void main(String[] args) {
		System.out.println(count(3550057));
	}
	
	static int count(int n) {
		return helper(n, 0); 
	}
	
	//special pattern, how to pass a value to above calls 
	private static int helper(int n, int c) {
		if(n == 0) {
			return c;
		}
		
		int rem = n%10;
		if(rem == 0) {
			return helper(n/10, c+1);
		}
		return helper(n/10 , c);
	}
	
	public int numberOfSteps(int num) {
		return helperr(num,0);
	}
	private int helperr(int num,int steps) {
		if(num == 0) {
			return steps;
		}
		
		if(num%2 == 0) {
			return helperr(num/2, steps+1);
		}
		return helperr(num-1,steps+1);
	}
}
