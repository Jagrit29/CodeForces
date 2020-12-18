import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k1  = sc.nextInt();
        int a[] = sc.nextIntArray(k1);
        int k2 = sc.nextInt();
        int b[] = sc.nextIntArray(k2);
        
        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();
        for(int i=0;i<k1;i++) dq1.addLast(a[i]);
        for(int i=0;i<k2;i++) dq2.addLast(b[i]);
        
        //Now we have s1 and s2 in order;
        HashSet<String> hs1 = new HashSet<>();
        HashSet<String> hs2 = new HashSet<>();
        String s1="";
        String s2="";
        for(int i: dq1) s1 = s1+" "+i;
        for(int i: dq2) s2 = s2+" "+i;
        hs1.add(s1);
        hs2.add(s2);
        //I need to save each state;
        boolean win = true;
        int count = 0;
        while(dq1.size()>0 && dq2.size()>0)
        {
            int top1 = dq1.removeFirst();
            int top2 = dq2.removeFirst();
            if(top1 > top2)
            {
                dq1.addLast(top2);
                dq1.addLast(top1);
            }
            else
            {
                dq2.addLast(top1);
                dq2.addLast(top2);
            }
            count++;
            String ss1="";
            String ss2="";
            for(int i: dq1) ss1 = ss1+" "+i;
            for(int i: dq2) ss2 = ss2+" "+i;
            if(hs1.contains(ss1) && hs2.contains(ss2))
            {
                win=false;
                break;
            }
            else
            {
                hs1.add(ss1);
                hs2.add(ss2);
            }
            
        }
        if(win==false)
        {
            System.out.println(-1);
        }
        else
        {
            if(dq1.size()==0)
            {
                System.out.println(count+" "+2);
            }
            else
            {
                System.out.println(count+" "+1);
            }
        }
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
            return p1.x-p2.x;
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
