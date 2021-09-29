package com.sh.object.ch07.step06.employee;


import com.sh.object.ch07.step06.Money;

public abstract class Employee {
    protected String name;
    protected double basePay;

    public Employee(String name, double basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public abstract Money calculatePay(Double taxRate);

    public abstract double monthlyBasePay();

}
