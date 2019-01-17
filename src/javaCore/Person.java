package javaCore;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class Person implements Serializable{
	
	private String name;
	private boolean sex;
	private int age;
	private double height;
	
	
	private List<Person> persons;
	private Person[] arraypersons;
	private Map mappersons;
	
	public Person(String n){
		this.name = n;
	}
	
	public Person(String name,boolean sex,int age,double height) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean getSex(){
		return sex;
	}
	
	public void setPersons(List<Person> p) {
		this.persons = p;
	}
	
	public List<Person> getPerson(){
		return this.persons;
	}
	
	public void setArraypersons(Person[] p) {
		this.arraypersons = p;
	}
	
	public Person[] getArraypersons() {
		return this.arraypersons;
	}
	
	public void setMappersons(Map map) {
		this.mappersons = map;
	}
	
	public Map getMappersons() {
		return this.mappersons;
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
