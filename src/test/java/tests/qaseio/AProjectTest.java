package tests.qaseio;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.ProjectStepsPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AProjectTest extends BaseTest {

    ProjectStepsPage steps = new ProjectStepsPage();

    @Test
    //@Disabled
    //@Feature("Project")
   //@Story("User can create a project")
    //@Owner("Vsevolod")
    //@Severity(SeverityLevel.CRITICAL)
    //@Link(value = "test", url = "https://www.test.com")
    //@DisplayName("Creation of project test")
    public void createProjectTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        //steps.attachScreenshot();

        steps.openLoginPage();
        //step("authorization", () -> {
            steps.inputLogin("kubyox@mailto.plus");
            steps.inputPass("qaseio122024");
        //});
        steps.clickSubmit();
        steps.createNewProject();
        steps.enterProjectName("Demo");
        steps.clickCreateProject();
        steps.openProjectsPage();
        steps.assertThatProjectCreated("Demo");
        //closeWebDriver();
        $(".CmRKGs").click();  //click menu
        //$(".OHE0ll").click();  //exit
        $x("//span[text() = 'Sign out']").click();
    }

    /*@Test
    @Disabled
    void dynamic(){
        Allure.feature("proj");
        Allure.story("Story");
        Allure.label("owner", "Vsevolod");
    }*/
}
