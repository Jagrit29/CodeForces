
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
		
		long x=sc.nextLong();
		long y=sc.nextLong();
		long z=sc.nextLong();

		long c1=0;
		long c2=0;
		c1=x/z;
		c2=y/z;
		long r1=x%z;
		long r2=y%z;
		long given=0;
		if(r1+r2>=z)
		{
			c1++;
			given=Math.min(z-r1,z-r2);
		}
		else{
			r1=0;
		}
		System.out.println((c1+c2)+" "+Math.min(r1,given));
	}
}
