package javaCore;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
	
	private String name;
	private boolean sex;
	
	public Person(String n){
		this.name = n;
	}
	public String getName(){
		return name;
	}
	
	public boolean getSex(){
		return sex;
	}
}

class Employee extends Person implements Comparable<Employee>{
	private double salary;
	private Date hireDay;
	
	public Employee(String n, double s, int year, int month, int day){
		super(n);
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}
	
	public Employee(String n){
		super(n);
	}
	
	public Employee(String n,double s){
		super(n);
		salary = s;
	}
	public Date getHireDay(){
		return hireDay;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public String getDescription(){
		return String.format("an employee with a salary of  %.2f", salary);
	}
	
	public void raiseSalary(double byPercent){
		salary += salary*(1+byPercent);
	}
	
	public int compareTo(Employee obj){
		return Double.compare(this.salary, obj.salary);
	}
}
