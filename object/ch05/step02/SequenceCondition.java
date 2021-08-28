package com.sh.object.ch05.step02;


import com.sh.object.ch05.step01.Screening;

public class SequenceCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }
}
