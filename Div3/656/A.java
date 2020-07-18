package Div3_656;

import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int a[]=new int[3];
			for(int i=0;i<3;i++)
			{
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			if(a[1]==a[2])
			{
				System.out.println("YES");
			    if(a[0]==a[1] && a[1]==a[2])
			    {
			    	System.out.println(a[0]+" "+a[1]+" "+a[2]);
			    }
			    else
			    {
			    	System.out.println(a[2]+" "+a[0]+" "+a[0]);
			    }
			}
			else
			{
				System.out.println("NO");
			}
			
		}
	}

}
