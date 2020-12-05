import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
    
	public static void main(String[] args) {
        FastReader sc =new FastReader();
        int n = sc.nextInt();
        int a[] = sc.nextIntArray(n);
        int first=a[0];
        int ind=0;
        boolean dec=false;
        boolean seg=false;
        int end=0;
        for(int i=1;i<n;i++)
        {
            if(seg==true)
            {
                if(a[i]<a[i-1])
                {
                    seg=false;
                    break;
                }
                continue;
            }
            if(a[i]<a[i-1])
            {
                //its dec;
                dec=true;
                if(i==n-1)
                {
                    //ind=0;
                    end=i;
                    if(ind>=1)
                    {
                        if(a[ind-1]>a[i])
                        {
                            seg=false;
                            break;
                        }
                    }
                    seg=true;
                }
            }
            else
            {
                //Now its inc;
                //if(dec==false) means there has been no dec so far;
                if(dec==false)
                {
                    first=a[i];
                    ind=i;
                }
                else
                {
                    //there has been dec now its inc;
                    //Now its inc;
                    int ele=a[i];
                    if(first<=a[i])
                    {
                        //its fine;
                        seg=true;
                        end=i-1;
                    }
                    else
                    {
                        seg=false;
                        break;
                    }
                    
                }
            }
        }
        if(seg)
        {
            System.out.println("yes");
            System.out.println((ind+1) +" "+(end+1));
        }
        else if(dec==false)
        {
            System.out.println("yes");
            System.out.println(1+" "+1);
        }
        else
        {
           System.out.println("no"); 
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
