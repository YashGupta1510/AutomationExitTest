package listenerUtils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import pages.BasePage;
import utils.Utils;

public class TestStatusListener extends BasePage implements ITestListener{
	
	protected static Logger log = LogManager.getLogger();
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		log.error( methodName+ " Test Failed");
		extentTest.fail(methodName+ " Test Failed");
		try {
			Utils.takeSnapshot(driver, methodName);
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(
					"..\\screenshots\\"+ methodName +".png").build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName();
		log.info( methodName+ " Test Passed");
		extentTest.pass(methodName+ " Test Passed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();
		log.info( methodName+ " Test Skipped");
		extentTest.pass(methodName+ " Test Skipped");
	}
	
}
