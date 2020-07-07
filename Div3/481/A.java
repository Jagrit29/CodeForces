package Div3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A_481 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		int ans[]=new int[1001];
		Arrays.fill(ans,0);
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=n-1;i>=0;i--)
		{
			if(ans[a[i]]>0)
			{
				continue;
			}
			else
			{
				list.add(a[i]);
				ans[a[i]]++;
			}
		}
		Collections.reverse(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
		System.out.println();

	}

}
