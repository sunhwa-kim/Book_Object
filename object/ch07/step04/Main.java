package com.sh.object.ch07.step04;

import com.sh.object.ch07.step04.employees.Employees;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO - 모듈
        process(Operations.PAY, "아르바이트F");  // 0.15

    }

    private static void process(Operations operations, String name) {
        var taxRate = getTaxRate();
        switch (operations) {
            case PAY:
                var pay = Employees.calculatePay(name, taxRate);
                System.out.println(describeResult(name, pay));
                break;
            case BASE_PAYS:
                System.out.println(Employees.sumOfBasePays());
                break;
        }
    }

    private static Double getTaxRate() {
        System.out.println("세율을 입력하세요.");
        String input = scan.next();
        return Double.valueOf(input);
    }

    private static String describeResult(String name, Money pay) {
        System.out.println(pay.toString());
        return String.format("이름 : {%s}, 급여 : {%s}", name, pay.toString() );
    }

    private enum Operations {
        PAY, BASE_PAYS
    }
}
