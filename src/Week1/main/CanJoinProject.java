package Week1.main;

import java.util.List;
import java.util.Map;

public interface CanJoinProject {
    List<ResearchProject> getListProjects(Person person);
    void setListProjects(Person person, ResearchProject researchProject);

    List<ResearchProject> getListInReverse(Person person);
}
