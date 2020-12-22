import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static HashSet<Integer> cats = new HashSet<>();
    public static HashSet<Integer> visited = new HashSet<>();
	public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = sc.nextIntArray(n);
        for(int i=0;i<n;i++)
        {
            if(a[i]==1)
            {
                cats.add(i);
            }
        }
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<n-1;i++)
        {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        if(cats.contains(0))
        {
            int c1 = dfs(graph,1,0,m);
            System.out.println(c1);
        }
        else
        {
            int c2 = dfs(graph,0,0,m);
            System.out.println(c2);
        }
        cats.clear();
        visited.clear();
        
        //Now I need to perform dfs;   
    }
    //i is current;
    public static int dfs(List<List<Integer>> graph, int cons, int i, int maxCons)
    {
        if(visited.contains(i)) return 0;
        visited.add(i);
        if(cons > maxCons)
        {
            return 0; //cannot have tthis;
        }
        if(graph.get(i).size()==1 && visited.contains(graph.get(i).get(0)))
        {
            //this means its a leaf;
            return 1; //This is a valid path;
        }
        
        List<Integer> neigh = graph.get(i);
        int count = 0;
        for(int ne : neigh)
        {
            if(cats.contains(i) && cats.contains(ne))
            {
                //consective;
                count = count + dfs(graph,cons+1,ne,maxCons);
            }
            else if(cats.contains(ne))
            {
                //Start again with 1;
                count = count + dfs(graph,1,ne,maxCons);
            }
            else
            {
                //Start again with 0;
                count = count + dfs(graph,0,ne,maxCons);
            }
        }
        return count;
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
