package Week1.main;

import java.util.*;

public class CanJoinProjectDelegate implements CanJoinProject{

    private Map<Person, List<ResearchProject>> researchProjects;

    @Override
    public List<ResearchProject> getListProjects(Person person) {
        return researchProjects.get(person);
    }

    @Override
    public void setListProjects(Person person,ResearchProject researchProject) {
        List<ResearchProject> newResearchProject = researchProjects.get(person);
        newResearchProject.add(researchProject);
        researchProjects.put(person, newResearchProject);
    }

    @Override
    public List<ResearchProject> getListInReverse(Person person) {
        List<ResearchProject> projects = getListProjects(person);
        projects.sort((o1, o2) -> o2.compareTo(o1));
        return projects;
    }
}
