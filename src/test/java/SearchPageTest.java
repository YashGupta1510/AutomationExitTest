import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.SearchPage;

public class SearchPageTest extends BasePage{
	
	protected static Logger log = LogManager.getLogger();
	
	
	@Test
	public void searchForProduct() {
		String product = testData.get(3)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		SearchPage searchPage = new SearchPage();
		String resultString = searchPage.getResultString();
		
		Assert.assertTrue(resultString.contains(product));
	}
	
	@Test
	public void sortLowToHigh() {
		String product = testData.get(3)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		SearchPage searchPage = new SearchPage();
		String sinitialPrice = searchPage.getFirstProdPrice();
		int initialPrice = Integer.parseInt(sinitialPrice);
		searchPage.sortLtoH();
		log.info("Clicked on sort and price = "+initialPrice);
		extentTest.info("Clicked on sort and price = "+initialPrice);
		String sNewPrice = searchPage.getFirstProdPrice();
		int newPrice = Integer.parseInt(sNewPrice);
		Assert.assertTrue(newPrice<initialPrice);
		
	}
	
	@Test
	public void filterByBrand() {
		String product = testData.get(3)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		String resultString = searchPage.getResultString();
		Assert.assertTrue(resultString.contains(product));
		
		String brand = testData.get(5)[4];
		extentTest.info("Selecting Filter By Brand = "+brand);
		log.info("Selecting Filter By Brand = "+brand);
		searchPage.selectFilterByBrand(brand);
		
		searchPage.clickOnProduct();
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");
		
		Assert.assertTrue(driver.getTitle().contains("SAMSUNG"));
	}

	@Test
	public void filterByAmount() {
		String product = testData.get(3)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		String resultString = searchPage.getResultString();
		Assert.assertTrue(resultString.contains(product));
		
		String amt = testData.get(13)[4];
		extentTest.info("changing min amt = "+amt);
		log.info("changing min amt = "+amt);
		searchPage.selectMinAmt(amt);
		
		String sPrice = searchPage.getFirstProdPrice();
		int expectedPrice = Integer.parseInt(amt);
		int price = Integer.parseInt(sPrice);
		
		Assert.assertTrue(price>expectedPrice);
	}

	@Test
	public void invalidSearch() {
		String product = testData.get(4)[4];
		extentTest.info("Searching for invalid Text = " + product );
		log.info("Searching for invalid Text = " + product );
		
		HomePage homePage = new HomePage();
		homePage.searchForProduct(product);
		
		SearchPage searchPage = new SearchPage();
		
		Assert.assertTrue(searchPage.getNoResultText());
	}
	
	@Test
	public void clearFilterTest() {
		String product = testData.get(3)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		
		String brand = testData.get(5)[4];
		searchPage.selectFilterByBrand(brand);
		searchPage.clearFilters();
		Assert.assertTrue(true);
	}
	
	@Test
	public void checkPagination() {
		String product = testData.get(3)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		int lastProductInitial = Integer.parseInt(searchPage.getResultString().split(" ")[3]);
		searchPage.changePage();
		int newFirstProduct = Integer.parseInt(searchPage.getResultString().split(" ")[1]);
		Assert.assertEquals(newFirstProduct - 1 , lastProductInitial);
		
	}
	
}
