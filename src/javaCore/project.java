package javaCore;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.lang.*;
import java.util.*;
import java.lang.reflect.*;


public class project{

	/**
	 * @param args
	 */
/**
	public static void main(String[] args) throws FileNotFoundException
	{
		//float a = 34.232323f;
		//Scanner in = new Scanner(System.in);
		//System.out.println("What is your name?: ");
		//String name = in.nextLine();

		String a = "day day up";
		Scanner in = new Scanner(new File("D:\\Projects\\JavaPLUS\\src\\javaCore\\myfile.txt"));
		PrintWriter f = new PrintWriter("D:\\Projects\\JavaPLUS\\src\\javaCore\\myfile.txt");
		f.write(a);
		f.close();
		System.out.println(in.nextLine());
		in.close();

		Employee harry = new Employee("maojm");
		Class cl = harry.getClass();
		System.out.printf("%s - %s",cl,harry.getName());
		try{
			Method e = Employee.class.getMethod("getSalary");
			double name = (double)e.invoke(harry);
			System.out.printf("%s",e.toString());
			System.out.printf("%s",name);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		System.out.printf("%s - %s",cl,harry.getName());
		
	}*/
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}*/

	public static void main(String[] args){
		int[] a =new int[]{1,2};
		Object[] b = new Object[]{1,2};
		int i = 1;
		Object j = i;

	}
	public static StringBuilder addString(StringBuilder meta,String[] a){
		int i;
		for (i = 0;i<a.length;i++)
			meta.append(a);
		return meta;
	}
	
	public static char[] getPwd(){
		Console cons = System.console();
		char[] a = cons.readPassword();
		return a;
		
	}
	
	
	public static <T> void prints(T[] a){
		for (T i:a){
			System.out.print(i+" ");
		}
	}

}
