package com.sh.object.ch07.step06.employees;

import com.sh.object.ch07.step06.employee.Employee;

import java.util.ArrayList;

public class Employees {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void register(Employee employee) {
        this.employees.add(employee);
    }

    public double sumOfBasePays() {
        return this.employees.stream()
                .mapToDouble(Employee::monthlyBasePay).sum();
    }
}
