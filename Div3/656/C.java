package Div3_656;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
			}
			//increaseing and decreasing;
			//or directlying decreasing;
			
			//case1;
			if(n==1)
			{
				System.out.println(0);
				continue;
			}
			
			//case2;
			int i=n-1;
			while(i>=1 && a[i-1]==a[i]) {
				i--;
			}
			if(i==0)
			{
				System.out.println(0);
				continue;
			}
			
			//Now we need to check if its dec and then inc;
			boolean dec=false;
			while(i>=1 && a[i-1]<=a[i])
			{
				//because once it starts inc, we need to delete that;
				dec=true;
				//its decreasing;
				//so now when it increases stop there;
				i--;
			}
			if(dec==true)
			{
				System.out.println(i);
				continue;
			}
			
			//increase and dec;
			while(i>=1 && a[i-1]>=a[i])
			{
				//if its increasing, its fine;
				i--;
			}
			while(i>=1 && a[i-1]<=a[i])
			{
				//once it starts decreasing and then inc; it creates issue;
				i--;
			}
			System.out.println(i);
			
			
		}

	}

}
