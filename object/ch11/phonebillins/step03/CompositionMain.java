package com.sh.object.ch11.phonebillins.step03;

import java.time.Duration;
import java.time.LocalDateTime;

import com.sh.ch11.money.Money;
import com.sh.ch11.phonebillings.step02.Call;

public class CompositionMain {
	public static void main(String[] args) {
		RegularPolicy regularPolicy = new RegularPolicy(Money.wons(10), Duration.ofSeconds(10));
		NightlyDiscountPolicy nightlyDiscountPolicy = new NightlyDiscountPolicy(Money.wons(5), Money.wons(10),
			Duration.ofSeconds(10));
		Phone phone = new Phone(regularPolicy);
		Phone nightlyPhone = new Phone(nightlyDiscountPolicy);

		phone.call(new Call(LocalDateTime.of(2021,1,1,21,59,20),
			LocalDateTime.of(2021,1,1,22,0,00)));
		phone.call(new Call(LocalDateTime.of(2021,1,1,22,00,00),
			LocalDateTime.of(2021,1,1,22,0,50)));

		nightlyPhone.call(new Call(LocalDateTime.of(2021,1,1,21,59,20),
			LocalDateTime.of(2021,1,1,22,0,00)));
		nightlyPhone.call(new Call(LocalDateTime.of(2021,1,1,22,00,00),
			LocalDateTime.of(2021,1,1,22,0,50)));

		System.out.println(phone.calculateFee());    // 90
		System.out.println(nightlyPhone.calculateFee());   // 65
	}
}
