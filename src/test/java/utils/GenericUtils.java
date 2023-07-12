package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class GenericUtils {
    private final WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {
        Set<String> windowIDs = driver.getWindowHandles();
        String parentWindowID = driver.getWindowHandle();
        String childWindowID = windowIDs.stream()
                .filter(windowID -> !(windowID.equals(parentWindowID)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No child window present"));
        driver.switchTo().window(childWindowID);
        System.out.println("Child window URL : " + driver.getCurrentUrl());
    }
}