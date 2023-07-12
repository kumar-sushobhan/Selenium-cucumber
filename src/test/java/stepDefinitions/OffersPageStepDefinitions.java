package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
    private String offerPageProductName;
    private final TestContextSetup testContextSetup;
    public OffersPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    private OffersPage offersPage;
    private LandingPage landingPage;

    @Then("^User searched for (.+) shortname in Offers page")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) {
        // Write code here that turns the phrase above into concrete actions
        switchToOfferPage();
        offersPage = testContextSetup.pageObjectManager.getOfferPage();
        offersPage.searchItem(shortName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        offerPageProductName = offersPage.getSearchText();
    }

    private void switchToOfferPage() {
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("Validate product name in Offers page matches with Home page")
    public void validate_product_name_in_offers_page_matches_with_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }

}