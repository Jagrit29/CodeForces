import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
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
            return p1.y-p2.y;
        }
    }
    public static long dp1[][];
	public static void main(String[] args) {
		FastReader sc =new FastReader();
        //Scanner sc =new Scanner();
        int n=sc.nextInt();
        int a[]=sc.nextIntArray(n);
        int b[]=sc.nextIntArray(n);
        long dp[][]=new long[n][6]; //0 if he choose player from 1st row;
        dp1=new long[n][3];
        //1 if he chooses player from 2nd row;
        dp[0][0] = a[0]; //chosen first player from first row;
        dp[0][1] = b[0]; //chosen first player from 2nd row;
        //3 means not choosen prevousply
        dp[0][2] = 0;
        dp[0][3] = Math.max(a[0],b[0]);
        for(int i=1;i<n;i++)
        {
            //choosing from 1st row;
            //I take from first row & add previous when I took from 2nd;
            dp[i][0] = a[i] + dp[i-1][1];
            
            //I take from 2nd row & add prev when I took from 1st
            dp[i][1] = b[i] + dp[i-1][0];
            
            //I don't take from this row & add when I took 1 or 2;
            dp[i][2] = dp[i-1][0]; //Not taken ;this; //I took prev 0;
            
            dp[i][3] = dp[i-1][1]; //I took prev 1;
            
            dp[i][4] = a[i] + dp[i-1][3];
            
            dp[i][5] = b[i] + dp[i-1][2];
            
        }
        //int ans=Math.max(dp[n-1][0],Math.max(dp[n-1][1],Math.max(dp[n-1][2],dp[n-1][3])));
        long max=Long.MIN_VALUE;
        for(int i=0;i<6;i++) max=Math.max(dp[n-1][i],max);
        System.out.println(solve(a,b,0,0));
        //System.out.println(max);
    }
    public static long solve(int a[], int b[], int taken,int i)
    {
        if(i==a.length) return 0;
        long option1=0;
        long option2=0;
        long option3=0;
        if(dp1[i][taken]!=0) return dp1[i][taken];
        if(taken==0)
        {
            //not taken anything, he can skip it;
            option1=solve(a,b,0,i+1);
            option2=a[i]+solve(a,b,1,i+1); //taken 1;
            option3=b[i]+solve(a,b,2,i+1); //taken 2;
        }
        else if(taken==1)
        {
            //Now he can skip;
            option1=solve(a,b,taken,i+1);
            option2=b[i]+solve(a,b,2,i+1); //takes 2;
        }
        else
        {
            option1=solve(a,b,taken,i+1);
            option2=a[i]+solve(a,b,1,i+1); //takens 1;
        }
        return dp1[i][taken]=Math.max(option1,Math.max(option3,option2));
        
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
  for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
*/
