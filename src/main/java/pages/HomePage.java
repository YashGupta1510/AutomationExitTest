package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.Utils;

public class HomePage extends BasePage{
	protected static Logger log;
	public HomePage() {
		log = LogManager.getLogger();
	}
	
	By searchTextField = By.cssSelector("input[title=\"Search for Products, Brands and More\"]");
	
	By searchButtonField = By.cssSelector("button[title=\"Search for Products, Brands and More\"]");
	By fashionCategory = By.className("_1XjE3T");
	By watchButton = By.linkText("Watches and Accessories");
	By firstHeading = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[3]/div/div/div/div/div/div/a/div/div[1]/div");
	By moreButton = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[3]/div/div/div/div/div/div/a/div/div[2]/div");
	By moreHeading = By.className("lF7HP0");
	
	By emailInput = By.cssSelector("input[name=\"recipient-email[]\"]");
	By nameInput = By.cssSelector("input[name=\"recipient-name[]\"]");
	By button = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/div/div/div/div[3]/div/div[2]/div/div[2]/div/div/form/div[3]/button");
	By loginHover = By.className("_1Us3XD");
	public void searchForProduct(String product) {
		driver.findElement(searchTextField).sendKeys(product);
		Utils.clickElement(driver, searchButtonField);
	}
	
	public void moveToFashionCategory() {
		WebElement fashion = driver.findElements(fashionCategory).get(2);
		Utils.clickElement(driver, fashion);
		Utils.waitForElement(driver, watchButton, 10);
		Utils.clickElement(driver, watchButton);
	}
	
	public String getHeading() {
		return driver.findElement(firstHeading).getText();
	}
	
	public void clickMoreButton() {
		Utils.clickElement(driver, moreButton);
	}
	
	public String getMoreHeading() {
		return driver.findElement(moreHeading).getText();
	}
	
	public void hoverLoginMoveToGiftCards() {
		Actions actions = new Actions(driver);
		WebElement e = driver.findElement(loginHover);
		actions.moveToElement(e).perform();
		actions.moveToElement(driver.findElement(By.cssSelector("a[title=\"Gift Cards\"]"))).click().perform();
	}
	
	public void moveToForm() {
		Utils.clickElement(driver, driver.findElement(By.className("wvIX4U")));
		log.info(driver.getTitle());
	}
	
	public void fillUpForm() {
		driver.findElement(emailInput).sendKeys("test@test.com");
		driver.findElement(nameInput).sendKeys("Test test");
		Select select = new Select(driver.findElement(By.className("OZuttk")));
		select.selectByValue(" 10000");
		Utils.clickElementJSExec(driver, driver.findElement(button));
		Utils.waitForElement(driver, By.className("LtTRsN"), 20);
	}

	public void moveToLogin(String number) {
		Utils.clickElement(driver, loginHover);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys(number);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
	}

}
