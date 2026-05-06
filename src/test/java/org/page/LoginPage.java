package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	@FindBy(name = "name")
	private WebElement userName;

	@FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")
	private WebElement email;

	@FindBy(xpath=("//button[text()='Signup']"))
	private WebElement sign;
	
	 @FindBy(css="a[href='/products']")
	    private WebElement productsLink1;
	 
	  
	 @FindBy(css=".productinfo a[data-product-id='1']")
	 private WebElement addToCartFirstProduct;
	 

	public LoginPage() {
		PageFactory.initElements(getDriver(),this);
	}

	public void login(String uname, String emai) {
		waitForElement(userName).sendKeys(uname);
		waitForElement(email).sendKeys(emai);
     	waitAndClick(sign);
	}
	public void clickProducts() {
		waitAndClick(productsLink1);
	}
	
	public void addToCartFirstProduct() {
		waitAndClick(addToCartFirstProduct);


	}
	
	public void winMax() {
	getDriver().manage().window().maximize();
	waitAndClick(sign);
	}


}