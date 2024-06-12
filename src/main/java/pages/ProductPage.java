package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import utils.Utils;

public class ProductPage extends BasePage {
	protected static Logger log;
	public ProductPage() {
		log = LogManager.getLogger();
	}
	
	By addToCartButton = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
	By alertText = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div[2]");
	By productTitle = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span");
	By specificationText = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[8]/div[5]/div/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[2]/ul/li");
	By ratingAndReviews = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[8]/div[7]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div[1]");
	
	
	public String getProductTitle() {
		Utils.waitForElement(driver, productTitle, 20);
		return driver.findElement(productTitle).getText();
	}
	
	public String getSpecefication() {
		return driver.findElement(specificationText).getText();
	}
	
	public String getRating() {
		return driver.findElement(ratingAndReviews).getText();	
	}
	
	public void addToCart() {
		Utils.waitForElement(driver, addToCartButton, 20);
		Utils.clickElement(driver, addToCartButton);
		Utils.waitForText(driver, By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div/span"), "PRICE",20);
	}
	
	
	
}
