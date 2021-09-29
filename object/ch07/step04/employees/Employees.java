package com.sh.object.ch07.step04.employees;

import com.sh.object.ch07.step04.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Employees {
    //    private static final Scanner scan = new Scanner(System.in);
    private static final String[] employees = {"직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"};
    private static final double[] basePays = {400, 300, 250, 1, 1, 1.5};
    private static final int[] timeCards = {0, 0, 0, 120, 120, 120};   // 0은 정규직원, 아르바이트 직원은 한달 간 업무 누적 시간
    private static final boolean[] hourly = {false, false, false, true, true, true};   // 각 인덱스별 정규직, 아르바이트 직원 구분


    public static Money calculatePay(String name, Double taxRate) {
        int index = findIndexByName(name);
        if (hourly[index]) return calculateHourlyPayFor(index, taxRate);
        return calculatePayFor(index, taxRate);
    }

    private static int findIndexByName(String name) {
        int length = employees.length;
        return IntStream.range(0, length)
                .filter(idx -> employees[idx].equals(name))
                .findFirst()
                .orElse(-1);
    }

    private static Money calculatePayFor(int index, double taxRate) {
        var basePay = Money.wons(basePays[index]);
        return basePay.minus(basePay.times(taxRate));
    }

    private static Money calculateHourlyPayFor(int index, double taxRate) {
        var basePay = Money.wons(basePays[index]).multiply(timeCards[index]);
        return basePay.minus(basePay.times(taxRate));
    }

    // 아르바이트 직원 시급은 제외하도록 변경
    public static double sumOfBasePays() {
        return findAllEmployees().stream().mapToDouble(idx -> basePays[idx]).sum();
    }

    private static List<Integer> findAllEmployees() {
        int length = employees.length;
        return IntStream.range(0, length)
                .filter(idx -> !hourly[idx]).mapToObj(idx -> idx)
                .collect(Collectors.toList());
    }
}
