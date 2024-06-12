import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class CartPageTest extends BasePage{
	

	@Test
	public void addToCartTest() {
		
		String product = testData.get(9)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		String resultString = searchPage.getResultString();
		Assert.assertTrue(resultString.contains(product));
		searchPage.clickOnProduct();
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");
		
		ProductPage productPage = new ProductPage();
		productPage.addToCart();
		
		extentTest.info("Clicked ATC on new TAB");
		log.info("Clicked ATC on new TAB");
		
		Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
	}
	
	@Test
	public void removeFromCartTest() {
		String product = testData.get(9)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		String resultString = searchPage.getResultString();
		Assert.assertTrue(resultString.contains(product));
		searchPage.clickOnProduct();
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");
		
		ProductPage productPage = new ProductPage();
		productPage.addToCart();
		
		extentTest.info("Clicked ATC on new TAB");
		log.info("Clicked ATC on new TAB");
		CartPage cartPage = new CartPage();
		String emptyCartText = cartPage.removeFromCart();
		
		Assert.assertEquals(emptyCartText, "Missing Cart items?");
	}

	@Test
	public void updateCartCount() {

		String product = testData.get(9)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		
		searchPage.clickOnProduct();
		
		ProductPage productPage = new ProductPage();
		productPage.addToCart();
		
		extentTest.info("Clicked ATC on new TAB");
		log.info("Clicked ATC on new TAB");
		
		CartPage cartPage = new CartPage();
		int initialCount = Integer.parseInt(cartPage.getCount());
		cartPage.updateCounter();
		int newCount = Integer.parseInt(cartPage.getCount());
		
		Assert.assertEquals(newCount, initialCount+1);
		
	}

	@Test
	public void placeOrder() {
		String product = testData.get(9)[4];
		extentTest.info("Searching for " + product );
		log.info("Searching for " + product );
		
		HomePage homePage = new HomePage(); 
		homePage.searchForProduct(product);
		
		extentTest.info("On Search Result Page");
		log.info("On Search Result Page");
		
		SearchPage searchPage = new SearchPage();
		String resultString = searchPage.getResultString();
		Assert.assertTrue(resultString.contains(product));
		searchPage.clickOnProduct();
		extentTest.info("Opening link in new Tab");
		log.info("Opening link in new Tab");
		
		ProductPage productPage = new ProductPage();
		productPage.addToCart();
		
		extentTest.info("Clicked ATC on new TAB");
		log.info("Clicked ATC on new TAB");
		CartPage cartPage = new CartPage();
		cartPage.confirmOrder();
		
		Assert.assertEquals(driver.getTitle(), "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
	}

}
