package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;

    private By courseIcon=By.id("btnMyCoursesList");

    public CoursesPage CourseButton(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(courseIcon).click();
        return new CoursesPage(driver);
    }


    public HomePage(WebDriver driver){
        this.driver=driver;
    }

}


