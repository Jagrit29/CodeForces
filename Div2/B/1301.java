import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		FastReader sc =new FastReader();
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int a[]=sc.nextIntArray(n);
            boolean take[]=new boolean[n];
            Arrays.fill(take,false);
            for(int i=0;i<n;i++)
            {
                if(a[i]==-1)
                {
                    //all its neighbours as true;
                    if(i>0) take[i-1]=true;
                    if(i<n-1) take[i+1]=true;
                }
            }
           // System.out.println(Arrays.toString(take));
            //long total=0;
            //int count=0;
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                if(take[i]==true && a[i]!=-1)
                {
                    min=Math.min(a[i],min);
                    max=Math.max(a[i],max);
                }
            }
            int k=0;
            if(min==Integer.MAX_VALUE && max==Integer.MIN_VALUE)
            {
                k=0;
            }
            else
            {
                k=(max+min)/2;
            }
            
            
            for(int i=0;i<n;i++)
            {
                if(a[i]==-1) a[i]=k;
                //if(a[i]==-1) c[i]=k2;
            }
            int maxDiff=Integer.MIN_VALUE;
            //int maxDiff2=Integer.MIN_VALUE;
            for(int i=1;i<n;i++)
            {
                maxDiff=Math.max(maxDiff,Math.abs(a[i]-a[i-1]));
            }
            
            System.out.println(maxDiff+" "+k);
        }
            
        
            
        }
    static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    static void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
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
