package Week1.main;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject implements Comparable<ResearchProject>{
    private String projectName;
    private Double budget;
    private Lecture leader;

    private List<Person> members;

    public ResearchProject(String projectName, Double budget, Lecture leader, List<Person> members) {
        this.projectName = projectName;
        this.budget = budget;
        this.leader = leader;
        this.members = members;
    }

    public ResearchProject(){
        this.members = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "projectName='" + projectName + '\'' +
                ", budget=" + budget +
                ", leader=" + leader +
                ", members=" + members +
                '}';
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Lecture getLeader() {
        return leader;
    }

    public void setLeader(Lecture leader) {
        this.leader = leader;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public void setMember(Person person) {
        this.members.add(person);
    }

    /**
     * display all members
     *
     */
    void displayMembers() {
        for (Person p: this.members) {
            System.out.println(p);
        }
    }

    @Override
    public int compareTo(ResearchProject o) {
        return Double.compare(this.getBudget(), o.getBudget());
    }
}
