package Week1.main;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private Integer studentId;
    private String name;
    private String major;

    private String studentType;
    private Double GPA;

    public Student(Integer studentId, String name, String major, Double GPA, String studentType) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.GPA = GPA;
        this.studentType = studentType;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public Student(Integer studentId, String name, String major) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
    }

    public Student() {
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    void joinProject(ResearchProject p) {
        if (this instanceof FullTimeStudent) {
            p.setMember(this);
        }
    }

    @Override
    public boolean equals(Lecture lecture) {
        return false;
    }
}
