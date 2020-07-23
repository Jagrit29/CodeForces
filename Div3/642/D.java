package Div3_642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D {
	static class Pair
	{
		int len;
		int l;
		int r;
		public Pair(int l,int r,int len)
		{
			this.l=l;
			this.r=r;
			this.len=len;
		}
	}
	static class Comp implements Comparator<Pair>
	{
		public int compare(Pair p1, Pair p2)
		{
			if(p2.len!=p1.len)
			{
				return p2.len-p1.len;
			}
			else
			{
				return p1.l-p2.l;
			}
		}
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
        int[] nextIntArray(int n)
        {
        	int a[]=new int[n];
        	for(int i=0;i<n;i++)
        	{
        		a[i]=Integer.parseInt(next()); 
        	}
        	return a;
        }
        
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc=new FastReader();
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int a[]=new int[n];
			Arrays.fill(a, 0);
			PriorityQueue<Pair> pq=new PriorityQueue<>(new Comp());
			pq.add(new Pair(1,n,n-1));
			int i=1;
			while(pq.size()>0)
			{
				Pair p=pq.poll();
				int r=p.r;
				int l=p.l;
				
				int m=(r-l+1);
				
				if(m%2==0)
				{
					int put=(r+l-1)/2;
					//put--;
					a[put-1]=i;
					i++;
					
					//Now l to put and put to r;
					if(put>l)
					{
						//System.out.println("hello");
						int len=put-l;
						int newL=l;
						int newR=put-1;
						pq.add(new Pair(newL,newR,len));
					}
					if(r>put)
					{
						//System.out.println("hello");
						int len=r-put;
						int newL=put+1;
						int newR=r;
						
						pq.add(new Pair(newL,newR,len));
					}
				}
				else
				{
					int put=(r+l)/2;
					//put--;
					a[put-1]=i;
					i++;
					if(r>put)
					{
						//System.out.println("hello");
						int len=r-put;
						int newL=put+1;
						int newR=r;
						
						pq.add(new Pair(newL,newR,len));
					}
					if(put>l)
					{
						//System.out.println("hello");
						int len=put-l;
						int newL=l;
						int newR=put-1;
						pq.add(new Pair(newL,newR,len));
					}
				}
			}
			StringBuffer bf =new StringBuffer("");
			for(i=0;i<n;i++)
			{
				bf.append(a[i]+" ");
			}
			System.out.println(bf.toString());
		}
		
	}

}
