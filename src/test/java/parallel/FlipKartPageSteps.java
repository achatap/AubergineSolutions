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
}
