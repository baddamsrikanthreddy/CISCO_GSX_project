package com.cisco.gsx.reports;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class IdeabytesListener extends TestListenerAdapter {

	public IdeabytesListener() {
		super();
	}

	public static List<String> passedTests = new LinkedList<String>();
	public static List<String> failedTests = new LinkedList<String>();
	public static List<String> skippedTests = new LinkedList<String>();
	public static List<Object[]> passedParametervalues = new LinkedList<Object[]>();
	public static List<Object[]> failedParametervalues = new LinkedList<Object[]>();
	public static List<Object[]> skippedParametervalues = new LinkedList<Object[]>();
	public static List<String> passedClassNames = new LinkedList<String>();
	public static List<String> failedClassNames = new LinkedList<String>();
	public static List<String> skippedClassNames = new LinkedList<String>();
	public static List<String> passedLogFiles = new LinkedList<String>();
	public static List<String> failedLogFiles = new LinkedList<String>();
	public static List<String> skippedLogFiles = new LinkedList<String>();
	private static int count = 1;
	private long startTime;
	private long endTime;
	private IdeabytesReport q2oReport = new IdeabytesReport();
	public static List<String> failedTestCaseNames = new LinkedList<String>();
	public static List<String> passedTestCaseNames = new LinkedList<String>();
	public static List<String> skippedTestCaseNames = new LinkedList<String>();

	// End

	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("entered onstart");
		startTime = System.currentTimeMillis();
		// q2oTestDataMap = DBUtill.getQ2oTestData();
		String path = System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "reports";
		File file = new File(path);
		if (file.exists()) {
			q2oReport.setReportDirPath(path);
		} else {
			if (file.mkdir()) {
				q2oReport.setReportDirPath(path);
			}
		}
		countExecution();
	}

	public void countExecution() {
		try {
			count = 1;
			String reportsDirectoryPath = IdeabytesReport.getReportDirPath();
			File dir = new File(reportsDirectoryPath);
			if (!dir.exists()) {
				// create reports folder
				dir.mkdir();

				// Create logs folder
				String directoryPath = reportsDirectoryPath
						+ System.getProperty("file.separator") + "logs";
				dir = new File(directoryPath);
				dir.mkdir();

				// Create images folder
				directoryPath = reportsDirectoryPath
						+ System.getProperty("file.separator") + "images";
				dir = new File(directoryPath);
				dir.mkdir();
				// copy logo
				String surFile = System.getProperty("user.dir")
						+ System.getProperty("file.separator") + "images"
						+ System.getProperty("file.separator") + "logo.jpeg";
				String desFile = reportsDirectoryPath
						+ System.getProperty("file.separator") + "images"
						+ System.getProperty("file.separator") + "logo.jpeg";
				;
				IdeabytesReport.copyFile(surFile, desFile);

				// Create css folder
				directoryPath = reportsDirectoryPath
						+ System.getProperty("file.separator") + "css";
				dir = new File(directoryPath);
				dir.mkdir();
				// copy css template
				surFile = System.getProperty("user.dir")
						+ System.getProperty("file.separator") + "css"
						+ System.getProperty("file.separator") + "style.css";
				desFile = reportsDirectoryPath
						+ System.getProperty("file.separator") + "css"
						+ System.getProperty("file.separator") + "style.css";
				;
				IdeabytesReport.copyFile(surFile, desFile);
			}

			String path = new File("").getAbsolutePath();
			String projectName = path.substring(path.lastIndexOf("\\") + 1);
			String execution = IdeabytesReport.getReportDirPath()
					+ System.getProperty("file.separator")
					+ "Suite Execution Details.txt";
			File exe = new File(execution);
			if (!exe.exists()) {
				exe.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(exe, "rws");
			raf.seek(0);
			String str = "";
			while ((str = raf.readLine()) != null) {
				if (str.contains(projectName)) {
					count++;
				}
			}
			IdeabytesReport.count1 = count;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		q2oReport.createlogfile(result.getName(), result.getTestClass()
				.getName(), count);
		// Q2oReports.addOldStepsToLog();- multypart purpose
		count++;
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		Object[] param = tr.getParameters();
		String testCaseName = "test2";// ((Q2oDTO)param[0]).getTestCaseName();
		q2oReport.addTestCaseDetailsToLogfile(tr.getMethod().getRealClass()
				.getName(), tr.getName(), testCaseName);
		q2oReport.closewriter();
		failedTests.add(tr.getName());
		failedParametervalues.add(tr.getParameters());
		failedClassNames.add(tr.getMethod().getRealClass().getName());
		failedTestCaseNames.add(testCaseName);
		failedLogFiles.add(IdeabytesReport.fileName);
		System.out
				.println("***************************** FAILED        *****************************");
		// DBUtill.addLogResultToMap(tr.getParameters(), "FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// Object[] param = tr.getParameters();
		String testCaseName = "test";// ((Q2oDTO)param[0]).getTestCaseName();
		// r.addExecutionTimetoReport();
		q2oReport.closewriter();
		skippedTests.add(tr.getName());
		skippedParametervalues.add(tr.getParameters());
		skippedClassNames.add(tr.getMethod().getRealClass().getName());
		skippedTestCaseNames.add(testCaseName);
		skippedLogFiles.add(IdeabytesReport.fileName);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		Object[] param = tr.getParameters();
		String testCaseName = "test";// ((Q2oDTO)param[0]).getTestCaseName();
		q2oReport.addTestCaseDetailsToLogfile(tr.getMethod().getRealClass()
				.getName(), tr.getName(), testCaseName);
		q2oReport.closewriter();
		passedTests.add(tr.getName());
		passedParametervalues.add(tr.getParameters());
		passedClassNames.add(tr.getMethod().getRealClass().getName());
		passedLogFiles.add(IdeabytesReport.fileName);
		passedTestCaseNames.add(testCaseName);
		System.out
				.println("***************************** PASSED        *****************************");
		// DBUtill.addLogResultToMap(tr.getParameters(), "PASSED");
	}

	@Override
	public void onFinish(ITestContext testContext) {

		System.out
				.println("*****************************  onFinish method   *****************************");

		try {

			// DBUtill.updateTestResults(q2oResultMap);
			tearDown();
			if (failedTests.size() == 0 && passedTests.size() == 0
					&& skippedTests.size() == 0)
				return;
			q2oReport.after();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {

		// q2oTestDataMap.clear();
		// q2oResultMap.clear();
		endTime = System.currentTimeMillis();
		long timeMillis = endTime - startTime;
		long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		long timeMints = TimeUnit.MILLISECONDS.toMinutes(timeMillis);
		long timeHours = TimeUnit.MILLISECONDS.toHours(timeMillis);
		System.out.println("Time taken to execute all test cases : "
				+ "Seconds :" + timeSeconds + " Mints : " + timeMints
				+ " Hours : " + timeHours);
	}

}
