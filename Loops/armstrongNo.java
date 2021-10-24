import java.lang.*;
import java.util.*;

class ArmstrongNumber
{
	public static void main(String[] args)
	{
		int n,r;
		int count=0;
		
		
		System.out.println("enter the number");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		int m=n;
		/*while(n!=0)
		
		{
			r=n%10;
			n=n/10;
			count++;
			System.out.println("digit are :" +r);
			
		}*/
		
		//System.out.println("total number of digits are :  "  +count);
		
		/*int sum=0;
		
		while(n>0)
		{
			r=n%10;
			
			n=n/10;
			sum=sum+r*r*r;
		}
		
		//System.out.println(sum);
		if(sum==m)
		{
			System.out.println("It is an Armstrong number");
		}
		else 
		{
			System.out.println("It is not an Armstrong number");
		}*/
		
		int rev=0;
		System.out.println("Reverse of a number");
		
		while(n!=0)
		{
			r=n%10;
			rev=rev*10+r;
			n=n/10;
			
		}
		System.out.println(rev);
		if(rev==m)
		{
			System.out.println("Number is palindrome");
		}
		else
			System.out.println("Number is not palindrome");
		
	}
}
