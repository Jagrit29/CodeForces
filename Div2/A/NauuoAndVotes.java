
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
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=sc.nextInt();
		if(z==0)
		{
			if(x>y)
			{
				System.out.println('+');
			}
			else if(x<y)
			{
				System.out.println('-');
			}
			else
			{
				System.out.println('0');
			}
		}
		else{
			if(x>y)
			{
				//I need to check if all z are neg, will result be neg;
				if(y+z>=x)
				{
					System.out.println('?');
					return;
				}
				System.out.println('+');
			}
			else if(y>x)
			{
				if(z+x>=y)
				{
					System.out.println('?');
					return;
				}
				System.out.println('-');
			}
			else 
			{
				System.out.println('?');
			}
		}
	}
}
