import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;


    public void login() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/datadriven.properties");
        prop.load(fis);

        if (prop.getProperty("browser").contains("safari")) {
            driver = new SafariDriver();
        } else if (prop.getProperty("browser").contains("chrome")) {
            driver = new ChromeDriver();
        }

        driver.get(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println("I will execute first");
        driver.quit();


    }
}