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
            int a[]=sc.nextIntArray(n);
            int color[]=new int[n];
            int primes[]={2,3,5,7,11,13,17,19,23,29,31};
            
            //Like all the numbers which are div by certain prime will have same color;
            int m=1;
            for(int p : primes)
            {
                boolean canBe=false;
                for(int i=0;i<n;i++)
                {
                    if(color[i]==0 && a[i]%p==0)
                    {
                        //means its not colored and can be colored;
                        canBe=true;
                        color[i]=m;
                        //Color will be only same for numbers with equal prime factor;
                        //color this with m;
                    }
                }
                if(canBe) m++;
            }
            System.out.println(m-1);
            for(int i: color)
            {
                System.out.print(i+" ");
            }
            System.out.println();
            
        }
        
    }
    static int gcd(int a,int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
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
