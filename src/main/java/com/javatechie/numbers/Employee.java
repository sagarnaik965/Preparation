package com.javatechie.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Department {
		String name;

		public Department(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Department [name=" + name + "]";
		}
		
	
	}
	
	public class Employee {
		
		
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Employee(String name,String deptName) {
			super();
			this.deptName = deptName;
			this.name = name;
		}
		String deptName;
		String name;
		
		
		
		@Override
		public String toString() {
			return "Employee [deptName=" + deptName + ", name=" + name + "]";
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Department d1 = new Department("CDAC");
			Department d2 = new Department("CDAC2");
			Department d3 = new Department("CDAC3");
			List<Department> deptList = new ArrayList<>();
			deptList.add(d3);
			deptList.add(d1);
			deptList.add(d2);
			
			Employee e1 = new Employee("Prachi","CDAC");
			Employee e2 = new Employee("Prachi1","CDAC");
			Employee e3 = new Employee("Prachi3","CDAC3");
			
			List<Employee> empList = new ArrayList<>();
			empList.add(e3);
			empList.add(e2);
			empList.add(e1);
			
			empList.stream().forEach(System.out::println);
	        IntStream.range(1, 11).forEach(System.out::print);
	        List<String> names = java.util.Arrays.asList("John", "Alice", "Bob", "Alex");

	        List<String> filteredNames = names.stream()
	            .filter(name -> name.startsWith("A"))  // Keep names starting with 'A'
	            .collect(Collectors.toList());

	        System.out.println(filteredNames); // [Alice, Alex]
			
			
	        //String Decomposition
			
			
//	        Map<String, Long> employeeCountByDept = empList.stream()
//	                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
//
//	        deptList.forEach(dept -> {
//	            System.out.println("Department: " + dept.getName() + 
//	                               " - Number of Employees: " + 
//	                               employeeCountByDept.getOrDefault(dept.getName(), 0L));
//	        });
			
			
			
		
			
			
			
			
			
			
		}
	}
	
	

	


