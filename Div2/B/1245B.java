import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
public class Main {
	
	public static void main(String[] args) {
		FastReader sc =new FastReader();
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int a[]=sc.nextIntArray(3);
			String sw=sc.nextLine();
			char ch[]=sw.toCharArray();

			int r=0;
			int p=0;
			int s=0;
			for(char c:ch)
			{
				if(c=='R') r++;
				if(c=='P') p++;
				if(c=='S') s++;
			}

			int beatR=Math.min(r,a[1]);
			int beatP=Math.min(p,a[2]);
			int beatS=Math.min(s,a[0]);
			if(beatR+beatP+beatS<(n+1)/2)
			{
				System.out.println("NO");
				continue;
			}

			char ans[]=new char[n];
			Arrays.fill(ans,'$');
			for(int i=0;i<n;i++)
			{
				if(ch[i]=='R')
				{
					if(a[1]>0)
					{
						ans[i]='P';
						a[1]--;
					}
				}
				if(ch[i]=='P')
				{
					if(a[2]>0)
					{
						ans[i]='S';
						a[2]--;
					}
				}
				if(ch[i]=='S')
				{
					if(a[0]>0)
					{
						ans[i]='R';
						a[0]--;
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				if(ans[i]=='$')
				{
					if(a[0]>0)
					{
						ans[i]='R';
						a[0]--;
					}
					else if(a[1]>0)
					{
						ans[i]='P';
						a[1]--;
					}
					else if(a[2]>0)
					{
						ans[i]='S';
						a[2]--;
					}
				}
			}
			System.out.println("YES");
			System.out.println(String.valueOf(ans));

		}
		
			
		
	}



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
