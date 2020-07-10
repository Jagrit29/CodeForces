package A;

import java.util.Scanner;

public class A96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		int one=0;
		int zero=0;
		boolean ans=false;
		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='1')
			{
				one++;
				zero=0;
			}
			else
			{
				zero++;
				one=0;
			}
			if(zero>=7 || one>=7)
			{
				ans=true;
				break;
			}
		}
		if(ans)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}

	}

}
