package com.sh.object.ch09.ocp.pricing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sh.object.ch09.ocp.DiscountPolicy;
import com.sh.object.ch09.ocp.Screening;
import com.sh.object.ch09.utils.Money;

public class OverlappedDiscountPolicy extends DiscountPolicy {
	private List<DiscountPolicy> discountPolicies = new ArrayList<>();

	public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
		this. discountPolicies = Arrays.asList(discountPolicies);
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		Money result = Money.ZERO;
		for(DiscountPolicy each : discountPolicies) {
			result = result.plus(each.calculateDiscountAmount(screening));
		}
		return result;
	}
}
