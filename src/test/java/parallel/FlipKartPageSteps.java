package parallel;

import com.pages.FlipKartPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FlipKartPageSteps {

    FlipKartPage flipKartPage= new FlipKartPage(DriverFactory.getDriver());

    @Given("user is on flipkart site")
    public void userIsOnFlipkartSite() {
        flipKartPage.closePopUp();
    }

    @And("Click on TV & Appliances dropdown button and Navigate to AirConditioners > Window AC’s page")
    public void clickOnTVAppliancesDropdownButtonAndNavigateToAirConditionersWindowACSPage() {
        flipKartPage.hoverOverAppliances();
    }

    @And("user select second third and sixth product and compare it")
    public void userSelectSecondThirdAndSixthProductAndCompareIt() {
        flipKartPage.selectToCompare();
        flipKartPage.clickOnCompareButton();
    }

    @And("Print Name and price of all three products in the console")
    public void printNameAndPriceOfAllThreeProductsInTheConsole() {
        flipKartPage.getNameAndPriceOfProduct();
    }

    @And("add all three product to the cart")
    public void addAllThreeProductToTheCart() {
        flipKartPage.add3ProductToCard();
    }

    @And("Go to the cart and add your area Pincode {string} and check the availability of the product delivery there")
    public void goToTheCartAndAddYourAreaPincodeAndCheckTheAvailabilityOfTheProductDeliveryThere(String pincode) {
        flipKartPage.clickOnCartIcon();
        flipKartPage.setEnterPinCode(pincode);
        flipKartPage.verifyPinCode();

    }

    @And("Print the message getting displayed for the availability delivery of the product in the console")
    public void printTheMessageGettingDisplayedForTheAvailabilityDeliveryOfTheProductInTheConsole() {
        flipKartPage.printMessageOfDelivery();
    }

    @And("Click the Deliver to input box, available to the top of the page, and add another pin code and check the availability of the product delivery there")
    public void clickTheDeliverToInputBoxAvailableToTheTopOfThePageAndAddAnotherPinCodeAndCheckTheAvailabilityOfTheProductDeliveryThere() {
        flipKartPage.clickOnDeliverTo();

    }
}
