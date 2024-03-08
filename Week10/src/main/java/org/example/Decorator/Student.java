package org.example.Decorator;

import java.util.List;

public class Student implements  StudentCalculateFee {
    private Long id;
    private String name;
    private Double GPA;
    private List<String> courses;


    public Student() {
    }

    public Student(Long id, String name, Double GPA, List<String> courses) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public double calcFee() {
        return 0.0;
    }
}
