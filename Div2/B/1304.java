import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		FastReader sc =new FastReader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        String a[]=new String[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.next();
        }
        Deque<String> dq=new LinkedList<>();
        HashSet<String> hs=new HashSet<>();
        HashSet<String> palins=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            String s=a[i];
            String rev=reverse(s);
            if(palindrome(s))
            {
                //if its palindrome, then I can directly take it;
                if(palins.contains(s))
                {
                    //Noe there are two same palins so take both;
                    //means its there;
                    dq.push(s); //at first;
                    dq.offer(s); //at last;
                    palins.remove(s); //its taken;
                }
                else
                {
                    palins.add(s); 
                    //Now this will contain only palin;
                    //At the end we can find palin of maximum length and put in it mid;
                }
            }
            else
            {
                //if its not palin, its rev shoudl be three;
                if(hs.contains(rev))
                {
                    dq.push(s);
                    dq.offer(rev);
                    hs.remove(s);
                }
                else
                {
                    hs.add(s);
                }
            }
        }
        String max="";
        int maxLen=0;
        for(String s: palins)
        {
            if(s.length()>maxLen)
            {
                maxLen=s.length();
                max=s;
            }
        }
        int k=0;
        StringBuffer bf=new StringBuffer("");
        //if dq is empty;
        //If there is no rev and only palin is there
        if(k==dq.size()/2)
        {
            bf.append(max);
        }
        for(String s: dq)
        {
            bf.append(s);
            k++;
            if(k==dq.size()/2)
            {
                bf.append(max);
            }
        }
        System.out.println(bf.length());
        System.out.println(bf.toString());
    }
    static boolean palindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static String reverse(String s)
    {
        StringBuffer bf=new StringBuffer("");
        for(int i=s.length()-1;i>=0;i--)
        {
            bf.append(s.charAt(i));
        }
        return bf.toString();
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
*/
