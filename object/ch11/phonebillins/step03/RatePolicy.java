package com.sh.object.ch11.phonebillins.step03;

import com.sh.ch11.money.Money;

public interface RatePolicy {
	Money calculateFee(Phone phone);
}
