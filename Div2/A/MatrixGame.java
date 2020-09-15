
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
			int m=sc.nextInt();
			int a[][]=new int[n][m];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					a[i][j]=sc.nextInt();
				}
			}
			int count=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++) {
					if(a[i][j]==0)
					{
						boolean row=true;
						boolean col=true;
						for(int k=0;k<m;k++)
						{
							if(a[i][k]==1)
							{
								row=false;
								break;
							}
						}
						for(int k=0;k<n;k++)
						{
							if(a[k][j]==1)
							{
								col=false;
								break;
							}
						}
						if(row && col)
						{
							count++;
							a[i][j]=1;
						}
						
					}
				}
			}
			if(count%2==0)
			{
				System.out.println("Vivek");
			}
			else
			{
				System.out.println("Ashish");
			}
				
			
			
			//long endTime = System.currentTimeMillis();
		    //System.out.println("It took " + (endTime - startTime) + " MILIseconds");
		    
			
		}
	}
	
 
}
