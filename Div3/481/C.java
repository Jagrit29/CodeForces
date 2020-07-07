package Div3;

import java.util.Arrays;
import java.util.Scanner;

public class C_481 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int dorms=sc.nextInt();
		int m=sc.nextInt();
		
		long rooms[]=new long[dorms];
		for(int i=0;i<dorms;i++)
		{
			rooms[i]=sc.nextLong();
		}
		
		long csum[]=new long[dorms];
		csum[0]=(long)rooms[0];
		for(int i=1;i<dorms;i++)
		{
			csum[i]=csum[i-1]+rooms[i];
		}
		
		long letters[]=new long[m];
		for(int i=0;i<m;i++)
		{
			letters[i]=sc.nextLong();
		}
		//System.out.println(Arrays.toString(letters));
		//System.out.println(Arrays.toString(csum));
		for(int i=0;i<m;i++)
		{
			int ind=bs(csum,letters[i]);
			//System.out.println(ind);
			if(ind==0)
			{
				System.out.println((ind+1)+" "+letters[i]);
			}
			else
			{
				int x=ind+1;
				//System.out.println(x);
				long ans=letters[i]-csum[ind-1];
				System.out.println(x+" "+ans);
			}
			
			
		}
		
		
		//10 25 37
		

	}
	
	public static int bs(long a[],long ele)
	{
		int low=0;
		int high=a.length-1;
		int ans=-1;
		while(low<=high)
		{
			int mid=(low)+(high-low)/2;
			if(ele<=a[mid])
			{
				ans=mid;
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		return ans;
	}

}
