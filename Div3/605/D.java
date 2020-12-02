import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int dp[][];
	public static void main(String[] args) {
        FastReader sc =new FastReader();
        int n = sc.nextInt();
        int a[] = sc.nextIntArray(n);
        dp=new int[n+1][4];
        for(int i[]: dp) Arrays.fill(i,-1);
        System.out.println(solve(a,0,0));
        for(int i[]: dp) Arrays.fill(i,-1);
    }
    public static int solve(int a[],int last, int i)
    {
        if(i==a.length) return 0;
        
        //0 means I havent taken any element;
        if(dp[i][last]!=-1) return dp[i][last];
        if(last==0)
        {
            int option1 = 1 + solve(a,1,i+1);
            int option2 = solve(a,0,i+1); //this step will only work if I havnt taken any element;
            return dp[i][last]=Math.max(option1,option2);
            
        }
        else if(last==1)
        {
            //Here I have three options;
            //I can skip only 1 element;
            //I can skip only 
            //last is 1 when I have taken last element;
            int option1=0;
            if(a[i]>a[i-1])
            {
                option1 = 1 + solve(a,1,i+1);
            }
            //Now I can skip 1 element in between;
            int option2 = solve(a,2,i+1); //I have skipped in between;
            return dp[i][last]=Math.max(option1,option2);
        }
        else if(last==2)
        {
            int option1=0;
            if(a[i]>a[i-2])
            {
                option1 = 1 + solve(a,3,i+1);
                //I have skipped, I cant skip more;
            }
            return dp[i][last]=option1;
        }
        else
        {
            int option1=0;
            if(a[i]>a[i-1])
            {
                option1 = 1+solve(a,3,i+1);
            }
            return dp[i][last]=option1;
        }
        
    }
    public static int bs(int num[], int x)
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
