
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
			int odd=0;
			int even=0;
			for(int i=0;i<n;i++)
			{
				if(a[i]%2!=0)
				{
					odd++;
				}
				else
				{
					even++;
				}
			}
				if(odd%2==0) odd=odd-1; //I can take odd nm of odd elements;
				if(odd+even<x)
				{
					System.out.println("No");
				}
				else if(odd<=0 || (even==0 && x%2==0))
				{
					System.out.println("No");
				}
				else
				{
					System.out.println("Yes");
				}
				
			
			
			//long endTime = System.currentTimeMillis();
		    //System.out.println("It took " + (endTime - startTime) + " MILIseconds");
		    
			
		}
	}
	
 
}
