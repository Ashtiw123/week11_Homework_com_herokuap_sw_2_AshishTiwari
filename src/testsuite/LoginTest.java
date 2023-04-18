package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Extending Base method
public class LoginTest extends BaseTest {
    //Declaring URL
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before

    //Launching URL
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //locating elements through Xpath and inputting username in username field
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("tomsmith");
        //locating elements through Xpath and inputting password in the field
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SuperSecretPassword!");
        //loacting login link via xpath and clicking
        WebElement loginLink = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginLink.click();
        //Cross-checking Label Secure Area
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualTextElement.getText();
        //Cross-checking with automation
        Assert.assertEquals("User was not able to Login", expectedMessage, actualMessage);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Locating elements through Xpath and inputting incorrect username in username field
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("tomsmith1");
        //Locating elements through Xpath and inputting password in the field
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginLink = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginLink.click();
//        String expectedMessage = "Your username is invalid! \n" + "x";
//        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
//        String actualMessage = actualTextElement.getText();
//        //Cross-checking with automation
//        Assert.assertEquals("Your username is invalid!", expectedMessage, actualMessage);
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(" Your username is invalid is not displayed",expectedMessage, actualMessage);
    }
@Test
        public void verifyThePasswordErrorMessage(){
    // verifying login page and message :your password is invalid
    WebElement userName = driver.findElement(By.id("username"));
    userName.sendKeys("tomsmith");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword");
    driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

    String expectedMessage = "Your password is invalid!\n×";
    WebElement actualTextElement= driver.findElement(By.id("flash"));
    String actualMessage=actualTextElement.getText();
    Assert.assertEquals("Your Password is invalid is not displayed",expectedMessage,actualMessage);
}


    @After
    public void tearDown() {
        closeBrowser();
    }

}



