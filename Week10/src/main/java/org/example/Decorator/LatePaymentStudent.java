package org.example.Decorator;

public class LatePaymentStudent extends StudentDecorator{

    public LatePaymentStudent(StudentCalculateFee obj) {
        super(obj);
    }

    @Override
    public double calcFee() {
        return obj.calcFee() * 1.1;
    }
}
