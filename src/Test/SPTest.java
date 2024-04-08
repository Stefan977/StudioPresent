package Test;

import Base.StudioPresentBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;

public class SPTest extends StudioPresentBase {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/widgets");
    }
//    @AfterMethod
//    public void beforeTest() {
//        driver.navigate().to("https://demoqa.com/widgets");
//    }

    @Test(priority = 10)
    public void Slider() throws InterruptedException {
        wd.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/span/div"))));
        WebElement Widgets = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/span/div"));
        WebElement sliderbutton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[4]"));
        Widgets.click();
        sliderbutton.click();
        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[1]/span/input"));
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[4]")));
        for (int i = 1; i <= 20; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        int value = Integer.parseInt(driver.findElement(By.id("sliderValue")).getAttribute("value"));
        Boolean b = true;
        if (value >= 70 && value <= 99) {
            Assert.assertTrue(b);
            System.out.println("Pass");
        } else {
            System.out.println("Value not between the range");
            Assert.assertFalse(b);
        }
    }
        @Test(priority = 20)
        public void Drop() throws InterruptedException {
            wd.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/span/div"))));
            Thread.sleep(5000);
          driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/span/div/div[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/div/ul/li[4]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/nav/a[2]")).click();
            Thread.sleep(2000);
            WebElement fromElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]"));
            WebElement toElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]"));
            Actions action = new Actions(driver);
            action.dragAndDrop(fromElement, toElement).perform();
            Thread.sleep(5000);
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/p")).getText(), "Dropped!");


        }
    }


