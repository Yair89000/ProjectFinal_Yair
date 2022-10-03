import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.io.File;

public class ProjectTest {

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
    }

    @Test
    public static void MyTest1(){

        WebDriver driver = new ChromeDriver();
        driver.get(Helper.SPORT5URL);

        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        driver.get(Helper.GOOGLEURL);


        String MYWINDOW = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(Helper.SPORT5URL);
        String MYWINDOW2 = driver.getWindowHandle();
        driver.get(Helper.GOOGLEURL);
        driver.switchTo().window(MYWINDOW);
        driver.get(Helper.SPORT5URL);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Helper.GOOGLEURL);
        driver.switchTo().window(MYWINDOW2);
        driver.close();

    }

    @Test
    public static void POKIMON(){
    WebDriver driver = new ChromeDriver();
    driver.get(Helper.GOOGLEURL);
    driver.navigate().to(Helper.SPORT5URL);
    driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();
    driver.get(Helper.SPORT5URL);
    driver.quit();
        
    }

    @Test
    public static void Test3() {
    WebDriver driver = new ChromeDriver();
    driver.get(Helper.GOOGLEURL);
    WebElement search = driver.findElement(By.name(Helper.GOOGLESEARCH));
    search.sendKeys("movie");
    WebElement click = driver.findElement(By.xpath(Helper.CLICK));
    click.click();
        System.out.println(driver.findElement(By.id(Helper.TEXT)).getText());
        driver.quit();
    }

    @Test
    public static void Test4(){
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.GOOGLEURL);
        WebElement search = driver.findElement(By.name(Helper.GOOGLESEARCH));
        search.sendKeys("movie");
        WebElement click = driver.findElement(By.xpath(Helper.CLICK));
        click.click();

        Assert.assertEquals(driver.getCurrentUrl(), Helper.MOVIE);
        driver.quit();





    }









}
