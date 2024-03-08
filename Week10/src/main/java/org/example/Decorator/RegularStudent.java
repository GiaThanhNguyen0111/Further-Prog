package org.example.Decorator;

public class RegularStudent extends StudentDecorator{

    private final double unitFee;

    public RegularStudent(StudentCalculateFee obj, double unitFee) {
        super(obj);
        this.unitFee = unitFee;
    }

    @Override
    public double calcFee() {
        int numberOfCourse = ((Student) obj).getCourses().size();
        return numberOfCourse * unitFee;
    }
}
