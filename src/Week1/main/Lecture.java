package Week1.main;

import java.util.*;

public class Lecture extends Person {
    private Integer employeeId;
    private String fullName;
    private String rank;

    private ResearchProject leadProjectResearch;
    private List<ResearchProject> attendProject;


    public Lecture(Integer employeeId, String fullName, String rank) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.rank = rank;
    }

    public Lecture() {
        this.attendProject = new ArrayList<>();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    void joinProject(ResearchProject p) {
        p.setMember(this);
    }

    public ResearchProject getLeadProjectResearch() {
        return leadProjectResearch;
    }

    public void setLeadProjectResearch(ResearchProject leadProjectResearch) {
        this.leadProjectResearch = leadProjectResearch;
    }

    public List<ResearchProject> getAttendProject() {
        return attendProject;
    }

    public void setAttendProject(List<ResearchProject> attendProject) {
        this.attendProject = attendProject;
    }

    boolean leadProject(Set<Lecture> leaders) {
        if (leaders.contains(this)) {
           return false;
        } else {
            leaders.add(this);
            return true;
        }
    }

    boolean retrieveLeader(Set<Lecture> leaders) {
        if (leaders.contains(this)) {
            leaders.remove(this);
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Lecture lecture) {
        return this.getEmployeeId().equals(lecture.getEmployeeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, fullName, rank, leadProjectResearch, attendProject);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "employeeId=" + employeeId +
                ", fullName='" + fullName + '\'' +
                ", rank='" + rank + '\'' +
                ", attendProject=" + attendProject +
                '}';
    }


}
