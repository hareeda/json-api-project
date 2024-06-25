package com.ust.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ust.utils.ExtentManager;

import io.restassured.response.Response;

public class ExtentReportsListener implements ITestListener {
	
	public ExtentReports extent;
	public ExtentTest test;
	private static Response response; // Assuming you store response here

    public static void setResponse(Response response) {
        ExtentReportsListener.response = response;
    }

    // You can create methods to retrieve and use the stored response
    public static Response getResponse() {
        return response;
    }

	public void onStart(ITestContext context) {
		try {
			extent = ExtentManager.createInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case passed");
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		if (response != null) {
            test.info("Response Status Code: " + response.getStatusCode());
            test.info("Response Body: " + response.getBody().asString());
            logResponseTime();
        }
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		if (response != null) {
			test.info("Response Status Code: " + response.getStatusCode());
			test.info("Response Body: " + response.getBody().asString());
			logResponseTime();
        }
		test.log(Status.FAIL, "Test case failed due to: " + result.getThrowable()); // Logging the reason for testcase
		// failure.
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case SKIPPED");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	private void logResponseTime() {
        if (response != null) {
            long responseTime = response.getTime();
            test.info("Response Time: " + responseTime + " ms");
        }
    }

}