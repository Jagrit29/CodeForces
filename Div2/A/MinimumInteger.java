
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
		int t=sc.nextInt();
		while(t-- > 0 )
		{
			int l=sc.nextInt();
			int r=sc.nextInt();
			int d=sc.nextInt();

			if(d<l)
			{
				System.out.println(d);
			}
			else if(d>=l && d<=r)
			{
				int rr=r%d;
				if(rr==0)
				{
					System.out.println(r+d);
				}
				else{
					System.out.println(r+(d-rr));
				}
			}
			else if(d>r)
			{
				System.out.println(d);
			}
		}
		
	}
}
