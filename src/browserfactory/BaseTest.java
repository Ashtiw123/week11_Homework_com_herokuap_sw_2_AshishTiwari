package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    //Defining general URL
    public  void openBrowser(String baseUrl) {

        driver = new ChromeDriver();
        //Launch URL
        driver.get(baseUrl);
        //Maximizing window
        driver.manage().window().maximize();
        //Implicit time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void closeBrowser(){

        driver.close();
    }
}
