package com.sh.object.ch11.phonebillins.step03;

import com.sh.ch11.money.Money;
import com.sh.ch11.phonebillings.step02.Call;

public abstract class BasicRatePolicy implements RatePolicy {
	@Override
	public Money calculateFee(Phone phone) {
		Money result = Money.ZERO;

		for (Call call : phone.getCalls()) {
			result = result.plus(calculateCallFee(call));
		}

		return result;
	}

	protected abstract Money calculateCallFee(Call call);

}
