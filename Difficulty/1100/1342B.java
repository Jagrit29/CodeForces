import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
   
	public static void main(String[] args) {
        FastReader sc = new FastReader();
        int q=sc.nextInt();
        while(q-- > 0)
        {
            String t=sc.next();
            int zero=0;
            int one=0;
            for(int i=0;i<t.length();i++)
            {
                if(t.charAt(i)=='0') zero++;
                if(t.charAt(i)=='1') one++;
            }
            if(zero==0 || one==0)
            {
                //the period is zero and its subseqy so its fine;
                System.out.println(t);
            }
            else
            {
                //take 1 and take 2; repeat it 
                String s="";
                for(int i=0;i<t.length();i++)
                {
                    if(s.length()==0)
                    {
                        s=s+t.charAt(i);
                    }
                    else if(s.charAt(0)!=t.charAt(i))
                    {
                        s=s+t.charAt(i);
                        break;
                    }
                }
                //Now I have two char;
                StringBuffer bf = new StringBuffer("");
                bf.append(s);
                while(bf.length()<2*t.length())
                {
                    bf.append(s);
                }
                System.out.println(bf.toString());
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
            return p1.y-p2.y;
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
  for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
*/
