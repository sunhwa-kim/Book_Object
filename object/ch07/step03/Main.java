package com.sh.object.ch07.step03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final String[] employees = {"직원A", "직원B", "직원C","아르바이트D","아르바이트E","아르바이트F"};
    private static final double[] basePays = {400, 300, 250,1,1,1.5};
    private static final int[] timeCards = {0, 0, 0, 120, 120, 120};   // 0은 정규직원, 아르바이트 직원은 한달 간 업무 누적 시간
     private static final boolean[] hourly = {false, false, false, true, true, true};   // 각 인덱스별 정규직, 아르바이트 직원 구분

    public static void main(String[] args) {
        // TODO - NEW 요구사항 : 아르바이트 직원에 대한 급여 역시 개발된 급여 관리 시스템을 이용해 계산할 수 있게 해주세요.
        process("아르바이트F");  // 0.15
    }

    private static void process(String name) {
        int index = findIndexByName(name);
        if(index<0) {
            System.out.println("없는 정보 입니다.");
            return;
        }
        var taxRate = getTaxRate();
        if(hourly[index]) {
            Money pay = calculatePayFor(index, taxRate);
            System.out.println(describeResult(name, pay));
        }
       else if(!hourly[index]) {
            Money hourlyPayFor = calculateHourlyPayFor(index, taxRate);
            System.out.println(describeResult(name, hourlyPayFor));
        }
       else {
           System.out.println(sumOfBasePays());
        }
    }

    // 아르바이트 직원 시급은 제외하도록 변경
    private static double sumOfBasePays() {
        return findAllEmployees().stream().mapToDouble(idx -> basePays[idx]).sum();
    }

    private static List<Integer> findAllEmployees() {
        int length = employees.length;
        return IntStream.range(0, length)
                .filter(idx -> !hourly[idx]).mapToObj(idx -> idx)
                .collect(Collectors.toList());
    }

    private static Double getTaxRate() {
        System.out.println("세율을 입력하세요.");
        String input = scan.next();
        return Double.valueOf(input);
    }

    private static Money calculatePayFor(int index, double taxRate) {
        var basePay = Money.wons(basePays[index]);
        return basePay.minus(basePay.times(taxRate));
    }

    private static Money calculateHourlyPayFor(int index, double taxRate) {
        var basePay = Money.wons(basePays[index]).multiply(timeCards[index]);
        return basePay.minus(basePay.times(taxRate));
    }

    private static int findIndexByName(String name) {
        int length = employees.length;
        return IntStream.range(0, length)
                .filter(idx -> employees[idx].equals(name))
                .findFirst()
                .orElse(-1);
    }

    private static String describeResult(String name, Money pay) {
        System.out.println(pay.toString());
        return String.format("이름 : {%s}, 급여 : {%s}", name, pay.toString() );
    }
}
