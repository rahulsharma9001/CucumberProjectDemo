package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html#");
    }
    @FindBy(css = "input[type=\"checkbox\"]")
    WebElement menuButton;
    @FindBy(xpath = "//li[text()='Sign In Portal']\n")
    WebElement signInOption;
    @FindBy(id = "#usr")
    WebElement Username;
    @FindBy(id = "#pwd")
    WebElement password;
    @FindBy(css = "input.btn.btn-info")
    WebElement signInButton;
    @FindBy(id = "#NewRegistration")
    WebElement registrationButton;


    public void click_menu(){
        wait.until(ExpectedConditions.visibilityOf(menuButton));
        menuButton.click();
    }


    public void SignIn(){
        wait.until(ExpectedConditions.visibilityOf(signInOption));
        signInOption.click();
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void clickOnRegistrationButton(){
        wait.until(ExpectedConditions.visibilityOf(registrationButton));
        registrationButton.click();
    }

    public void enter_credentials_for_sigIn(){
        wait.until(ExpectedConditions.visibilityOf(Username));
        Username.sendKeys("Rahul1");
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Rahul1");
    }

    public void assert_url(){
        String expected_url = "https://anupdamoda.github.io/AceOnlineShoePortal/ShoeTypes.html";
        String actual_url = driver.getCurrentUrl();
        boolean successfully_Navigated = actual_url.equals(expected_url);
        if (successfully_Navigated == true){
            System.out.println("Successfully navigated after entering the credentials");
        }else {
            System.out.println("Wrong Credentials entered");
        }
    }
}
