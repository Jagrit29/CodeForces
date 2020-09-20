
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
		String s=sc.next();
		boolean pos=true;
		String arr[]={"11","000"};
		for(int i=0;i<arr.length;i++)
		{
			if(s.indexOf(arr[i])!=-1)
			{
				pos=false;
				break;
			}
		}
		if(n==1 && s.charAt(0)=='0')
			{
				pos=false;
			}
		if(pos)
		{
			//count ones;
			if(n>=2)
			{
				if(s.substring(0,2).indexOf("00")!=-1)
				{
					pos=false;
				}
				if(s.substring(s.length()-2,s.length()).indexOf("00")!=-1)
				{
					pos=false;
				}
			}

		}
		System.out.println(pos ? "Yes" : "No");

        
	}
}
