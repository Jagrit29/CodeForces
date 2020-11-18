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
	public static void main(String[] args) {
		FastReader sc =new FastReader();
        //Scanner sc =new Scanner();
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[][]=new int[n][m];
            for(int i=0;i<n;i++)
            {
                String s=sc.next();
                for(int j=0;j<m;j++)
                {
                    a[i][j]=s.charAt(j)-'0';
                }
            }
            //System.out.println("hello");
            List<Integer> list=new ArrayList<>();
            int count=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    //I need to take each cell if its one, change it 3 times and eventully it will be 1 and others will not change;
                    if(a[i][j]==1)
                    {
                        //so now I will change it three times;
                        //Here can be cases;
                        //I need to take care of boundaries;
                        if(i==n-1 && j==m-1)
                        {
                            count=count+3;
                            change(a,i,j,i-1,j,i-1,j-1,list);
                            change(a,i,j,i-1,j,i,j-1,list);
                            change(a,i,j,i,j-1,i-1,j-1,list);
                            
                        }
                        else if(j==m-1)
                        {
                            count=count+3;
                            //its last cell from left;
                            change(a,i,j,i,j-1,i+1,j,list); 
                            change(a,i,j,i,j-1,i+1,j-1,list);
                            change(a,i,j,i+1,j-1,i+1,j,list);
                        }
                        else if(i==n-1)
                        {
                            count=count+3;
                            //last row;
                            change(a,i,j,i,j+1,i-1,j,list);
                            change(a,i,j,i-1,j,i-1,j+1,list);
                            change(a,i,j,i,j+1,i-1,j+1,list);
                        }
                        else
                        {
                            count=count+3;
                            change(a,i,j,i,j+1,i+1,j+1,list);
                            change(a,i,j,i+1,j,i,j+1,list);
                            change(a,i,j,i+1,j,i+1,j+1,list);
                        }
                        
                    }
                }
            }
            System.out.println(count);
            for(int i: list)
            {
                System.out.print((i+1)+" ");
            }
            System.out.println();
            
        }   
    }
    static void change(int grid[][], int a, int b, int c, int d, int e, int f,List<Integer> list)
    {
        list.add(a);list.add(b);list.add(c);list.add(d);list.add(e);list.add(f);
        grid[a][b]=1-grid[a][b];
        grid[c][d]=1-grid[c][d];
        grid[e][f]=1-grid[e][f];
        
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
