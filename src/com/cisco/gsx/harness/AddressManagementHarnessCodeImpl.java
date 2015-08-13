package com.cisco.gsx.harness;

import org.testng.Assert;

import com.cisco.gsx.utilities.CommonUtil;

public class AddressManagementHarnessCodeImpl {

	private String testCaseName = null;
	private boolean Q2O_ADDRESS_MGMT_ADDLINE = false;

	public void setUp(String testcaseName) {
		System.out.println("=============================" + testcaseName
				+ " Started =============================");

		this.testCaseName = testcaseName;
		String browserType = "firefox";
		System.out.println("DB - BrowserType" + browserType);
		CommonUtil.openBrowser(browserType);
	}

	public void tearDown(String testcaseName) {

		CommonUtil.closeBrowser();
		System.out.println("=============================" + testcaseName
				+ " Ended =============================");
	}
}
