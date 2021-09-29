package com.sh.object.ch07.step02;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static String[] employees = {"직원A", "직원B", "직원C"};
    private static int[] basePays = {400, 300, 250};

    public static void main(String[] args) {
        // TODO - NEW 요구사항 : 회사에 속한 모든 직원들의 기본급의 총합을 구하는 기능을 추가해 주세요
        process(Operations.BASE_PAYS,"직원C");  // 0.15

    }

    private static int sumOfBasePays() {
        return Arrays.stream(basePays).sum();
    }

    private static void process(Operations operations, String name) {
        BigDecimal taxRate = getTaxRate();
        switch (operations) {
            case PAY:
                int pay = calculatePayFor(name, taxRate);
                System.out.println(describeResult(name, pay));
                break;
            case BASE_PAYS:
                System.out.println(sumOfBasePays());
                break;
        }
    }

    private static BigDecimal getTaxRate() {
        System.out.println("세율을 입력하세요.");
        String input = scan.next();
        return new BigDecimal(input);
    }

    private static int calculatePayFor(String name, BigDecimal taxRate) {
        int index = getIndexOfEmployee(name);
        int basePay = basePays[index];
        return basePay - taxRate.multiply(BigDecimal.valueOf(basePay)).intValue();
    }

    private static int getIndexOfEmployee(String name) {
        AtomicInteger i = new AtomicInteger();
        OptionalInt indexOfEmployee = Arrays.stream(employees).mapToInt(value -> i.getAndIncrement())
                .filter(value -> employees[value].equals(name)).findFirst();
        if(indexOfEmployee.isEmpty()) return 0;
        return indexOfEmployee.getAsInt();
    }

    private static String describeResult(String name, int pay) {
        return String.format("이름 : {%s}, 급여 : {%d}", name, pay);
    }

    private enum Operations {
        PAY, BASE_PAYS
    }
}
