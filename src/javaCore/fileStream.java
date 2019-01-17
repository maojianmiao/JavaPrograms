package javaCore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import org.testng.annotations.Test;
import static java.lang.System.out;

public class fileStream {
	public static String path =System.getProperty("user.dir");
	static {
		String path = System.getProperty("user.dir");
	}
	
  @Test
  public void f() throws Exception {
	  int bytesAvailable = System.in.available();
	  if (bytesAvailable > 0) {
		  byte[] data = new byte[bytesAvailable];
		  System.in.read(data);
	  }
  }
 
  @Test
  public void system_getproperty() throws Exception {
	  out.println(System.getProperty("user.dir"));
  }
  
  @Test
  public void console_read() throws Exception {
	  InputStreamReader in = new InputStreamReader(System.in);
	  out.println(in.read());
  }
  
  @Test
  public void file_read() throws Exception {
	  FileInputStream f = new FileInputStream(path + "\\res\\testfile");
	  Scanner in = new Scanner(f);
	  while(in.hasNextLine()) {
		  out.println(in.nextLine());
	  }
	  f.close();
  }
  
  @Test
  public void file_write() throws Exception {
	  FileWriter f = new FileWriter(path + "\\res\\testfile");
	  PrintWriter out = new PrintWriter(f,false);
	  out.println("那有怎么样呢");
	  out.println("你很努力吗，你想过怎么改变现在的情况吗");
	  out.print("你家庭也不富裕，自己也不是顶聪明的人");
	  f.close();
  }
  
  @Test
  public void object_serialzable() throws Exception {
	  FileOutputStream f = new FileOutputStream(path + "\\res\\object.txt");
	  ObjectOutputStream out = new ObjectOutputStream(f);
	  Person p = new Person("maojm");
	  Person p1 = new Person("maojm1");
	  out.writeObject(p);
	  out.writeObject(p1);
	  f.close();
  }
  
  @Test
  public void object_serialzable_read() throws Exception {
	  FileInputStream f = new FileInputStream(path + "\\res\\object.txt");
	  ObjectInputStream in = new ObjectInputStream(f);
	  //Person p = (Person)in.readObject();
	  //Person p1 = (Person)in.readObject();
	  //out.println(p.getName() +" " + p1.getName());
	  //out.println(p.getName() +" " + p1.getName());
	  f.close();
  }
}
