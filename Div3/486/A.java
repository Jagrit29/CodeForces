package Div3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class A_486 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		HashSet<Integer> hs=new HashSet<>();
		List<Integer> ls=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			if(hs.contains(a[i]))
			{
				
			}
			else
			{
				hs.add(a[i]);
				ls.add(i+1);
			}
		}
		if((int)ls.size()>=k)
		{
			System.out.println("YES");
			StringBuffer bf =new StringBuffer("");
			for(int i=0;i<k;i++)
			{
				bf.append(ls.get(i)+" ");
			}
			bf.deleteCharAt(bf.length()-1);
			System.out.println(bf.toString());
		}
		else
		{
			System.out.println("NO");
		}

	}

}
