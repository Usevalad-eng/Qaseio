package steps;

import models.Project;
import models.ProjectBuilder;
import pages.ProjectPage;

public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();

    public void createProjectWithBuilder(Project project) {
        projectPage.createNewProject();
        /*projectPage.getProjectName(project.getProjectName());
        projectPage.getProjectCode(project.getProjectCode());*/
        projectPage.clickCreateProject();
    }
}
