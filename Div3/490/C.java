package Div3_490;
import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
public class C {
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
    } 
	public static void main(String[] args) throws IOException
	{
		 FastReader sc=new FastReader();
		 int n=sc.nextInt();
		 int k=sc.nextInt();
		 String s=sc.nextLine();
	     //BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	     //String ss[]=br.readLine().split(" ");
	     //int n=Integer.parseInt(ss[0]);
	     //nt k=Integer.parseInt(ss[1]);
	     //String s=br.readLine();
	     int chars[]=new int[26];
	     
	     for(int i=0;i<s.length();i++)
	     {
	    	 chars[s.charAt(i)-'a']++;
	     }
	     char ch='a';
	     StringBuffer bf=new StringBuffer(s);
	     int fre[]=new int[26];
	     for(int i=0;i<26;i++)
	     {
	    	 if(k==0)
	    	 {
	    		 break;
	    	 }
	    	 if(chars[ch-'a']>0 && k>0)
	    	 {
	    		 int total=chars[ch-'a'];
	    		 if(total>=k)
	    		 {
	    			 fre[ch-'a']=k;
	    			 k=0;
	    		 }
	    		 else
	    		 {
	    			 k=k-total;
	    			 fre[ch-'a']=total;
	    		 }
	    	 }
	    	 ch++;
	     }
	     StringBuffer ans=new StringBuffer("");
	     for(int i=0;i<s.length();i++)
	     {
	    	 ch =s.charAt(i);
	    	 if(fre[ch-'a']>0)
	    	 {
	    		 fre[ch-'a']--;
	    	 }
	    	 else
	    	 {
	    		 ans.append(ch);
	    	 }
	     }
	     System.out.println(ans.toString());
	}


}
