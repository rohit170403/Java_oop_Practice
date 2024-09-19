package practice;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
//		is prime or not 
		int f=0, num;
		System.out.println("enter a number ");
		Scanner sc = new Scanner(System.in);
		num= sc.nextInt();
		for(int i=2;i<=(num/2);i++)
		{
			if(num%i==0)
			{
				f=1;
				break;
			}
		}
		
		if(f==1)
		{
			System.out.println(num+"is a not a prime number");
		}
		else
		{
			System.out.println(num+"is a prime number");
		}
		

	}

}
