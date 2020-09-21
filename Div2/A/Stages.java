
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
		int k=sc.nextInt();
		char ch[]=sc.next().toCharArray();
		Arrays.sort(ch);
		String form="";
		for(int i=0;i<n;i++)
		{
			if(form.equals(""))
			{
				form+=ch[i];
			}
			else{
				//int diff=ch[i]-form.charAt(form.length()-1);
				//System.out.println(diff);
				if(ch[i]-form.charAt(form.length()-1)<=1)
				{
					continue;
				}
				else{
					form+=ch[i];
				}
			}
			if(form.length()==k) break;
		}
		//System.out.println(form);
		if(form.length()==k)
		{
			int count=0;
			for(int i=0;i<form.length();i++)
			{
				count+=(int)(form.charAt(i)-'a'+1);
			}
			System.out.println(count);
		}
		else{
			System.out.println(-1);
		}

	}
}
