package com.sh.object.ch07.step06.employee;


import com.sh.object.ch07.step06.Money;

public class SalariedEmployee extends Employee{

    public SalariedEmployee(String name, double basePay) {
        super(name, basePay);
    }

    @Override
    public Money calculatePay(Double taxRate) {
        Money money = Money.wons(basePay);
        return money.minus(money.times(taxRate));
    }

    @Override
    public double monthlyBasePay() {
        return basePay;
    }
}
