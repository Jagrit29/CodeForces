package A;
import java.util.*;
public class A160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		Arrays.sort(a);
		int min=0;
		long total=0;
		for(int i=0;i<n;i++)
		{
			total=total+a[i];
		}
		
	    long sum=0;
	    int j=n-1;
	    while(j>=0)
	    {
	    	if(sum>total)
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		total=total-a[j];
	    		sum=sum+a[j];
	    		min++;
	    		j--;
	    	}
	    }
	    System.out.println(min);

	}

}
