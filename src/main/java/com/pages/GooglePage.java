package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@name='q']")
	WebElement googleSearchField;

	private By dropdownList = By.xpath("//ul[@role='listbox']//li");

	@FindBy(xpath = "//link[@href='https://www.flipkart.com/']/parent::div//h3[contains(text(),'Flipkart')]")
	WebElement flipkartLink;


	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void gotoURL(String url){
		driver.get(url);
	}

	public void setGoogleSearchField(String value){
		googleSearchField.sendKeys(value);
	}

	public void printListOfDropDown(){

		List<WebElement> completeList = driver.findElements(dropdownList);

		for (WebElement ele: completeList
			 ) {
			System.out.println(ele.getText());
		}

		googleSearchField.sendKeys(Keys.RETURN);
	}

	public void clickOnFlipkartLink(){
		flipkartLink.click();
	}

}
