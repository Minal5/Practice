package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n=3;
		solve('S','D','H',n);
	}

	public static void solve(char src,char dest,char helper,int n) {
		if(n == 1) {
			System.out.println("Move "+n+" from "+src +" to " +dest);
			return;
		}
		solve(src,helper,dest,n-1);
		System.out.println("Move "+n+" from "+src +" to " +dest);
		solve(helper,dest,src,n-1);
		return;
	}
}

