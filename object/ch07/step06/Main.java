package com.sh.object.ch07.step06;


import com.sh.object.ch07.step06.employee.HourlyEmployee;
import com.sh.object.ch07.step06.employee.SalariedEmployee;
import com.sh.object.ch07.step06.employees.Employees;

public class Main {
    public static void main(String[] args) {
        Employees employees = new Employees();

        employees.register(new SalariedEmployee("직원A",400));
        employees.register(new SalariedEmployee("직원B",300));
        employees.register(new SalariedEmployee("직원C",250));
        employees.register(new HourlyEmployee("아르바이트D",1,120));
        employees.register(new HourlyEmployee("아르바이트E",1,120));
        employees.register(new HourlyEmployee("아르바이트F",1.5,120));

//        employees.calculatePay("직원A");
        System.out.println(employees.sumOfBasePays());
    }
}
