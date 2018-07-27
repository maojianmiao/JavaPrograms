package dataStructure;

import java.awt.image.renderable.RenderableImage;
import java.awt.print.Printable;

import javax.lang.model.element.VariableElement;
import javax.print.attribute.standard.RequestingUserName;
import javax.sql.rowset.CachedRowSet;

public class Hw {
	/*public void main(String[] args) {
		// TODO Auto-generated method stub
		SLLNode head = new SLLNode("DOG",
					   new SLLNode("CAT",
					   new SLLNode("RAT",
					   new SLLNode("Pig",null))));
		for (SLLNode curr = head; curr != null;curr = curr.next)
			System.out.println(curr.data);
		char[] cs = {'a','b','c'};
		Stack st = new Stack();
		st.push("maogai");
		st.push("hahah");
		double s = pow(2,37);
		System.out.println((int)s);
		
		System.out.println("Helo World");

	}*/
	//n的阶乘
	public static int jiecheng(int n){
		if (n == 0)
			return 1;
		else
			return n * jiecheng(n-1);
	}
	//求最大数
	static int largest(int[] array,int n){
		if (n==1) return 0;
		int large = largest(array, n-1);
		return (array[large] > array[n-1])?
				large:n-1;
	}
	//进制转换
	static String render(int i, int r){
		String s = "";
		if (i < 0 ){
			s += '-';
			s += render(-i, r);
		}
		
		else if (i<r){
			char d = (char)('0' + i);
			s += d;
		}
		else {
			char d = (char) ('0' + i%r);
			s += render(i/r, r);
			s +=d;
		}
		return s;
				
	}
	//汉诺塔问题
	
	static void move(int n, int source, int dest){
		if (n == 0) 
			return ;
		else{
		int spare = 6 - source - dest;
		move(n-1, source, dest);
		System.out.println("Move Disk from " + source + " to " + dest);
		move(n-1, spare, dest);
		}
	}
	//求和
	static int sum(int n){
		if (n == 1)
			return 1;
		else
			return n + sum(n-1);
	}
	//fib resuce
	static long fib(int n){
		long num;
		if (n == 1||n==2){
			return 1;
		}
		else{
			num = fib(n-1) + fib(n-2);
			return num;
		}
	}
	//循环斐波那契数列
	static int fibnormal(int n){
		int i =1;
		int temp1 = 1;
		int temp2;
		int fibsum=1;
		if (i ==1)
			return 1;
		else if (i == 2)
			return 1;
		else{	
			
		for (i=3; i<=n; i++){
			temp2 = fibsum;
			fibsum += temp1;
			temp1 = temp2;
			System.out.print(fibsum+" ");
		}
		return fibsum;
		}
	}
	//最大公约数循环求法
	static int gcd(int q, int p){
		if (q*p ==0 )
			return 0;
		
		int max = q>=p?q:p;
		int min = q>=p?p:q;
		
		int i;
		for (i=min;i>0;i--){
			if (min%i ==0 && max%i ==0)
				break;
		}
		return i;
	}
	
	static void pringa(int[] a){
		for (int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
	}
	
	static void pringa(Object[] a){
		for (int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
	}
	
	static double pow(double di,int zhi){
		double sum=di;
		if (zhi == 0 )
			return 1;
		for (int i =1;i<=zhi;i++){
			sum *=di;
		}
		return sum;
	}
}
