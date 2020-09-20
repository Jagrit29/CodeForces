
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
public class Main {
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
				} catch (IOException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
 
		int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}
 
	}
	
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		FastReader sc =new FastReader();
        int n=sc.nextInt();
        int a[]=sc.nextIntArray(n);
        if(n==1 || (n==2 && a[0]==a[1]))
        {
            System.out.println(-1);
            return;
        }
        //give minimum one to andrews;
        int min=Integer.MAX_VALUE;
        int minInd=-1;
        for(int i=0;i<n;i++)
        {
            if(a[i]<min)
            {
                minInd=i;
                min=a[i];
            }
        }
        System.out.println(n-1);
        for(int i=0;i<n;i++)
        {
            if(minInd==i) continue;
            System.out.print((i+1)+" ");
        }
        System.out.println();
		
	}
}
