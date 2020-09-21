
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
		String s[]=new String[n];
		for(int i=0;i<n;i++)
		{
			s[i]=sc.next();
		}
		HashSet<String> roots=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			String ss=s[i];
			int fre[]=new int[26];
			for(char ch:ss.toCharArray())
			{
				fre[ch-'a']++;
			}
			String neN="";
			for(int j=0;j<26;j++)
			{
				if(fre[j]>0)
				{
					neN+=(char)('a'+j);
				}
			}
			roots.add(neN);
		}
		
		System.out.println(roots.size());
	}
}
