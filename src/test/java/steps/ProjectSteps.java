package steps;

import models.Project;
import pages.ProjectPage;

public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();

    public void createProject(Project project) {
        projectPage.createNewProject();
        /*projectPage.getProjectName(project.getProjectName());
        projectPage.getProjectCode(project.getProjectCode());*/  //lombok
        projectPage.getProjectName(project.getProjName());
        projectPage.getProjectCode(project.getProjCode());
        projectPage.createProject();
    }
}
