package com.pages;

import com.qa.util.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	private By listOfProduct = By.xpath("//div[@class='col col-3-12 _1Z-FPJ']");

	private By compareListElements = By.xpath("//div[@class='_3PzNI-']");

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

		List<WebElement> productList = driver.findElements(listOfProduct);

		System.out.println("Name " +productList.get(0).getText()+ " Rs."+ productList.get(3).getText().replace("₹","@").split("@")[1]);
		System.out.println("Name " +productList.get(1).getText()+ " Rs."+ productList.get(4).getText().replace("₹","@").split("@")[1]);
		System.out.println("Name " +productList.get(2).getText()+ " Rs."+ productList.get(5).getText().replace("₹","@").split("@")[1]);

	}


}
