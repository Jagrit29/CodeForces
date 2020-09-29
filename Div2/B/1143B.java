
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
				} catch (final IOException e) {
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
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] nextIntArray(final int n) {
			final int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}

	}

	private static long startTime = System.currentTimeMillis();

	public static void main(final String[] args) {
		FastReader sc =new FastReader();
		String s=sc.next();
		char digits[]=s.toCharArray();
		int len=digits.length;
		int prod=1;
		int max=1;
		for(char ch:digits)
		{
			max=max*(ch-'0');
		}
		for(int i=0;i<len;i++)
		{
			if(digits[i]=='0') continue;
			char aa[]=new char[len];
			for(int j=0;j<i;j++)
			{
				aa[j]=digits[j];
			}
			aa[i]=(char)(digits[i]-1);
			for(int j=i+1;j<len;j++)
			{
				aa[j]='9';
			}
			prod=1;
			boolean start=true;
			for(char ch:aa)
			{
				if(ch=='0' && start)
				{
					start=false;
					continue;
				}
				prod=prod*(ch-'0');
			}

			max=Math.max(prod,max);
		}
		System.out.println(max);
	}
}

//Templates for Comparator and Classes - @jagrit_07
/*
class Pair
	{
		
		long i; //index;
		long l; //left;
		long c; //cost;
		public Pair(long x,long y,long z)
		{
			this.i=x;
			this.l=y;
			this.c=z;
		}
		public String toString()
		{
			return this.i+" "+this.l+" "+this.c;
		}
	}
class Comp implements Comparator<Pair>
	{
		public int compare(Pair p1, Pair p2)
		{
			if(p1.c!=p2.c)
			{
				return (int)(p1.c-p2.c); //sort acc to cost;
			}
			else{
				return (int)(p1.i-p2.i); //sort acc to index;
			}
			
		}
	}
*/

/*
  HashMap - Put template - d.put(a1,d.getOrDefault(a1,0)+1);
*/
