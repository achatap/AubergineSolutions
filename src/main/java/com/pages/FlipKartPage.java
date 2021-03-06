package com.pages;

import com.qa.util.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FlipKartPage {

	private WebDriver driver;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement closeButton;
	
	@FindBy(xpath = "//div[@class='xtXmba' and text()='Appliances']")
	WebElement appliancesLink;

	@FindBy(xpath = "//a[text()='Air Conditioners']")
	WebElement airConditioners;

	@FindBy(xpath = "//a[text()='Window ACs']")
	WebElement windowAcs;

	@FindBy(xpath = "//a[@class='_11o22n _87aCMT']")
	WebElement compareButton;

	@FindBy(xpath = "//div[@class='_1YokD2 _3Mn1Gg']")
	WebElement productListAll;

	@FindBy(xpath = "//div[@id='fk-compare-page']")
	WebElement comparePage;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCart;

	@FindBy(xpath = "//img[@alt='Flipkart']")
	WebElement logo;

	@FindBy(xpath = "//a[@class='_3SkBxJ']")
	WebElement cardButton;

	@FindBy(xpath = "//input[@placeholder='Enter delivery pincode']")
	WebElement enterPinCode;

	@FindBy(xpath = "//span[@class='UgLoKg']")
	WebElement checkForPinCode;

	private By isDeliveryMessage= By.xpath("//div[@class='_1tBBEs']");

	private By listOfProduct = By.xpath("//div[@class='col col-3-12 _1Z-FPJ']");

	private By compareListElements = By.xpath("//div[@class='_3PzNI-']");

	@FindBy(xpath = "//div[@class='_12cXX4']")
	WebElement deliverToBox;

	public FlipKartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void closePopUp(){
		closeButton.click();
	}
	
	public void hoverOverAppliances(){
		Actions actions = new Actions(driver);

		WaitUtility.waitForConditions(driver,appliancesLink);
		actions.moveToElement(appliancesLink).build().perform();

		WaitUtility.waitForConditions(driver,airConditioners);
		actions.moveToElement(airConditioners).build().perform();

		WaitUtility.waitForConditions(driver,windowAcs);
		actions.moveToElement(windowAcs).click().build().perform();

	}

	public void selectToCompare(){

		WaitUtility.waitForConditions(driver, productListAll);

		List<WebElement> listOfCompareEle = driver.findElements(compareListElements);
//
//		System.out.println(listOfCompareEle.size()+ ">>>>>>>>>>>>");
//
//		for(int i=0; i< listOfCompareEle.size();i++){
//			if(i==1 || i==2 || i==5){
//				listOfCompareEle.get(i).click();
//			}
//		}


		listOfCompareEle.get(1).click();
		listOfCompareEle.get(2).click();
		listOfCompareEle.get(5).click();

	}

	public void clickOnCompareButton(){
		compareButton.click();

	}

	public void getNameAndPriceOfProduct(){

		WaitUtility.waitForConditions(driver,comparePage);
		WaitUtility.apply(driver);
//		driver.navigate().refresh();
//		driver.get(driver.getCurrentUrl());
//		WaitUtility.apply(driver);
//		WaitUtility.waitForConditions(driver,comparePage);

//		WebElement ele= driver.findElement(By.xpath("//div[@class='col col-3-12 _1Z-FPJ']"));
//
//		WaitUtility.waitForConditions(driver,ele);


		List<WebElement> productList = driver.findElements(listOfProduct);

//		System.out.println(">>>>>>>>>>>>>>>>>>>>"+productList.size());

		System.out.println("Name " +productList.get(0).getText()+ " Rs."+ productList.get(3).getText().replace("???","@").split("@")[1]);
		System.out.println("Name " +productList.get(1).getText()+ " Rs."+ productList.get(4).getText().replace("???","@").split("@")[1]);
		System.out.println("Name " +productList.get(2).getText()+ " Rs."+ productList.get(5).getText().replace("???","@").split("@")[1]);

	}

	public void add3ProductToCard(){

		WaitUtility.waitForConditions(driver,comparePage);
		List<WebElement> productList = driver.findElements(By.xpath("//a[@class='_3L_M2k']"));
		ArrayList<String> url= new ArrayList<>();
		int i=0;
		for (WebElement ele: productList
			 ) {
			url.add(ele.getAttribute("href"));
			i++;
			if(i==3) break;
		}
//		System.out.println(url);

		for (String product: url
			 ) {
			driver.navigate().refresh();
			driver.get(product);
			WaitUtility.waitForConditions(driver,addToCart);
			addToCart.click();
			driver.navigate().refresh();
			cardButton.click();
		}
	}

	public void clickOnCartIcon(){
		WaitUtility.waitForConditions(driver,logo);
		logo.click();
		WaitUtility.waitForConditions(driver,cardButton);
		cardButton.click();
		driver.navigate().refresh();

	}

	public void setEnterPinCode(String pincode){
		WaitUtility.waitForConditions(driver,enterPinCode);
		enterPinCode.sendKeys(pincode);
	}

	public void verifyPinCode(){
		WaitUtility.waitForConditions(driver,checkForPinCode);

		checkForPinCode.click();
	}

	public void printMessageOfDelivery(){

		List<WebElement> message = driver.findElements(isDeliveryMessage);

		for (WebElement ele: message
			 ) {
			System.out.println(ele.getText());
		}

	}

	public void clickOnDeliverTo(){
		WaitUtility.waitForConditions(driver,deliverToBox);
		deliverToBox.click();
	}




}
