import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;


public class HomePageTest extends BasePage{
	
	protected static Logger log = LogManager.getLogger();
	
	@Test
	public void homePageLogo() {
		String title = driver.getTitle();
		Assert.assertEquals(title, testData.get(1)[4]);
	}
	
	@Test
	public void homePageLogoFail() {
		String title = driver.getTitle();
		Assert.assertEquals(title, testData.get(2)[4]);
	}
	
	@Test
	public void selectCategory() {
		HomePage homePage= new HomePage();
		homePage.moveToFashionCategory();
		Assert.assertTrue(driver.getCurrentUrl().contains("/watches/wrist-watches"));
	}
	
	@Test
	public void checkMore() {
		HomePage homePage = new HomePage();
		String heading = homePage.getHeading();
		homePage.clickMoreButton();
		String moreHeading = homePage.getMoreHeading();
		Assert.assertEquals(heading.toLowerCase(), moreHeading.toLowerCase());
	}
	
	@Test
	public void giftCardPage() {
		HomePage homePage = new HomePage();
		homePage.hoverLoginMoveToGiftCards();
		homePage.moveToForm();
		homePage.fillUpForm();
		Assert.assertEquals(driver.getTitle(), testData.get(19)[4]);
	}
	
	@Test
	public void login(){
		HomePage homePage = new HomePage();
		homePage.moveToLogin(testData.get(20)[4]);
	}
	
}
