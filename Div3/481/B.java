package Div3;

import java.util.Scanner;

public class B_481 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
		String s=sc.next();
		int count=0;
		int delete=0;
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			if(ch=='x')
			{
				count++;
			}
			else
			{
				count=0;
			}
			if(count==3)
			{
				delete++;
				count=2;
			}
		}
		System.out.println(delete);
	}

}
