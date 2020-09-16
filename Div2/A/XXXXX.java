
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
 
		int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}
 
	}
	
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		FastReader sc =new FastReader();
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int x=sc.nextInt();
			int a[]=sc.nextIntArray(n);
			long sum=0;
			boolean div=true;
			for(int i=0;i<n;i++)
			{
				sum+=a[i];
				if(a[i]%x!=0)
				{
					div=false;
				}
			}
			if(div) 
			{
				System.out.println(-1);
				continue;
			}
			if(sum%x!=0)
			{
				System.out.println(n);
				continue;
			}
			long sum1=sum;
			long sum2=sum;
			int pref=n;
			int i=0;
			while(i<n)
			{
				if(sum1%x!=0)
				{
					break;
				}
				else
				{
					sum1=sum1-a[i];
					pref--;
				}
				i++;
			}
			int suff=n;
			i=n-1;
			while(i>=0)
			{
				if(sum2%x!=0)
				{
					break;
				}
				else
				{
					sum2=sum2-a[i];
					suff--;
				}
				i--;
			}
			
			System.out.println(Math.max(pref, suff));
			
				
			
			
			//long endTime = System.currentTimeMillis();
		    //System.out.println("It took " + (endTime - startTime) + " MILIseconds");
		    
			
		}
	}
	
 
}
