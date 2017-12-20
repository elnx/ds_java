package nosql;
import java.util.*;
public class Nosql {
	public static void main(String[] rgs){
		Scanner in = new Scanner(System.in);
		/*
		while(in.hasNextInt()){
			n=in.nextInt();
			int[] sum=new int[n];
			for(int i=0;i<n;i++){
				a = in.nextInt();
				b = in.nextInt();
				sum[i]=a+b;
			}
			for (int s : sum) {
				System.out.println(s);
			}
		}
		*/
		while(in.hasNextInt()) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a+b);
		}
	}
	
}