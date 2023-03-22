package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Predicate;

public class CoursesPage {

    private WebDriver driver;
    final WebDriverWait wait;

    private By addcourse = By.cssSelector("#btnListAddCourse");

    private By txtCourseSearch = By.id("txtCourseSearch");
    private By btnCourseSearch = By.id("btnCourseSearch");
    private By divTotalSearchResultsCount = By.id("divTotalSearchResultsCount");

    private By coursesList = By.xpath("//*[@id=\"coursediv\"]/div/div/div/div/div[3]/div/div/div/div[4]/ul/li");


    public AddCourse clickOnAddCourse() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addcourse));
        driver.findElement(addcourse).click();
        return new AddCourse(driver);
    }

    public boolean SearchForCourseName(String courseName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txtCourseSearch));
        driver.findElement(txtCourseSearch).sendKeys(courseName);
        driver.findElement(btnCourseSearch).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(divTotalSearchResultsCount));

        return driver.findElements(coursesList).stream().anyMatch(new Predicate<WebElement>() {
            @Override
            public boolean test(WebElement webElement) {
                return webElement.findElement(By.id("lnkListCourseSelcted")).getText().contains(courseName);
            }
        });
    }

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

}
