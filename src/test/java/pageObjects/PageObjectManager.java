package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }
    public LandingPage getLandingPage() {
        return new LandingPage(driver);
    }

    public OffersPage getOfferPage() {
        return new OffersPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }
}