package parallel;

import com.pages.GooglePage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GooglePageSteps {

	private GooglePage googlePage = new GooglePage(DriverFactory.getDriver());

	@Given("user is on google page")
	public void userIsOnGooglePage() {

		googlePage.gotoURL("https://google.co.in");
		
	}

	@When("user enter {string} in search text box")
	public void userEnterInSearchTextBox(String arg0) {
	}
}
