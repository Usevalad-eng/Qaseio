package steps;

import pages.ProjectPage;
import tests.api.pojos.request.project.CreateProjectRequest;

public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();

    public void createProject(CreateProjectRequest project) {
        projectPage.createNewProjectButtonToClick();
        projectPage.inputProjectName(project.getTitle());
        projectPage.createProjectButtonToClick();
    }
}
