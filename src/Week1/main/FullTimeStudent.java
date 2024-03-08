package Week1.main;

import java.util.List;
import java.util.Map;

public class FullTimeStudent extends Student{

    List<ResearchProject> projects;

    public FullTimeStudent(Integer studentId, String name, String major) {
        super(studentId, name, major);
    }

    public List<ResearchProject> getProjects() {
        return projects;
    }

    public void setProjects(List<ResearchProject> projects) {
        this.projects = projects;
    }

    public void joinProject(ResearchProject p) {

    }


}
