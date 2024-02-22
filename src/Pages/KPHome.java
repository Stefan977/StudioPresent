package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KPHome {
    public WebDriver driver;

    public KPHome(WebDriver driver) {
        this.driver = driver;
}
    public WebElement SignIn() {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/div/div/ul/li[2]/button"));
    }
    public WebElement SignUp() {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/div/div/ul/li[3]/a/span"));
    }
    public WebElement MojNalog() {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div[1]/section/ul/li[16]/a"));
    }

}
