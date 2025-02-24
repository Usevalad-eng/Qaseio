##  [QASE.IO](https://app.qase.io/) - project automated with <u>Java, Selenide, JUnit5, Gradle.</u>

![qaseio.jpg](media/qaseio.jpg)

> Qase.io helps to manage test cases, track their  execution status, and report defects.
> Qase.io is a  test management platform for manual and automated testing, and reporting that helps deliver higher quality software.
> 
## To start testing you should set up underlined technologies and run "gradle clean test" in a Terminal.
> gradle clean test
## To start only Api tests:  run "gradle clean test -Dtag=Api" in a Terminal.
> gradle clean test -Dtag=Api
## To start only UI tests: run "gradle clean test -Dtag=UI" in a Terminal.
> gradle clean test -Dtag=UI
### [Test cases](https://github.com/Usevalad-eng/Qaseio/blob/main/testCases.md/) - test cases to check the project.

### <a name="Tools">Tools are used:</a>

<p  align="left">
<code><img width="5%" title="IntelliJ IDEA" src="media/idea.jpg"></code>
<code><img width="5%" title="Java" src="media/java.png"></code>
<code><img width="5%" title="Gradle" src="media/gradle.png"></code>
<code><img width="5%" title="Allure" src="media/allure.jpg"></code>
<code><img width="5%" title="JUnit5" src="media/junit5.png"></code>
<code><img width="5%" title="Selenide" src="media/selenide.jpg"></code>
</p>

<a name="Description">Description:</a>

The test project consists of UI and API tests.

The project:
- [x] Using parametrized tests,
- [x] Using `Lombok` for  testing,
- [x] Objects  using `Rest-assured` for API serialization/deserialization objects,
- [x] `Allure listener` for logging;

##### Project is being developed 2/24/2025
###### @Owner of these tests: Vsevolod A.
