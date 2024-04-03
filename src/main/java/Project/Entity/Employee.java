package Project.Entity;

import java.sql.Date;

public class Employee {
	private Long Id;
	private String Name;
	private int Age;
	private String Role;
	
	
	
	public Employee(Long id, String name, int age, String role) {
		super();
		Id = id;
		Name = name;
		Age = age;
		Role = role;
	
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	


	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", Role=" + Role +  "]";
	}
	
	
	
}
