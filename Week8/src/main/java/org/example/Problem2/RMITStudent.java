package org.example.Problem2;

public class RMITStudent {
    private Long id;
    private String name;
    private Double GPA;
    private boolean isShared;

    public RMITStudent(Long id, String name, Double GPA, boolean isShared) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.isShared = isShared;
    }

    @Override
    public String toString() {
        return "RMITStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", GPA=" + GPA +
                ", isShared=" + isShared +
                '}';
    }

    public RMITStudent() {
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

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }
}
