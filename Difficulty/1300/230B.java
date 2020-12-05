import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
    
	public static void main(String[] args) {
        FastReader sc =new FastReader();
        int n = (int)Math.pow(10,6);
        //I need to check from these whether they are the prime or not;
        int prime[]=new int[n+1];
        prime[1]=0;
        prime[2]=1;
        for(int i=3;i<=n;i=i+2)
        {
            prime[i]=1; //all odds are assumed prime in the beginnging;
        }
        
        for(int i=3;i<=n;i++)
        {
            if(prime[i]==1)
            {
                //this number is prime;
                //So all its multiiple are non prime;
                if((long)(i*i)>n) break; //i*i goes out of bound;
                for(long j=(long)(i*i);j<=n;j=j+i)
                {
                    int p=(int)j;
                    prime[p]=0;
                }
            }
        }
        int t=sc.nextInt();
        while(t-- > 0)
        {
            long num = sc.nextLong();
            int sq = (int)Math.sqrt(num);
            long sqq = (long)sq;
            if((sqq*sqq)!=num) 
            {
                System.out.println("NO");
            }
            else
            {
                System.out.println(prime[sq]==1 ? "YES" : "NO");
            }
        }
        
       
        
    }
    
    
    
    
    
    
    
    
    
    
    static class Pair
    {
        int x;
        int y;
        public Pair(int x, int  y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static class Comp implements Comparator<Pair>
    {
        public int compare(Pair p1, Pair p2)
        {
            if(p1.x!=p2.x && p1.y!=p2.y)
            {
                return p1.x-p2.x;
            }
            else
            {
                return 0;
            }
        }
    }
    public static int binarySearch(int num[], int x)
    {
        int low=0;
        int high=num.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(num[mid]==x)
            {
                return mid;
            }
            else if(num[mid]<x)
            {
                low=mid+1;
            }
            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
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
//private ArrayList<String[]> action = new ArrayList<String[]>();


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
  for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
*/
