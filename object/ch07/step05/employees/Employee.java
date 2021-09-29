package com.sh.object.ch07.step05.employees;

import com.sh.object.ch07.step05.Money;

public class Employee {
    private String name;
    private double basePay;
    private boolean hourly;
    private int timeCard;

    private Employee(){}

    public static Employee of(String name, double basePay, boolean hourly, int timeCard) {
        Employee employee = new Employee();
        employee.name = name;
        employee.basePay = basePay;
        employee.hourly = hourly;
        employee.timeCard = timeCard;
        return employee;
    }

    public Money calculatePay(Double taxRate) {
        if (hourly) return calculateHourlyPayFor(taxRate);
        return calculatePayFor(taxRate);
    }

    private Money calculatePayFor(double taxRate) {
        var basePay = Money.wons(this.basePay);
        return basePay.minus(basePay.times(taxRate));
    }

    private Money calculateHourlyPayFor(double taxRate) {
        var basePay = Money.wons(this.basePay).multiply(timeCard);
        return basePay.minus(basePay.times(taxRate));
    }

    public double monthlyBasePay() {
        if(this.hourly) return 0;
        return this.basePay;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }
}
