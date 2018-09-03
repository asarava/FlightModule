package com.flight.utilties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.flight.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reportlistener extends TestBase implements ITestListener {


	protected static ExtentReports reports;

	protected static ExtentTest test;

	public void onTestStart(ITestResult result) {

		System.out.println("On Test Start");

		test = reports.startTest(result.getMethod().getMethodName());

		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "Test Started");

	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("On Test Success");

		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "Test Passed");

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("On Test Failure");

		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test Failed");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {

			FileUtils.copyFile(src, new File(currentDir + "/failurescreen/"+ result.getMethod().getMethodName() + ".png"));

			String file = test.addScreenCapture(currentDir + "/failurescreen/" + result.getMethod().getMethodName() + ".png");

			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test Failed", file);

			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test Failed", result.getThrowable().getMessage());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("On Test Skipped");

		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "Test Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("On test sucess within percentage");

	}

	public void onStart(ITestContext context) {

		System.out.println("On Start");

		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");

	}

	public void onFinish(ITestContext context) {

		System.out.println("On Finish");

		reports.endTest(test);

		reports.flush();

	}
}

