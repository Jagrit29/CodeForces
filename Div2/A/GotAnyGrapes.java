
import java.util.*;
import java.math.*;
import java.beans.beancontext.BeanContextServiceAvailableEvent;
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
		int x=sc.nextInt(), y=sc.nextInt(), z=sc.nextInt();
		int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt();
		boolean andrew=true;
		boolean dmi=true;
		boolean mic=true;
		int left=0;
		if(x>a)
		{
			andrew=false;
		}
		else{
			a=a-x;
		}
		if(y>(a+b))
		{
			dmi=false;
		}
		else{
			left=a+b;
			left=a+b-y;
		}
		if(z>left+c)
		{
			mic=false;
		}

		if(andrew && dmi && mic)
		{
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}

		
	}
}
