package org.base;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public void getBrowser(String browserType) {
		try {
			System.out.println(">>> Starting browser:"+browserType);
			switch (browserType.toLowerCase().trim()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				System.out.println(">>> Chrome launched");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
//				System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
				driver.set(new FirefoxDriver());
				System.out.println(">>> Firefox launched");
				break;
			case "edge":
//				WebDriverManager.edgedriver().setup();
				System.setProperty("webdriver.edge.driver","C:\\Drivers\\msedgedriver.exe");
				driver.set(new EdgeDriver());
				break;		
				
				default:
					throw new RuntimeException("Invalid browser:"+browserType);
			}
		} catch (Exception e) {
			System.out.println(">>> ERROR for"+ browserType+":"+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Browser launch failed",e);
		}

	}

	public void launchURL(String url) {
		getDriver().get(url);
		
	}
	
	
	
	public void getURL(String url) {
		getDriver().get(url);
	}

	public void winMax() {
		getDriver().manage().window().maximize();
	}
	
	public void closeBrowser() {
		if(getDriver()!=null) {
			getDriver().quit();
			driver.remove();
		}
		
	}
	
	
	

	public String getTitle() {
		return getDriver().getTitle();
	}

	public void setWindowSize(int i, int j) {
		Dimension d = new Dimension(i, j);
		getDriver().manage().window().setSize(d);
	}

	public String getpageSource() {
		return getDriver().getPageSource();
	
	}
	public WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitAndClick(WebElement element) {
		waitForElement(element).click();
	}





}