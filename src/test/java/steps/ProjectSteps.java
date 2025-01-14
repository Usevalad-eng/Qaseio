package steps;

import models.Project;
import pages.ProjectPage;

public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();

    public void createProject(Project project) {
        projectPage.createNewProject();
        projectPage.inputProjectName(project.getProjectName());
        //projectPage.getProjectCode(project.getProjectCode());
        projectPage.createProject();
    }
}
