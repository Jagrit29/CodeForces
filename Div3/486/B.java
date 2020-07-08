package Div3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B_486 {
	
	//Shoti length wale aage hi ayege;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		
		String s[]=new String[n];
		for(int i=0;i<n;i++)
		{
			s[i]=sc.next();
			
		}
		//System.out.println(Arrays.toString(s));
		Arrays.sort(s,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
			
		});
		
		//checking if someone is not there;
		String ans="YES";
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(s[j].indexOf(s[i])==-1)
				{
					ans="NO";
					break;
				}
			}
		}
		if(ans=="YES")
		{
			System.out.println("YES");
			for(int i=0;i<n;i++)
			{
				System.out.println(s[i]);
			}
			//System.out.println();
		}
		else
		{
			System.out.println("NO");
		}
		

	}

}
