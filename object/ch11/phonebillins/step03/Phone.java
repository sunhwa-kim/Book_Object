package com.sh.object.ch11.phonebillins.step03;

import java.util.ArrayList;
import java.util.List;

import com.sh.ch11.money.Money;
import com.sh.ch11.phonebillings.step02.Call;

public class Phone {
	private RatePolicy ratePolicy;
	private List<Call> calls = new ArrayList<>();

	public Phone(RatePolicy ratePolicy) {
		this.ratePolicy = ratePolicy;
	}

	public void call(Call call) {
		this.calls.add(call);
	}

	public List<Call> getCalls() {
		return calls;
	}

	public Money calculateFee() {
		return ratePolicy.calculateFee(this);
	}

}
