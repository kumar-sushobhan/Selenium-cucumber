package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {
    private final CheckoutPage checkoutPage;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }


    @Then("^User proceeds to checkout and validate the (.+) items in Checkout page")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String shortName) {
        checkoutPage.checkoutItems();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }
}