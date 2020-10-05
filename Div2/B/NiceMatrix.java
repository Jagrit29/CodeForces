
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
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			int a[][]=new int[n][m];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					a[i][j]=sc.nextInt();
				}
			}
			//Taking all 4 elements and making them same;
			long ans=0;
			int i=0;
			int j=0;
			n--;
			m--;
			while(j<=(m-j))
			{
				i=0;
				while(i<=n-i)
				{
					long a1=a[i][j];
					long a2=a[n-i][j];
					long a3=a[i][m-j];
					long a4=a[n-i][m-j];
					long temp_ans=find(a1,a2,a3,a4);
					if(i==n-i)
					{
						temp_ans=Math.abs(a1-a4);
					}
					if(j==m-j)
					{
						temp_ans=Math.abs(a1-a2);
					}
					if(i==n-i && j==m-j)
					{
						temp_ans=0;
					}
					ans+=temp_ans;
					i++;
					//System.out.println(a1+" "+a2+" "+a3+" "+a4);
				}
				j++;
			}
			System.out.println(ans);
		}
	}
	public static long find(long a,long b, long c,long d)
	{
		long a1=Math.abs(a-b)+Math.abs(a-c)+Math.abs(a-d);
		long a2=Math.abs(b-a)+Math.abs(b-c)+Math.abs(b-d);
		long a3=Math.abs(c-a)+Math.abs(c-b)+Math.abs(c-d);
		long a4=Math.abs(d-a)+Math.abs(d-b)+Math.abs(d-c);
		return Math.min(a1,Math.min(a2,Math.min(a3,a4)));
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
