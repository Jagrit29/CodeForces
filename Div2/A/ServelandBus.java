
import java.util.*;
import java.math.*;
import java.beans.beancontext.BeanContextServiceAvailableEvent;
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
		int n=sc.nextInt();
		int t=sc.nextInt();
		int a[][]=new int[n][2];
		for(int i=0;i<n;i++)
		{
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
		}
		boolean take=false;
		int ans=-1;
		int minTime=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			//int count=1;
			while(a[i][0]<t)
			{
				//count++;
				a[i][0]+=a[i][1];
			}
		}
		for(int i=0;i<n;i++)
		{
			if(a[i][0]<minTime)
			{
				ans=i+1;
				minTime=a[i][0];
			}
		}
		System.out.println(ans);
	}
}
