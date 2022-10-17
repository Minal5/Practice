package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

public class FirstNegativeNumber {

	public static void main(String[] args) {
		int N = 5,K = 2;
		long A[] = {-8, 2, 3, -6, 10};
		long[] ans = printFirstNegativeInteger(A,N,K);
		System.out.println(Arrays.toString(ans));
	}
	
	public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
		long[] ans = new long[N-K+1];
		ArrayList<Long> neg=new ArrayList<>();
        int j=0,i=0,p=0;
        while(j<A.length) {
        	if(A[j]<0) {
        		neg.add(A[j]);
        	}
        	if((j-i+1)< K ) j++;
        	else if((j-i+1) == K) {
        		if(neg.isEmpty()) {
        			ans[p++] = 0;
        		}else {
        			ans[p++] = neg.get(0);
        			if(A[i] == neg.get(0)) {
        				neg.remove(0);
        			}
        		}		
        		j++;
        		i++;
        	}
        } 
		return ans;
    }

}
