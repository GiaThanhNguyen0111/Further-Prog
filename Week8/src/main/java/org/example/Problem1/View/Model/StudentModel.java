package org.example.Problem1.View.Model;

import java.util.Objects;

public class StudentModel {
    private Long id;
    private String fullName;
    private String address;
    private String major;
    private Double GPA;

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    public StudentModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return Long.compare(this.getId(), that.getId()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, address, major, GPA);
    }

    public StudentModel(Long id, String fullName, String address, String major, Double GPA) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.major = major;
        this.GPA = GPA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }
}
