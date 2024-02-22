package Test;

import Base.KupujemProdajemBase;
import Pages.KPHome;
import Pages.KPLogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class KPTest extends KupujemProdajemBase {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.kupujemprodajem.com/");
    }

    @Test(priority = 10)
    public void SigninFail() throws InterruptedException {
        kphome.SignIn().click();
        String text = "Ulogujte se";
        Assert.assertEquals(text, kphome.SignIn().getText());
        String email = "unkownsame56@gmail.com";
        String password = "stefan97godiste";
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/h1")));
        kplogin.InputEmail(email);
        kplogin.InputPassword(password);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/div[3]/div/div/div[2]/p")).getText();
        String Neispravan = "Neispravan e-mail ili lozinka";
        Assert.assertEquals(Neispravan, driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/div[3]/div/div/div[2]/p")).getText());
        Assert.assertEquals(Neispravan, driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/div[1]/div")).getText());
    }

    @Test(priority = 20)
    public void SignInEmptyFields() {
        kphome.SignIn().click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/button")).click();
        String emptyfields = "Polje ne može biti prazno.";
        Assert.assertEquals(emptyfields, driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/div[1]/div")).getText());
        Assert.assertEquals(emptyfields, driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/div[2]/div")).getText());
    }

    @Test(priority = 30)
    public void signIn() throws InterruptedException {
        kphome.SignIn().click();
        String text = "Ulogujte se";
        Assert.assertEquals(text, kphome.SignIn().getText());
        String email = "unkownsame56@gmail.com";
        String password = "stefan97godiste!";
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/h1")));
        kplogin.InputEmail(email);
        kplogin.InputPassword(password);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/ul/li[1]/div/div[2]")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/ul/li[1]/div/div[2]")).getText(), email);
        kphome.MojNalog().click();
        String MojNalogTitle = "Moj nalog";
        Thread.sleep(1000);
        Assert.assertEquals(MojNalogTitle, driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div/div/div[2]")).getText());
    }

    @Test(priority = 40)
    public void Signout() throws InterruptedException {
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/ul/li[17]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/ul/li[17]/a")).click();
        String title = "Ulogujte se";
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/section/h1")));
        Assert.assertEquals(title, driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/section/h1")).getText());
    }
    }


