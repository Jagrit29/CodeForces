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
	public static void main(String[] args) {
        FastReader sc =new FastReader();
        int m = sc.nextInt();
        int s = sc.nextInt();
        
        int max = m*9;
        int min = 1;
        if(s==0 && m==1)
        {
            System.out.println(0+" "+0);
            return;
        }
        
        //This sum is not possible;
        if(s<min)
        {
            System.out.print(-1+" "+(-1));
        }
        else if(s>max)
        {
            System.out.print(-1+" "+(-1));
        }
        else
        {
            //for maximum;
            //put all 9;s i in front;
            List<Integer> maxNum=new ArrayList<>();
            int sum = s;
            int nines=sum/9;
            for(int i=0;i<nines;i++)
                {
                    maxNum.add(9);
                }
            if(sum%9!=0)
                {
                    maxNum.add(sum%9);
                }
            for(int i=maxNum.size();i<m;i++)
            {
                maxNum.add(0);
            }
            StringBuffer maxAns=new StringBuffer("");
            for(int i: maxNum) maxAns.append(i+"");
            
            
            
            //for minimum;
            List<Integer> minNum=new ArrayList<>();
            sum = s;
            nines= sum/9;
            if(sum%9!=0)
            {
                minNum.add(sum%9);
            }
            for(int i=0;i<nines;i++)
            {
                minNum.add(9);
            }
            
            int left = m-minNum.size();
            //these many zeros I need to insert;
            int first = minNum.get(0); //this is the first number;
            //I need to sub 1 from it;
            StringBuffer minAns=new StringBuffer("");
            if(left>0)
            {
                first--;
                minAns.append(1+"");
                for(int i=0;i<left-1;i++)
                {
                    minAns.append(0+"");
                }
                minAns.append(first);
                for(int i=1;i<minNum.size();i++) minAns.append(minNum.get(i)+"");
                //for(int i: )
            }
            else
            {
                for(int i: minNum) minAns.append(i+"");
            }
            
            
            
            System.out.print(minAns.toString()+" ");
            System.out.println(maxAns.toString());
        }
            
           
        
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
