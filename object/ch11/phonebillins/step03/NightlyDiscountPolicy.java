package com.sh.object.ch11.phonebillins.step03;

import java.time.Duration;

import com.sh.ch11.money.Money;
import com.sh.ch11.phonebillings.step02.Call;

public class NightlyDiscountPolicy extends BasicRatePolicy {
	public static final int NIGHT_HOUR = 22;

	private Money nightlyAmount;
	private Money regularAmount;
	private Duration seconds;

	public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {
		// super(seconds);  // bad
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		long callFee = call.durationBySec(seconds);
		if (call.isNightlyHour(NIGHT_HOUR)) {
			return nightlyAmount.times(callFee);
		}
		return regularAmount.times(callFee);
	}
}
