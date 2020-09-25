
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
		int n = sc.nextInt();
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		List<Integer> list1=new ArrayList<>();
		list1.add(x1);
		List<Integer> list2=new ArrayList<>();
		list2.add(x2);
		while(x1!=y1)
		{
			if(x1==n)
			{
				x1=1;
			}
			else{
				x1++;
			}
			list1.add(x1);
		}
		while(x2!=y2)
		{
			if(x2==1) 
			{
				x2=n;
			}
			else{
				x2--;
			}
			list2.add(x2);
		}
		int i=0;
		int j=0;
		boolean ans=false;
		while(i<list1.size() && j<list2.size())
		{
			if(list1.get(i)==list2.get(j))
			{
				ans=true;
				break;
			}
			else
			{
				i++;
				j++;
			}
		}
		System.out.println(ans ? "YES" : "NO");
		
	}
}
