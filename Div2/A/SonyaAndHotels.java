
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
		
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			int a[]=sc.nextIntArray(n);
			long total=0;
			for(int i=0;i<n-1;i++)
			{
				long up=a[i]+k;
				long down=a[i+1]-k;
				long pos=down-up+1;
				if(pos<=0)
				{
					
				}
				else if(pos==1)
				{
					total++;
				}
				else
					{
					total=total+2;
					}
				//System.out.println(pos);
			}
			total+=2;
			System.out.println(total);
		}
	}
}
