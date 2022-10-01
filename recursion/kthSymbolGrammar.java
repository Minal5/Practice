package recursion;

public class KthSymbolGrammar {

	public static void main(String[] args) {
		System.out.println(grammar(4,4));
	}

	public static int grammar(int n,int k) {
		if(n == 1 && k == 1) {
			return 0;
		}
		int mid = (int) Math.pow(2,n-1)/2;
		if(k <= mid) {
			return grammar(n-1, k);
		}
		else  {
			if(grammar(n-1, k-mid) == 1)
			return 0;
			else
				return 1;
		}
	}
}
