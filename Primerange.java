package practice;

import java.util.Scanner;

public class Primerange {

	public static void main(String[] args) {
		int f,s, n;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a start number ");
		s= sc.nextInt();
		System.out.println("enter a end number ");
		n= sc.nextInt();
		for(int j=s;j<=n;j++)
		{
			f=0;
		for(int i=2;i<=(j/2);i++)
		{
			if(j%i==0)
			{
				f=1;
				break;
			}
		}
		
		if(f==0)
		{
			System.out.println(j);
		}
		
		}
		

	}

}
