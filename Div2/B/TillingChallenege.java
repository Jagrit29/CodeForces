
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
		int n=sc.nextInt();
		char ch[][]=new char[n][n];
		for(int i=0;i<n;i++)
		{
			String s=sc.next();
			char c[]=s.toCharArray();
			for(int j=0;j<n;j++)
			{
				ch[i][j]=c[j];
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				char start=ch[i][j];
				//boolean possible=true;
				if(start=='.')
				{
					boolean left=check(ch,i+1,j-1,n);
					boolean right=check(ch,i+1,j+1,n);
					boolean down=check(ch,i+1,j,n);
					boolean dw=check(ch,i+2,j,n);
					if(left && right && down && dw)
					{
						ch[i][j]='#';
						ch[i+1][j-1]='#';
						ch[i+1][j]='#';
						ch[i+1][j+1]='#';
						ch[i+2][j]='#';
					}

				}
			}
		}
		boolean possible=true;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(ch[i][j]=='.') 
				{
					possible=false;
					break;
				}
			}
		}
		System.out.println(possible  ? "YES" : "NO");	
	}

	public static boolean check(char ch[][],int i,int j,int n)
	{
		if(i<0 || i>=n || j<0 || j>=n) return false;
		if(ch[i][j]=='.') return true;
		return false;
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
