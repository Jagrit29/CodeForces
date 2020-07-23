package Div3_642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {
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
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			int a[]=sc.nextIntArray(n);
			int b[]=sc.nextIntArray(n);
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			int i=0;
			int j=n-1;
			while(k>0 && i<n && j>=0)
			{
				if(b[j]>a[i])
				{
					a[i]=b[j];
					i++;
					j--;
					k--;
				}
				else
				{
					break;
				}
			}
			long sum=0;
			//System.out.println(Arrays.toString(a));
			for(i=0;i<n;i++)
			{
				sum=sum+a[i];
			}
			System.out.println(sum);
			
		}

	}

}
