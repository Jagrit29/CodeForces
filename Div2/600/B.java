import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		FastReader sc =new FastReader();
        int n=sc.nextInt();
        int a[]=sc.nextIntArray(n);
        
        HashSet<Integer> hs=new HashSet<>(); //current members in day;
        int sum=0; //if it becomes neg, it is not possible as if there is pos member means member entered then only there will be neg; it it becomes zero means day can end there;
        int days=0;
        HashSet<Integer> enter=new HashSet<>();
        HashSet<Integer> enterOnce=new HashSet<>();
        List<Integer> list=new ArrayList<>(); //list of events;
        boolean possible=true;
        int last=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]<0)
            {
                //means someone left;
                if(enter.contains(Math.abs(a[i]))==false)
                {
                    //aya tha ni nikl kaise gea;
                    possible=false;
                    break;
                }
                else
                {
                    //chla geya, isko enter se hta dete hai;
                    enter.remove(Math.abs(a[i]));
                    //left;
                }
            }
            else
            {
                //koi ayea hai;
                //someone entered; //if it is already there;
                //ya phir aa ke ja chuka hai;
                if(enter.contains(a[i]) || enterOnce.contains(a[i]))
                {
                    //already ayea huya hai;
                    possible=false;
                    break;
                }
                else
                {
                    //naya ayea hai; enter me daldo;
                    enter.add(a[i]);
                    enterOnce.add(a[i]); //ek baar ageay;
                }
            }
            //so there is no case of discrepency now;
            sum=sum+a[i];
            //if(sum<0) possible=false;
            if(sum==0)
            {
                //end of day;
                days++;
                list.add(i-last+1);
                last=i+1;
                //sara khali;
                enterOnce.clear();
            }
        }
        //System.out.println(sum);
        if(sum!=0) possible=false;
        if(possible==false)
        {
            System.out.println(-1);
            return;
        }
        System.out.println(days);
        for(int i: list)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        //5 -2 -3
        
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
