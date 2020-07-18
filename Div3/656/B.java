package Div3_656;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int a[]=new int[2*n];
			for(int i=0;i<2*n;i++)
			{
				a[i]=sc.nextInt();
			}
			
			HashSet<Integer> hs=new HashSet<>();
			StringBuffer bf =new StringBuffer("");
			for(int i=0;i<2*n;i++)
			{
				if(hs.contains(a[i])==false)
				{
					bf.append(a[i]+" ");
					hs.add(a[i]);
				}
			}
			System.out.println(bf.toString());
		}

	}

}
