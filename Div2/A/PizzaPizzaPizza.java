
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
		long n=sc.nextLong();
		if(n==0 || n==1)
		{
			System.out.println(n);
		}
		else{
			if((n+1)%2==0)
			{
				System.out.println((n+1)/2);
			}
			else{
				System.out.println(n+1);
			}
		}
		/*
		BigInteger bb=new BigInteger(s);
		bb=bb.add(BigInteger.ONE);
		//System.out.println(bb.toString());
		BigInteger tt=new BigInteger("2");
		BigInteger rem=bb.mod(tt);
		BigInteger zz=new BigInteger("0");
		*/
		

        
	}
}
