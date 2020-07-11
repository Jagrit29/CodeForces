package A;
import java.util.*;
public class A1373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0)
		{
			long a=sc.nextLong();
			long b=sc.nextLong();
			long c=sc.nextLong();
			
			
			//if cost of buying 1 box of a less than cost of buying b box
			
			if(a<c)
			{
				System.out.print(1+" ");
			}
			else
			{
				System.out.print(-1+" ");
			}
			
		    //if cost of buying box is less than cost of buying that many itemsl
			
			if(c<(long)(a*b))
			{
				//buy box means b items;;
				System.out.println(b);
			}
			else
			{
				System.out.println(-1);
			}
		}

	}

}
