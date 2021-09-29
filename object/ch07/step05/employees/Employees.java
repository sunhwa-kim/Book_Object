package com.sh.object.ch07.step05.employees;

import com.sh.object.ch07.step05.Money;

import java.util.ArrayList;
import java.util.Scanner;

public class Employees {
    private static final Scanner scan = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();

    public void register(Employee employee) {
        this.employees.add(employee);
    }

    public String calculatePay(String name) {
        var taxRate = getTaxRate();

        var first = this.employees.stream()
                .filter(employee -> employee.isName(name)).findFirst();
        if(first.isEmpty()) return null;
        Employee employee = first.get();
        return describeResult(name, employee.calculatePay(taxRate));
    }

    private Double getTaxRate() {
        System.out.println("세율을 입력하세요.");
        String input = scan.next();
        return Double.valueOf(input);
    }

    private String describeResult(String name, Money pay) {
        System.out.println(pay.toString());
        return String.format("이름 : {%s}, 급여 : {%s}", name, pay.toString() );
    }

    public Double sumOfBasePays() {
        return this.employees.stream()
                .mapToDouble(employee -> employee.monthlyBasePay())
                .sum();
    }
}
