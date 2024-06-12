import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class ProductPageTest extends BasePage{

	protected static Logger log = LogManager.getLogger();
	
	@Test
	public void validateProduct() {
		String product = testData.get(6)[4];
		
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		
		searchPage.clickOnProduct();
		
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");

		ProductPage productPage = new ProductPage();
		String productTitle = productPage.getProductTitle().toLowerCase();
		Assert.assertTrue(productTitle.contains(product.toLowerCase()));
	}

	@Test
	public void validateSpecification() {
		String product = testData.get(7)[4];
		
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		
		searchPage.clickOnProduct();
		
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");

		ProductPage productPage = new ProductPage();
		String productTitle = productPage.getProductTitle().toLowerCase();
		
		extentTest.info("Product Title = "+ productTitle);
		log.info("Product Title = "+ productTitle);
		
		String modelNumber = productPage.getSpecefication().toLowerCase();
		
		extentTest.info("Model number = "+ modelNumber);
		log.info("Model Number = "+ modelNumber);
		
		Assert.assertTrue(productTitle.contains(modelNumber));
	}

	@Test
	public void validateRatings() {
		String product = testData.get(8)[4];
		
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		
		searchPage.clickOnProduct();
		
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");

		ProductPage productPage = new ProductPage();
		String rating = productPage.getRating();
		extentTest.info("Rating  = "+ rating);
		log.info("Rating  = "+ rating);
		
		Assert.assertNotNull(rating);
	}
	
	
}
