package com.sh.object.ch07.step06.employee;


import com.sh.object.ch07.step06.Money;

public class HourlyEmployee extends Employee{
    private int timeCard;

    public HourlyEmployee(String name, double basePay, int timeCard) {
        super(name, basePay);
        this.timeCard = timeCard;
    }

    @Override
    public Money calculatePay(Double taxRate) {
        Money totalHourlyPayPerMonth = Money.wons(basePay).multiply(timeCard);
        return totalHourlyPayPerMonth.minus(totalHourlyPayPerMonth.times(taxRate));
    }

    @Override
    public double monthlyBasePay() {
        return 0;
    }
}
