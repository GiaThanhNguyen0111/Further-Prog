package org.example.Decorator;

public abstract class StudentDecorator implements StudentCalculateFee{
    protected final StudentCalculateFee obj;

    public StudentDecorator(StudentCalculateFee obj) {
        this.obj = obj;
    }

    @Override
    public double calcFee() {
        return obj.calcFee();
    }
}
