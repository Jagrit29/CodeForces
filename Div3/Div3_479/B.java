package Div3;

import java.util.HashMap;
import java.util.Scanner;

public class B_479 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		HashMap<String,Integer> hm=new HashMap<>();
		String s=sc.next();
		int max=0;
		String ans="";
		for(int i=0;i<s.length()-1;i++)
		{
			hm.put(s.substring(i,i+2),hm.getOrDefault(s.substring(i,i+2),0)+1);
			if(hm.get(s.substring(i,i+2))>max)
			{
				ans=s.substring(i,i+2);
				max=hm.get(s.substring(i,i+2));
			}
		}
		System.out.println(ans);

	}

}
