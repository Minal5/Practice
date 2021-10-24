import java.lang.*;
import java.util.*;

class Factorial
{
	public static void main(String args[])
	{
		/*int n,i;
		System.out.println("Enter the number for multiplication table");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(i=1;i<=10;i++)
		{
			System.out.println(n + "*" +i+ " = " +(n*i));
		}*/
		
		
		/*int m,sum,i;
		System.out.println("Enter the number");
		Scanner s=new Scanner(System.in);
		m=s.nextInt();
		sum=0;
		for(i=1;i<=m;i++)
		{
			
			sum=sum+i;
		}
		System.out.println("Sum of m natural no. is " + sum);*/
		
		int m,fact,i;
		System.out.println("Enter the number");
		Scanner s=new Scanner(System.in);
		m=s.nextInt();
		fact=1;
		for(i=1;i<=m;i++)
		{
			
			fact=fact*i;
		}
		System.out.println("Sum of m natural no. is " + fact);
	}
	
}
