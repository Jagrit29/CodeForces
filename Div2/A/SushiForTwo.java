
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
		int a[]=sc.nextIntArray(n);
		int ones=0;
		int twos=0;
		int i=0;
		int ans=0;
		while(i<n)
		{
			if(a[i]==1)
			{
				int co=0;
				while(i<n && a[i]==1)
				{
					co++;
					i++;
				}
				ones=co;
			}
			else{
				int ct=0;
				while(i<n && a[i]==2)
				{
					ct++;
					i++;
				}
				twos=ct;
			}
			ans=Math.max(ans,2*Math.min(ones,twos));
			//ones=0;
			//twos=0;
		}
		System.out.println(ans);
		
	}
}
