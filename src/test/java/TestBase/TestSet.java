package TestBase;

import Pages.*;

import Property.ReadFromPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestSet {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CoursesPage coursesPage;
    protected AddCourse addCoursePage;


    public String URL;
    public String Username;
    public String Password;
    public String CourseName;
    public String Subjecttext;
    public String gradetext;
    public String teachertext;

    @BeforeTest
    public void SetUp() throws IOException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options=new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        loginPage=new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get(ReadFromPropertyFile.get("url"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
