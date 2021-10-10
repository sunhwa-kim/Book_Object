package com.sh.object.ch11.phonebillins.step03;

import java.time.Duration;

import com.sh.ch11.money.Money;
import com.sh.ch11.phonebillings.step02.Call;

public class RegularPolicy extends BasicRatePolicy{
	private Money amount;
	private Duration seconds;

	public RegularPolicy(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.durationBySec(seconds));
	}
}
