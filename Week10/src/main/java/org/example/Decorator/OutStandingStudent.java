package org.example.Decorator;

public class OutStandingStudent extends StudentDecorator{

    private static final double FIXED_AMOUNT = 1000;

    public OutStandingStudent(StudentCalculateFee obj) {
        super(obj);
    }

    @Override
    public double calcFee() {
        return obj.calcFee() < FIXED_AMOUNT ? obj.calcFee()
                : obj.calcFee() - FIXED_AMOUNT;
    }
}
