
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
		int n = sc.nextInt();
		int fre[]=new int[26];
		for(int i=0;i<n;i++)
		{
			String s=sc.next();
			for(char ch:s.toCharArray())
			{
				fre[ch-'a']++;
				break;
			}
		}
		long count=0;
		for(int i=0;i<26;i++)
		{
			long n1=0;
			long n2=0;
			if(fre[i]%2==0)
			{
				n1=fre[i]/2;
				n2=fre[i]/2;
			}
			else{
				n1=fre[i]/2;
				n2=fre[i]-n1;
			}
			n1=(n1)*(n1-1)/2;
			n2=(n2)*(n2-1)/2;
			count+=n1+n2;
		}
		System.out.println(count);
		
	}
}
