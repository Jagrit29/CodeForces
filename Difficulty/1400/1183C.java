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
            int k = sc.nextInt();
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            //Now I need to complete exactly n moves and still battery should be greater than 0;
            if((double)(k*1.0)/b<=n)
            {
                //doing b also will not give be n moves;
                System.out.println(-1);
            }
            else
            {
                //Case 1: If I can do all moves by a;
                if(k/a>n)
                {
                    System.out.println(n);
                    continue;
                }
                
                //Case 2: Now I can do some a moves and some b moves;
                //I need to check how many a moves I can do;
                
                //Now I moves I can do with a is either from 0 to n;
                long low = 0;
                long high = n;
                long ans=0;
                //I need to apply bs in between them to see which suits best;
                while(low<=high)
                {
                    long mid = low + (high-low)/2;
                    
                    //Now I need to check If I can perform mid moves;
                    if(can(mid,k,a,b,n))
                    {
                        ans=mid;
                        //I need to check for higher;
                        low = mid +1;
                    }
                    else
                    {
                        high=mid-1;
                    }
                }
                System.out.println(ans);
            }
        }  
    }
    
    public static boolean can(long mid, int k,int a,int b, long n)
    {
        //I need to check if I can perform mid moves with 
        if(k<=(mid*a))
        {
            //this means I will exhaust either all k or its not suficient;
            //means I cannot perform;
            return false;
        }
        else
        {
            //This means I can perform;
            long leftK = k - (mid*a);
            long leftN = n - mid;
            //Now I need to check if I can perform left moves with b;
            //if LeftK is greator than I can perform;
            return leftK > (leftN*b);
        }
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
        int f;
        //int i;
        public Pair(int x, int  y)
        {
            this.x=x;
            this.f=y;
            //this.i=i;
        }
    }
    static class Comp implements Comparator<Pair>
    {
        public int compare(Pair p1, Pair p2)
        {
            return p2.f - p1.f;
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
  Deque<String> deque 
            = new LinkedList<String>();  
            
  List<Integer> c[] = new ArrayList[3];          
*/
