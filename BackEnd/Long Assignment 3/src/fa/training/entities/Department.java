package fa.training.entities;

import java.util.List;

public class Department {
private String departmentName;
private List<Employee> listOfEmployees;
public Department(String departmentName, List<Employee> listOfEmployees) {
	super();
	this.departmentName = departmentName;
	this.listOfEmployees = listOfEmployees;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public List<Employee> getListOfEmployees() {
	return listOfEmployees;
}
public void setListOfEmployees(List<Employee> listOfEmployees) {
	this.listOfEmployees = listOfEmployees;
}

@Override
public String toString() {
	return "Department [departmentName=" + departmentName + ", listOfEmployees=" + listOfEmployees + "]";
}
public void display() {
	System.out.println(toString());
}
}
