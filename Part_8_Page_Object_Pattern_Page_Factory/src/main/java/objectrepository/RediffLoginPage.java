package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffLoginPage {

    WebDriver driver;

    By username = By.xpath("//*[@id=\"login1\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By go = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input");

}
