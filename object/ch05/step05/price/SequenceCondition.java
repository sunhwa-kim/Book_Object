package com.sh.object.ch05.step05.price;

import com.sh.object.ch05.step05.DiscountCondition;
import com.sh.object.ch05.step05.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
