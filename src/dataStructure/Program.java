package dataStructure;

/**
 * 
 */
import java.util.*;

/**
 * @author jm
 *
 */
public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		System.out.println(steps(50));
	}
	public static void move(int n, int source, int dest){
		if(n == 0) return;
		int spare = 6 - source - dest;
		move(n-1,source,spare);
		System.out.println("from: " + source + " to: " + dest);
		move(n-1,spare,dest);
	}
	
	public static void merge(int[] a,int l1,int r1,int[] b, int l2, int r2, int[] c,int l3){
		int i=l1,j=l2,k = l3;
		while(i<=r1 && j<=r2)
			if (a[i]<=b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		while (i<=r1)
			c[k++] = a[i++];
		while (j<=r2)
			c[k++] = b[j++];
			
	}
	
	public static void printa(int[] a){
		int i = 0;
		for (i=0;i<=a.length-1;i++)
			System.out.print(a[i]+" ");
	}
	
	public static void printa(String[] a){
		int i = 0;
		for (i=0;i<=a.length-1;i++)
			System.out.print(a[i]+" ");
	}
	
	public static long steps(int N){
		if (N == 1)
			return 1;
		if (N == 2)
			return 2;
		return steps(N - 1) + steps(N - 2);
		
	}

	
} //ÀàÀ¨ºÅ