package tests.headlesTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProjectPage;
import tests.base.BaseHeadlessTest;

import static io.qameta.allure.Allure.step;

public class ProjTest extends BaseHeadlessTest {

    ProjectPage projectPage = new ProjectPage();

    @Test
    @Feature("Project")
    @Story("User can create a project")
    @Owner("Vsevolod")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://www.test.com")
    @DisplayName("Creation of project test")
    public void createProjectTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectPage.openLoginPage();
        //step("authorization", () -> {
            projectPage.inputLogin("kubyox@mailto.plus");
            projectPage.inputPass("qaseio122024");
        //});
        projectPage.clickSubmit();
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        projectPage.enterProjectName("Demo");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
    }

    @Test
    @Disabled
    public void createProjectAndExitTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectPage.openLoginPage();
        projectPage.inputLogin("kubyox@mailto.plus");
        projectPage.inputPass("qaseio122024");
        projectPage.clickSubmit();
        projectPage.createNewProject();
        projectPage.enterProjectName("Demo");
        projectPage.clickCreateProject();
        projectPage.openProjectsPage();
        projectPage.assertThatProjectCreated("Demo");
        projectPage.findMenu();
        projectPage.findExit();
        projectPage.assertThatExit();
    }

    @Test
    @Disabled
    void dynamic() {
        Allure.feature("proj");
        Allure.story("Story");
        Allure.label("owner", "Vsevolod");
    }
}
