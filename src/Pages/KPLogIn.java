package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KPLogIn {
    public WebDriver driver;

    public KPLogIn(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Email() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/section[1]/div/input"));

    }

    public void InputEmail(String email) {
        Email().sendKeys(email);
    }

    public WebElement Password() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/section[2]/div/input"));
    }

    public void InputPassword(String password) {
        Password().sendKeys(password);
    }

    public WebElement Captcha() {
        return driver.findElement((By.xpath("/html/body/div/div[1]/div[1]/div/div/div[1]")));

    }

    public WebElement LogInButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div/div/div[2]/main/div[2]/form/button"));

    }

}
