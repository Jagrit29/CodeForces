package Div3_490;
import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int k=sc.nextInt();
		
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		int count=0;
		int i=0;
		for(i=0;i<n;i++)
		{
			if(a[i]<=k)
			{
				count++;
			}
			else
			{
				break;
			}
		}
		
		int j=n-1;
		while(j>=i && j>=0)
		{
			if(a[j]<=k)
			{
				count++;
				j--;
			}
			else
			{
				break;
			}
		}
		System.out.println(count);

	}

}
