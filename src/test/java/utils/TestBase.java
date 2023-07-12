package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;

public class TestBase {
    private WebDriver driver;

    public WebDriver webDriverManager() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = properties.getProperty("QAUrl");

        String browser_properties = properties.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        // Java ternary operator
        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {
            if (Objects.equals(browser, "chrome")) {
                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.BROWSER, Level.ALL);
                options.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            } else if (Objects.equals(browser, "firefox")) {
                driver = new FirefoxDriver();
            }
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}