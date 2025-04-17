package com.javatechie.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	private int id;
	private String name;
	private int age;
	private String department;
	private double salary;

	public Employee(int id, String name, int age, String department, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}

	// Getters and toString() method
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", department='" + department
				+ '\'' + ", salary=" + salary + '}';
	}
}

public class StreamApiExamples {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Magan", 30, "HR", 50000),
				new Employee(2, "Bob", 25, "Engineering", 60000), new Employee(3, "Charlie", 35, "Engineering", 70000),
				new Employee(4, "David", 40, "HR", 80000), new Employee(5, "Edward", 45, "Finance", 90000),new Employee(6, "Khemu", 80, "HR", 100000));

		
		Map<String, Integer> deptWiseEmpCount = new HashMap<>();
		for (Employee inp : employees) {
			deptWiseEmpCount.put(inp.getDepartment(), deptWiseEmpCount.getOrDefault(inp.getDepartment(), 0)+1);
		}
		System.out.println(deptWiseEmpCount+"\n");
		
		//using java 8 
		Map<String, Long> mapOfDeptCOunt=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("emp dept Count : "+mapOfDeptCOunt+"\n");
		
		
		List<Employee> empListFilter= employees.stream().filter(t -> t.getName().startsWith("M")).collect(Collectors.toList());
		List<String> empListFilterOnlyName= employees.stream().map(t-> t.getName()).filter(t ->t.startsWith("M")).collect(Collectors.toList());
		System.out.println("Filtering empList : "+empListFilter +"\n");
		System.out.println("Filtering empList : "+empListFilterOnlyName +"\n");
		
		
		
		
		
		// Filter employees with salary greater than 60000
		List<Employee> highSalaryEmployees = employees.stream().filter(e -> e.getSalary() > 60000)
				.collect(Collectors.toList());
		System.out.println("Employees with salary greater than 60000:");
		highSalaryEmployees.forEach(System.out::println);

		// Map employees to their names
		List<String> employeeNames = employees.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println("\nEmployee names:");
		employeeNames.forEach(System.out::println);

		// Find the average salary of employees
		double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
		System.out.println("\nAverage salary: " + averageSalary);

		// Group employees by department
		Map<String, List<Employee>> employeesByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("\nEmployees grouped by department:");
		employeesByDepartment.forEach((department, empList) -> {
			System.out.println(department + ": " + empList);
		});

		// Count employees in each department
		Map<String, Long> employeeCountByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("\nEmployee count by department:");
		employeeCountByDepartment.forEach((department, count) -> {
			System.out.println(department + ": " + count);
		});

		// Find the highest paid employee
		Employee highestPaidEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary))
				.orElse(null);
		System.out.println("\nHighest paid employee:");
		System.out.println(highestPaidEmployee);

		// Find the sum of salaries of all employees
		double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("\nTotal salary of all employees: " + totalSalary);

		// Convert the list of employees to a map with id as key and name as value
		Map<Integer, String> employeeMap = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println("\nEmployee map (id -> name):");
		employeeMap.forEach((id, name) -> {
			System.out.println(id + " -> " + name);
		});

		// Check if any employee is older than 50
		boolean anyEmployeeOlderThan50 = employees.stream().anyMatch(e -> e.getAge() > 50);
		System.out.println("\nAny employee older than 50: " + anyEmployeeOlderThan50);
		
		Optional<Employee> employeeOlderThan50 = employees.stream()
		        .filter(e -> e.getAge() > 50)
		        .findFirst(); // or findAny()
		
		employeeOlderThan50.ifPresent(e -> 
	    System.out.println("By Optional Employee older than 50: " + e.getName()));

		// Check if all employees are older than 20
		boolean allEmployeesOlderThan20 = employees.stream().allMatch(e -> e.getAge() > 20);
		System.out.println("All employees older than 20: " + allEmployeesOlderThan20);

		// Find the first employee in the list
		Employee firstEmployee = employees.stream().findFirst().orElse(null);
		System.out.println("\nFirst employee in the list:");
		System.out.println(firstEmployee);
	}
}
