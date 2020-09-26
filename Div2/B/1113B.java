
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
		// a1 > a2*x; ..then we can change;
		//I derived this equation from a1+a2 > a1/x + a2*x;
		//Now for each a1, we neeed to check if there is
		//I will try for larger and smallest;
		int n=sc.nextInt();
		int a[]=sc.nextIntArray(n);
		Arrays.sort(a);
		int total=0;
		for(int i:a) total+=i;
		int diff=0;
		for(int i=n-1;i>0;i--)
		{
			int a1=a[i];
			int a2=a[0];
			for(int j=1;j<=a1/2;j++)
			{
				if(a1%j==0 && a1 > a2*j)
				{
					int initial=a1+a2;
					int finall=a1/j + a2*j;
					diff=Math.max(diff,initial-finall);
				}
			}
		}
		System.out.println(total-diff);

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
