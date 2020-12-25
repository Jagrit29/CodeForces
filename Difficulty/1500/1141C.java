// @jagrit_07
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
    //public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int q[] = sc.nextIntArray(n-1);
        //So each p[] x, x+q1, x + q1+q2;
        long p[] = new long[n]; //this is p array; //this is p' array;
        p[0] = 0; //we have not added x;
        long pref[] = new long[n-1];
        pref[0]=q[0];
        for(int i=1;i<n-1;i++) pref[i]+=pref[i-1]+q[i];
        
        //Now I need to add this pref to each p;
        long min = 0;
        for(int i=0;i<n-1;i++)
        {
            p[i+1] = pref[i];  
            min = Math.min(min,p[i+1]);
        }
        
        //Now I have p which is 0, q1 , q1+q2;
        //There is is missing value which I need to add to all values,
        //but the end minimum result should be 1;
        //So when I will add x to minim of p,
        // x + min = 1; //then only it will be permutation;
        long x = 1 - min;
        
        //I will add this x to each p;
        for(int i=0;i<n;i++)
        {
            p[i]=p[i]+x;
        }
        
        long check[] = p.clone();
        Arrays.sort(check);
        
        boolean yes = true;
        for(int i=0;i<n;i++)
        {
            if(check[i]!=(i+1))
            {
                yes=false;
                break;
            }
        }
        if(yes)
        {
            StringBuffer bf = new StringBuffer("");
            for(long i: p) bf.append(i+" ");
            System.out.println(bf.toString());
        }
        else
        {
            System.out.println(-1);
        }
        
    }
   
    /* to find (x^y)%p in O(log y) */
    static long power(long x, long y, int p) 
    { 
        // Initialize result 
        long ans = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
  
       if (x == 0) return 0; // In case x is divisible by p;    
  
        while (y > 0) 
        { 
            if((y & 1)==1) 
            {
                 ans = ((long)(ans * x))% p;    
            }
            y = y >> 1;  //y/2; 
            x = ((long)(x * x) )% p;  
        } 
        return ans; 
    } 
    
    
    
    
    
    public static void printList(List<Integer> list)
    {
        StringBuffer bf = new StringBuffer("");
        for(int i: list) bf.append(i+" ");
        System.out.println(bf.toString());
    }
    
    
    
    
    
    public static int sum(int a[])
    {
        int sum=0;
        for(int i: a) sum=sum+i;
        return sum;
    }
    
  
    public static int getMax(int a[])
    {
        int m=Integer.MIN_VALUE;
        for(int i: a) m=Math.max(i,m);
        return m;
    }
    
    static class Pair
    {
        int x;
        int y;

        //int i;
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
            if(p1.y!=p2.y)
            {
                return p2.y - p1.y;
            }
            return p2.x - p1.x;
        }
    }
    public static int bs(long num[], long x)
    {
        int low=0;
        int high=num.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(num[mid]==x)
            {
                ans = mid;
                high=mid-1;
            }
            else if(num[mid]<x)
            {
               // ans=mid;
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
    
    
    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    public static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
    
    
    
    
    
    
    static long gcd(long a,long b)
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
System.out.println( 
      String.format("%.5f", b)); 
  HashMap - Put template - d.put(a1,d.getOrDefault(a1,0)+1);
  for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  Deque<String> deque 
            = new LinkedList<String>();  
            
  List<Integer> c[] = new ArrayList[3];          
*/
