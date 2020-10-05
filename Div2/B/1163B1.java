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
		int N=(int)Math.pow(10,5)+10;
		int fre[]=new int[N]; //denotes frequency of each color;
		//fre[i] means how many times color i appears;

		//how many colors have fre i;
		int color[]=new int[N]; //for color[i] means color[i] colors have fre i;
		int max=0;
		int ans=1;
		for(int i=1;i<=n;i++)
		{
			int a=sc.nextInt();
			//Now a is a color and its fre will change, so if prev 
			int prevFre=fre[a];
			color[prevFre]--; //now this color is not havin color[prevFre] fre;
			fre[a]++; //fre of color inc;
			int newFre=fre[a];
			color[newFre]++;

			//Now Max fre any color has;
			max=Math.max(max,newFre);

			boolean check=false;
			if(color[1]==i)
			{
				//colors having fre 1 are i, means all colors have fre 1;
				check=true;
			}
			else if(color[i]==1)
			{
				//means colors having fre i=1, means there is only 1 color;
				check=true;
			}
			else if(color[1]==1 && color[max]*max==i-1)
			{
				//Now colors[max] are number of colors with max fre, and if max*this is i-1 means we can ignore 1 color;
				check=true;
			}
			else if(color[max-1]*(max-1)==i-max && color[max]==1)
			{
				//only 1 color has max fre and it just 1 greator;
				check=true;
			}
			if(check)
			{
				ans=i;
			}
		}
		System.out.println(ans);

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
