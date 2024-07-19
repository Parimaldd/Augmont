package com.inetBanking.utilities;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Report extends ExtentReport implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("On test Failure :" + result.getName());
		try {
			getScreenShot(driver, "my report");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
