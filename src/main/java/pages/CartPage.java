package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class CartPage extends BasePage {

	protected static Logger log;
	
	public CartPage() {
		log = LogManager.getLogger();
	}
	
	By removeFromCartButton = By.className("sBxzFz");
	By removeConfirmation = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]");
	By missingCartItems = By.className("s2gOFd");
	By counter = By.className("p6sArZ");
	By addCounter = By.className("LcLcvv");
	By counterUpdateToast = By.className("eIDgeN"); 
	By orderButton = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[3]/div/form/button");
	
	public String removeFromCart() {
		
		log.info("removing from cart");

		WebElement removeButton = driver.findElements(removeFromCartButton).get(1);

		log.info(removeButton.isEnabled());
		
		//When Actions didnt work, JSExecutor did
		//Utils.scrollToElement(driver, removeFromCartButton);
		//removeButton.click();
		//Utils.clickElement(driver, removeButton);
		
		Utils.clickElementJSExec(driver, removeButton);
		
		log.info("Clicked on Remove");
		
		WebElement removeConfirmationButton = Utils.waitForElement(driver, removeConfirmation, 20);
		log.info("Waiting complete on Remove confirmation");
		
		Utils.clickElement(driver, removeConfirmationButton);
		
		log.info("Clickedon  Remove confirmation");
		return Utils.waitForElement(driver, missingCartItems, 10).getText();
	}
	
	public String getCount() {
		return driver.findElement(counter).getAttribute("value");				
	}
	public void updateCounter() {
		WebElement e = driver.findElements(addCounter).get(1);
		Utils.clickElementJSExec(driver, e);
		log.info("updated counter");
		Utils.waitForElement(driver, counterUpdateToast, 10);
	}
	
	public void confirmOrder() {
		Utils.clickElement(driver, orderButton);
	}
	
}
