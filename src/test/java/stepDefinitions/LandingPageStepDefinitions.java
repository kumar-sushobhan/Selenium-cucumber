package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
    private final TestContextSetup testContextSetup;
    private final LandingPage landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertEquals(testContextSetup.testBase.webDriverManager().getTitle(), "GreenKart - veg and fruits kart");
    }

    @When("^User searched with shortname (.+) and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        landingPage.searchItem(shortName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testContextSetup.landingPageProductName = landingPage.getSearchText().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
    }

    @And("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}