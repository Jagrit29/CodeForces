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
		int n = sc.nextInt();
		int a[]=sc.nextIntArray(n);

		long count=0;
		int ones=0;
		int zeros=0;
		int negs=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]==0)
			{
				zeros++;
			}
			else if(a[i]>0)
			{
				ones++;
				count=count+(a[i]-1);
			}
			else 
			{
				negs++;
				count=count+(Math.abs(a[i])-1);
			}
		}

		if(zeros>0)
		{
			//I need to take care of them;
			//Positive ones dont do trouble
			//I can handle any case by change it to -1 or 1;
			count=count+zeros*1;
		}
		else
		{
			//No there are no zeros, so I will have two make prod pos;
			if(negs%2!=0 && negs!=0)
			{
				//I need to make one of them pos; which means add 2;
				//-1 to 1;
				count=count+2;

			}
		}
		System.out.println(count);





	}
	
}


//Templates for Comparator and Classes - @jagrit_07
/*
Arrays.sort(newEmployees, new Comparator<Employee>() {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }
});
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
