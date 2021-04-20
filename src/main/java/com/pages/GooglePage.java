package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@name='q']")
	WebElement googleSearchField;

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


	


}
