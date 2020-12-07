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
            if(p1.x!=p2.x)
            {
                return p1.x-p2.x;
            }
            else
            {
                return p1.y-p2.y;
            }
        }
    }
	public static void main(String[] args) {
        FastReader sc =new FastReader();
        int n = sc.nextInt();
        int a[] = sc.nextIntArray(n);
        int b[] = sc.nextIntArray(n);
        int shifts[] =  new int[n+1]; //number of shifts;
        int index[] = new int[n+1];
        for(int i=0;i<n;i++)
        {
            index[b[i]]=i;
        }
        
        for(int i=0;i<n;i++)
        {
            // I need index of a[i] in b
            int inA = i;
            int inB = index[a[i]]; //now we have both indexs;
            
            //Rember I am doing right shift on a, picking elements on from left putting to right;
            if(inA > inB)
            {
                int doShift = inA-inB;
                //I need to do this shifts to make inA = inB;
                shifts[doShift]++;
            }
            else
            {
                //Now inA is less than inB;
                //means on B it is on righter side;
                //first I need to make A to the end;
                int firstShifts =  inA; //these many shifts; this will take it to the fron;
                //Now a[i] is at front;
                //Now I need to shfit it n - inB times, coz then it will take it to inB;
                int secondShifts = n -  inB;
                
                int doShifts = firstShifts + secondShifts;
                
                shifts[doShifts]++;
            }
        }
        
        //Now I need to check howmany same shifts have come, coz then we will perform that many shifts and num of times that we perform will be the index;
        int max=0;
        for(int i=0;i<=n;i++)
        {
            max=Math.max(shifts[i],max);
        }
        System.out.println(max);
        
        
        
    }
    public static int solve(int n)
    {
        if(n==1) return 0;
        if(n<=2) return 1; //person wins;
        if(n%2!=0) return 1; //if its odd, directly the opp wins by dividing it by itself; 
        //if((n/2)%2!=0) return 1;
        //Now the number is even;
        //Diviing it by any off its odd factor will even number only, 
        //because even/odd = even   as odd*(evenTimes) only can give even numb;
        if((n&(n-1))==0)
        {
            return 0; //2^x form;
        }
        else
        {
            //means the there is odd factor;,if its prime,
            if((n/2)%2!=0)
            {
                if(prime(n/2))
                {
                    return 0;
                }
            }
            return 1;
        }
        
        
    }
    public static boolean prime(int n)
    {
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    public static void swap(char ch[][], int i, int j, int l, int m)
    {
        char temp = ch[i][j];
        ch[i][j]=ch[l][m];
        ch[l][m]=temp;
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
