package utils;

import pageObjects.PageObjectManager;

public class TestContextSetup {
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;
    public TestBase testBase;
    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}