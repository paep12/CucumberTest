package testRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login
{

    // Selenium Driver to open Chrome
    private WebDriver webdriver;

    @Then("i can enter the correct ID")
    public void i_can_enter_the_correct_id()
    {
        // Sleep time to give time to the chrome window to load all the information
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Find element with xpath to select the id button
        WebElement buttonId = webdriver.findElement(By.xpath("//*[@id=\"resolving_input\"]"));
        // Property that click in the id input
        buttonId.click();
        // Send information to the id input
        buttonId.sendKeys("1104");

    }

    @And("i click in the login button")
    public void i_click_in_the_login_button()
    {
        // Find element with xpath to select the loggin button
        WebElement logginButton =
            webdriver.findElement(By.xpath("//*[@id=\"input_signin_button\"]"));
        // Property that click in the loggin button
        logginButton.click();
    }

    @And("i click in the Next Button")
    public void i_click_in_the_next_button()
    {
        // Find element with xpath to find next button
        WebElement buttonNext = webdriver.findElement(By.xpath("//*[@id=\"next_button\"]"));
        // Property that click in the button 'Next'
        buttonNext.click();
    }

    @Given("i open the page with the URL")
    public void i_open_the_page_with_the_url()
    {
        // Configuration with the chrome driver to set the system property
        System.setProperty("webdriver.chrome.driver", "./src/test/java/driver/chromedriver.exe");
        // Creation of the instance of the driver configuration with the chrome driver
        webdriver = new ChromeDriver();
        // Maximaze the google chrome window
        webdriver.manage().window().maximize();
        // URL to open in chrome
        webdriver.get("https://aws.amazon.com/es/");
    }

    @When("i see the menu, i click in Account Settings")
    public void i_see_the_menu_i_click_in_Account_Settings()
    {

        // Find element with xpath to select the option 'Account Settings'
        WebElement accountConf = webdriver.findElement(By.xpath("/html/body/div[5]/ul/li[2]"));
        // Click in the option 'Account Settings'
        accountConf.click();

    }

    @Then("^i can enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_and_password(String login, String password)
    {
        // Find element with id to select the username button
        WebElement userName = webdriver.findElement(By.id("username"));
        // Property that click in the username button
        userName.click();
        // Option to send the information to the username button
        userName.sendKeys(login);

        // Find element with id to select the password button
        WebElement pass = webdriver.findElement(By.id("password"));
        // Property that click in the password button
        pass.click();
        // Option to send the information to the password button
        pass.sendKeys(password);
    }

    @And("i click in My account option")
    public void user_select_menu_my_account()
    {
        Actions builder = new Actions(webdriver);
        // Find element with xpath to select the option 'Mi account'
        WebElement buttonUsser =
            webdriver.findElement(By.xpath("//*[@id=\"m-nav\"]/div[1]/div[2]/a[4]"));

        // Property to move the mouse from 'Mi account' to 'Account Settings'
        builder.moveToElement(buttonUsser)
            .moveToElement(webdriver.findElement(By.xpath("/html/body/div[5]/ul/li[2]"))).click()
            .build().perform();

    }

}
