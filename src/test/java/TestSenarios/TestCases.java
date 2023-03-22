package TestSenarios;

import Property.ReadFromPropertyFile;
import TestBase.TestSet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCases extends TestSet {

    @Test (priority = 1)
    public void SuccessLogin() throws Exception {
        loginPage.enterusername(ReadFromPropertyFile.get("username"));
        loginPage.enterpassword(ReadFromPropertyFile.get("password"));
        homePage = loginPage.ClickOnLogin();
    }

    @Test (priority = 2)
    public void SuccessAddCourse() throws Exception {
        coursesPage = homePage.CourseButton();
        addCoursePage = coursesPage.clickOnAddCourse();
        addCoursePage.enterCourseName(ReadFromPropertyFile.get("courseName"));
        addCoursePage.dropSubject(ReadFromPropertyFile.get("subject"));
        addCoursePage.dropGrade(ReadFromPropertyFile.get("grade"));
        addCoursePage.radioGradeClick();
        addCoursePage.dropteacher(ReadFromPropertyFile.get("teachername"));
        homePage = addCoursePage.CreateButton();

    }

    @Test (priority = 3)
    public void CheckCourseExistence() throws IOException {
        coursesPage = homePage.CourseButton();
        boolean isCourseExist = coursesPage.SearchForCourseName(ReadFromPropertyFile.get("courseName"));
        Assert.assertTrue(isCourseExist);
    }

}
