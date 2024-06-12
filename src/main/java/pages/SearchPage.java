package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utils;


public class SearchPage  extends BasePage{
	protected static Logger log;
	public SearchPage() {
		log = LogManager.getLogger();
	}
	
	By resultProduct = By.className("_75nlfW");
	By resultText = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span");
	By filterTag = By.className("_6tw8ju");
	By noResultsFount = By.className("BHPsUQ");
	By minAmtDropdown = By.className("Gn+jFg");
	By firstProdAmt = By.className("Nx9bqj");
	By sortLowToHigh = By.className("zg-M3Z");
	By clearFilter = By.className("aOfogh");
	By pagination = By.className("cn++Ap");
	By pageLabel = By.className("_1G0WLw");
	
	String originalWindow ;
	
	public void clickOnProduct() {
		Utils.waitForElement(driver, resultProduct, 20);
		Utils.clickElement(driver, resultProduct);
		originalWindow = driver.getWindowHandle();
		switchToNewTab(originalWindow);
	}
	
	public void selectFilterByBrand(String brand) {
		Utils.clickElement(driver, By.cssSelector("div[title=\""+brand+"\"]"));
		Utils.waitForElement(driver, filterTag, 20);
	}
	
	public String getResultString() {
		Utils.waitForElement(driver, resultText, 20);
		String res = driver.findElement(resultText).getText();
		log.info(res);
		return res;
	}
	
	public Boolean getNoResultText() {
		return Utils.waitForText(driver, noResultsFount, "Sorry, no results found!", 20);
	}
	
	public void selectMinAmt(String amt) {
		Select dropdown = new Select(driver.findElement(minAmtDropdown));
		dropdown.selectByValue(amt);
		Utils.waitForElement(driver, filterTag, 10);
	}
	 
	public String getFirstProdPrice() {
		return driver.findElements(firstProdAmt).get(0).getText().substring(1).replace(",", "");
	}
	
	public void sortLtoH() {
		WebElement e = driver.findElements(sortLowToHigh).get(2);
		Utils.clickElement(driver, e);
		log.info("Waiting for Page to load and show sorted");
		while(!(e.getAttribute("class").contains("_0H7xSG"))) {
		}
	}
	
	public void clearFilters() {
		Utils.clickElement(driver, clearFilter);
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(clearFilter));
	}
	
	public void changePage() {
		Utils.clickElement(driver, driver.findElements(pagination).get(1));
		Utils.waitForText(driver, pageLabel, "Page 2 ", 20);
	}
	
}
