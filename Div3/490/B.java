package Div3_490;
import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				StringBuffer bf = new StringBuffer(s.substring(0,i));
				bf.reverse();
				s=bf.toString()+s.substring(i);
			}
		}
		System.out.println(s);

	}

}
