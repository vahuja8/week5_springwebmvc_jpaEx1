package com.va.week5;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	
	@Id
	@Column
	private int empId;

	@Column
private String empName;

	@Column
	private String jobTitle;
	@Column
	private double salary;

	@Column
	private int deptNo;
	
	Employee() { }

	public Employee(int empId, String empName, String jotTitle, double salary, int deptNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.jobTitle = jotTitle;
		this.salary = salary;
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", jotTitle=" + jobTitle + ", salary=" + salary
				+ ", deptNo=" + deptNo + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getJotTitle() {
		return jobTitle;
	}

	public double getSalary() {
		return salary;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setJotTitle(String jotTitle) {
		this.jobTitle = jotTitle;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}	
	

}
