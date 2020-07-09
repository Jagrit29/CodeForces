package A;
import java.util.*;
public class A231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		int c[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
			c[i]=sc.nextInt();
		}
		
		int total=0;
		for(int i=0;i<n;i++)
		{
			int solve=0;
			if(a[i]==1)
			{
				solve++;
			}
			if(b[i]==1)
			{
				solve++;
			}
			if(c[i]==1)
			{
				solve++;
			}
			if(solve>=2)
			{
				total++;
			}
		}
		System.out.println(total);

	}

}
