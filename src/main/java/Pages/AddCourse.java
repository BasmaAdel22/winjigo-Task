package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddCourse {

    private WebDriver driver;

    final WebDriverWait wait;
    private By courseName = By.id("txtCourseName");
    private By courseSubject = By.id("courseSubject");
    private By courseGrade = By.id("courseGrade");
    private By selectTeachers = By.className("ui-select-choices-group");
    static Select dropSubjectList;
    static Select dropGradeList;

    public By CreateButton = By.id("btnSaveAsDraftCourse");

    private By gradeRadioBtn = By.className("label");

    public void enterCourseName(String course) {
        wait.until(ExpectedConditions.presenceOfElementLocated(courseName));
        driver.findElement(courseName).sendKeys(course);
    }

    public void dropSubject(String subject) {
        wait.until(ExpectedConditions.presenceOfElementLocated(courseSubject));
        dropSubjectList = new Select(driver.findElement(courseSubject));
        dropSubjectList.selectByVisibleText(subject);
    }

    public void dropGrade(String grade) {
        wait.until(ExpectedConditions.presenceOfElementLocated(courseGrade));

        dropGradeList = new Select(driver.findElement(courseGrade));
        dropGradeList.selectByVisibleText(grade);
    }


    public void radioGradeClick() {
        wait.until(ExpectedConditions.presenceOfElementLocated(gradeRadioBtn));
        driver.findElement(gradeRadioBtn).click();
    }


    public void dropteacher(String teacher) throws Exception {
        driver.findElement(By.xpath("//*[@id=\"teacherOnBehalf\"]/div[1]")).click();
        Thread.sleep(2000);

        List<WebElement> teachers = driver.findElements(selectTeachers)
                .stream().filter(new Predicate<WebElement>() {
                    @Override
                    public boolean test(WebElement webElement) {
                        return webElement.findElement(By.id("lnkteacherFullName")).getText().contains(teacher);
                    }
                }).collect(Collectors.toList());

        if (teachers.isEmpty())
            throw new Exception("teacher not found");

        teachers.get(0).click();
    }

    public HomePage CreateButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreateButton));
        driver.findElement(CreateButton).click();
        return new HomePage(driver);
    }

    public AddCourse(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

}
