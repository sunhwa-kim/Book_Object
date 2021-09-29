package com.sh.object.ch07.step05;

import com.sh.object.ch07.step05.employees.Employee;
import com.sh.object.ch07.step05.employees.Employees;

public class Main {
    public static void main(String[] args) {
        Employees employees = new Employees();

        employees.register(Employee.of("직원A",400,false,0));
        employees.register(Employee.of("직원B",300,false,0));
        employees.register(Employee.of("직원C",250,false,0));
        employees.register(Employee.of("아르바이트D",1,true,120));
        employees.register(Employee.of("아르바이트E",1,true,120));
        employees.register(Employee.of("아르바이트F",1.5,true,120));

//        employees.calculatePay("직원A");
        System.out.println(employees.sumOfBasePays());
    }
}
