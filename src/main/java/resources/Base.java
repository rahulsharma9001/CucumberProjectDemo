package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class Base {
    private WebDriver driver;
    public WebDriver getDriver(){return driver;}

    public WebDriver initializeDriver() throws IOException{
        if(driver == null){
            String browser = loadProperties("webBrowser");
            System.out.println("Executing Browser " + browser);

            if(browser.equalsIgnoreCase("Chrome")){
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(option);

            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Edge")) {
                EdgeOptions options = new EdgeOptions();
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("Chrome headless")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("start-maximized");
                options.addArguments("--window-size=1920x1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);

                System.out.println("Initialized Chrome in headless mode");
            }else {
                System.out.println("There is an Error in Browser Name");
                throw new IllegalArgumentException("Unsupported Browser "+ browser);
            }

        }
        return driver;

    }

    public String loadProperties(String property) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream dataFile = new FileInputStream("src/main/java/resources/data.properties")) {
            properties.load(dataFile);
            return properties.getProperty(property).trim();
        }
    }
}
