package com.cisco.gsx.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IdeabytesReport {

	private static BufferedWriter writer = null;

	public Date StartDate = null;
	public Date EndDate = null;
	int iterationValue = 0;
	static int counter = 1;
	String path12 = System.getProperty("user.dir");
	String projectName = path12.substring(path12.lastIndexOf("\\") + 1);
	Double totalTests = 0.0;
	int totalPassedTests = 0;
	int totalFailedTests = 0;
	int totalSkippedTests = 0;
	Double[] totalTest;
	int[] passedTest;
	int[] failedTest;
	int[] skippedTest;
	public static String fileName = null;

	private static String reportsDirectoryPath = null;
	public static String errorMsg = "";
	public static String logMsg = "";

	protected static int count1 = 1;
	public static int imageCounter;
	// New variables
	public static long stepStartTime = 0;
	public static double totalTimeTaken = 0.00;
	public static double doubleTime = 0.00;
	public static String imageName;
	public static String[] testCaseDeatils = null;
	private static List<String[]> DBlogs = new LinkedList<String[]>();
	// End
	List<String> AllTest = new LinkedList<String>();

	public IdeabytesReport() {
		StartDate = new Date();

	}

	public void setReportDirPath(String path) {
		reportsDirectoryPath = path;
	}

	public static String getReportDirPath() {
		return reportsDirectoryPath;
	}

	public static void clearErrorMsg() {
		errorMsg = "";
		logMsg = "";
	}

	public static String getErrorMsg() {
		return errorMsg;
	}

	public static void setErrorMsg(String error) {
		errorMsg = error;
	}

	public static void status(int i) throws IOException {
		if (i == 1) {
			writer.write("<td align='center'>");
			writer.write("<span style=' color: chartreuse'>Passed</span>");
			writer.write("</td>");

		} else {
			screenShotHyperLink("", count1);
			errorMsg = errorMsg + ";" + logMsg;
		}
		writer.write("</tr>");
	}

	public static void screenShotHyperLink(String testName, int count) {
		try {
			String name = IdeabytesReport.fileName;
			int counter1 = IdeabytesReport.imageCounter - 1;
			name = name.substring(0, name.lastIndexOf("."));

			String path = reportsDirectoryPath
					.replace("reports", "screenshots")
					+ System.getProperty("file.separator")
					+ name
					+ counter1
					+ ".png";

			writer.write("<td align='center'>");
			writer.write("<span style=' color: Black'>" + counter + "</span>");
			writer.write("</td>");

			writer.write("<td align='center'>");
			writer.write("<span style=' color: Red'>"
					+ IdeabytesReport.getErrorMsg() + "</span>");
			writer.write("</td>");

			writer.write("<td align='center'>");
			writer.write("<span style=' color: Red'><a href='" + path
					+ "' >Failed</a></span>");
			writer.write("</td>");
			writer.write("</tr>");
			counter++;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void log(String msg) throws IOException {
		if (writer == null) {
			String logsDirectoryPath = reportsDirectoryPath
					+ System.getProperty("file.separator") + "logs";
			writer = new BufferedWriter(new FileWriter(new File(
					logsDirectoryPath + System.getProperty("file.separator")
							+ IdeabytesReport.fileName)));
		}

		writer.write("<tr>");
		writer.write("<td align ='center'>" + counter);
		writer.write("</td>");
		writer.write("<td align='center'>");
		writer.write(msg);
		writer.write("</td>");
		counter++;

		logMsg = msg;
	}

	public void readLog(BufferedWriter bw) {
		try {
			int i = 0;
			String execution = reportsDirectoryPath
					+ "/Suite Execution Details.txt";

			File exe = new File(execution);
			RandomAccessFile raf = new RandomAccessFile(exe, "rws");
			raf.seek(0);
			while (raf.getFilePointer() + 1 < raf.length()) {
				String str = "";
				while (true) {
					int k = raf.readByte();
					if (k == 10) {
						continue;
					} else if (k != 9) {
						str = str + (char) k;
					} else {
						break;
					}
				}
				if (str.equals(projectName)) {
					totalTest[i] = raf.readInt() + 0.0;
					passedTest[i] = raf.readInt();
					failedTest[i] = raf.readInt();
					skippedTest[i] = raf.readInt();
					totalTests = totalTests + totalTest[i];
					totalPassedTests = totalPassedTests + passedTest[i];
					totalFailedTests = totalFailedTests + failedTest[i];
					totalSkippedTests = totalSkippedTests + skippedTest[i];
					i++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void addToLog() {
		try {
			String path = System.getProperty("user.dir");
			String projectName = path.substring(path.lastIndexOf("\\") + 1);
			String execution = reportsDirectoryPath
					+ "/Suite Execution Details.txt";

			File exe = new File(execution);
			if (!exe.exists()) {
				exe.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(exe, "rws");
			raf.seek(raf.length());
			raf.writeBytes(projectName + "\t");
			Double totalTest = IdeabytesListener.passedTests.size()
					+ IdeabytesListener.failedTests.size()
					+ IdeabytesListener.skippedTests.size() + 0.0;
			int passedTests = IdeabytesListener.passedTests.size();
			int failedTests = IdeabytesListener.failedTests.size();
			int skippedTests = IdeabytesListener.skippedTests.size();
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			Double passPer = (passedTests / totalTest) * 100;
			passPer = Double.parseDouble(decimalFormat.format(passPer));
			Double failedPer = (failedTests / totalTest) * 100;
			failedPer = Double.parseDouble(decimalFormat.format(failedPer));
			Double skippedPer = (skippedTests / totalTest) * 100;
			skippedPer = Double.parseDouble(decimalFormat.format(skippedPer));
			raf.writeInt(totalTest.intValue());
			raf.writeInt(passedTests);
			raf.writeInt(failedTests);
			raf.writeInt(skippedTests);
			/*
			 * raf.writeInt(passPer.intValue());
			 * raf.writeInt(failedPer.intValue());
			 * raf.writeInt(skippedPer.intValue());
			 */
			raf.writeBytes("\n");

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void mainReport(int count) {
		try {
			String report = reportsDirectoryPath
					+ System.getProperty("file.separator") + "mainReport.html";
			File rep = new File(report);
			if (!rep.exists()) {
				rep.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(rep));
			bw.write("<html lang='en'>");
			bw.newLine();
			bw.write("<head>");
			bw.write("<meta charset='utf-8'>");
			bw.write("<meta content='width=device-width' name='viewport'>");
			bw.write("<title>Dash Board Summury</title>");

			// ----------------Change START---------------------------
			/*
			 * bw.write("<link href='" + System.getProperty("user.dir") +
			 * "\\css\\style.css' rel='stylesheet' type='text/css' />");
			 */bw.write("<link href='" + System.getProperty("user.dir")
					+ "\\css\\globals.css' rel='stylesheet' type='text/css' />");
			bw.write("<link href='" + System.getProperty("user.dir")
					+ "\\css\\grid.css' rel='stylesheet' type='text/css' />");
			bw.write("<link href='" + System.getProperty("user.dir")
					+ "\\css\\mobile.css' rel='stylesheet' type='text/css' />");
			bw.write("<link href='"
					+ System.getProperty("user.dir")
					+ "\\css\\responsive-tables.css' rel='stylesheet' type='text/css' />");
			bw.write("<link href='"
					+ System.getProperty("user.dir")
					+ "\\css\\mainreport.css' rel='stylesheet' type='text/css' />");
			// ----------------Change END---------------------------

			bw.write("</head>");
			bw.write("<body>");
			readLog(bw);
			bw.write("<div class='container'>");
			bw.write("<div class='row'>");
			bw.write("<div class='twelve columns'>");
			bw.write("<header>");
			bw.write("<div id='logo'><img alt='Ideabytes' height='74' src='"
					+ new File("").getAbsolutePath()
					+ "\\images\\logo.png' width='176'></div>");
			bw.write("<div id='rightlogo'><img alt='cisco' height='99' src='"
					+ new File("").getAbsolutePath()
					+ "\\images\\cisco.png' width='176'></div>");
			bw.write("</header>");
			bw.write("</div>");
			bw.write("</div>");
			// ----------------Change START---------------------------
			/*
			 * bw.write("<img src='" + new File("").getAbsolutePath() +
			 * "\\images\\logo.jpeg' width='200' height='80' style='margin-top:0px;' align='right'/>"
			 * );
			 */
			// bw.write("<img src='"+ new File("").getAbsolutePath()+
			// "\\images\\logo.jpeg' width='200' height='80' style='margin-top:0px;' align='right'/>");

			// -----------------Change END---------------------------
			bw.write("<div class='row'>");
			bw.write("<div class='twelve columns'>");
			bw.write("<h3>Test Suite Execution Results</h3>");
			bw.write("<h4>Test Reports</h4>");
			bw.write("</div>");
			bw.write("</div>");
			bw.write("<div class='row'>");
			bw.write("<div class='twelve columns' style='text-align: center'>");
			bw.write("<div id='psdgraphics-com-table'>");
			bw.write("<div id='psdg-middle'>");
			bw.write("<div class='psdg-left'>Test Suite</div>");
			bw.write("<div class='psdg-right'>" + projectName);
			bw.write("</div>");
			bw.write("<div class=\"psdg-left\">Total Iterations</div>");
			bw.write("<div class=\"psdg-right\">" + count + "</div>");
			bw.write("<div class=\"psdg-left\">Total Test Cases</div>");
			bw.write("<div class=\"psdg-right\">" + totalTests.intValue()
					+ "</div>");
			bw.write("<div class=\"psdg-left\">Total Passed Tests</div>");
			bw.write("<div class=\"psdg-right\">" + totalPassedTests + "</div>");
			bw.write("<div class=\"psdg-left\">Total Failed Tests</div>");
			bw.write("<div class=\"psdg-right\">" + totalFailedTests + "</div>");
			bw.write("<div class=\"psdg-left\">Total Skipped Tests</div>");
			bw.write("<div class=\"psdg-right\">" + totalSkippedTests
					+ "</div>");
			bw.write("<div class=\"psdg-left\">Pass Percent</div>");

			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			Double passPercent = (totalPassedTests / totalTests) * 100;
			passPercent = Double.parseDouble(decimalFormat.format(passPercent));
			bw.write("<div class=\"psdg-right\">" + passPercent + "%</div>");
			bw.newLine();
			Double failedPercent = (totalFailedTests / totalTests) * 100;
			bw.write("<div class=\"psdg-left\">Failed Percent</div>");
			failedPercent = Double.parseDouble(decimalFormat
					.format(failedPercent));
			bw.newLine();
			bw.write("<div class=\"psdg-right\">" + failedPercent + "%</div>");
			bw.newLine();
			Double skippedPercent = (totalSkippedTests / totalTests) * 100;
			skippedPercent = Double.parseDouble(decimalFormat
					.format(skippedPercent));
			bw.write("<div class=\"psdg-left\">Skipped Percent</div>");

			bw.newLine();
			bw.write("<div class=\"psdg-right\">" + skippedPercent + "%</div>");
			bw.write("</div>");
			bw.write("</div>");
			bw.write("</div>");
			bw.write("</div><br>");
			bw.write("<div class='row'>");
			bw.write("<div class='twelve columns'>");
			bw.write("<h4>Test Suite Execution Results</h4>");
			bw.write("</div>");
			bw.write("</div>");
			bw.write("<div class='row'>");
			bw.write("<div class='twelve columns' style='text-align: center'>");
			bw.write("<table class='responsive'>");
			bw.write("<tbody><tr>");

			bw.write("<th>Execution Count</th><th>Total Tests</th><th>Passed</th><th>Failed</th><th>Skipped</th></tr>");
			// bw.newLine();
			for (int i = 0; i < totalTest.length; i++) {
				bw.write("<tr>");
				// Changed CODE.......
				/*
				 * bw.write("<td>" + "<a href='" + new
				 * File("").getAbsolutePath() + "\\Custom Reports\\report" + (i
				 * + 1) + ".html'>Execution-" + (i + 1) + "</a></td>");
				 */bw.write("<td>" + "<a href='"
						+ new File(reportsDirectoryPath).getAbsolutePath()
						+ "\\report" + (i + 1) + ".html'>Execution-" + (i + 1)
						+ "</a></td>");
				// bw.newLine();
				bw.write("<td>" + totalTest[i].intValue() + "</td>");
				// bw.newLine();
				bw.write("<td style='background-color:#33ff33'>"
						+ passedTest[i] + "</td>");
				// bw.newLine();
				bw.write("<td style='background-color:#ff3333'>"
						+ failedTest[i] + "</td>");
				// bw.newLine();
				bw.write("<td style='background-color:#ff9900'>"
						+ skippedTest[i] + "</td>");
				// bw.newLine();
				bw.write("</tr>");
			}
			bw.write("</tbody>");
			bw.write("</table>");
			bw.write("</div>");
			bw.write("</div>");
			bw.write("</div>");
			bw.write("</body></html>");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void closewriter() {
		try {
			counter = 1;
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	public boolean createlogfile(String Filename, String className, int count) {
		boolean flag = false;

		try {
			File dir = new File(reportsDirectoryPath);
			if (!dir.exists()) {
				dir.mkdir();
			}

			String logsDirectoryPath = reportsDirectoryPath
					+ System.getProperty("file.separator") + "logs";
			dir = new File(logsDirectoryPath);
			if (!dir.exists()) {
				dir.mkdir();
			}

			String path = reportsDirectoryPath
					+ System.getProperty("file.separator") + "logs"
					+ System.getProperty("file.separator") + className + "_"
					+ Filename + "_" + count + ".html";
			fileName = className + "_" + Filename + "_" + count + ".html";
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
			flag = file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("<html lang='en'>");
			writer.newLine();
			writer.write("<head>");
			writer.write("<meta charset='utf-8'>");
			writer.write("<meta content='width=device-width' name='viewport'>");
			writer.write("<link href='" + System.getProperty("user.dir")
					+ "\\css\\globals.css' rel='stylesheet' type='text/css' />");
			writer.write("<link href='" + System.getProperty("user.dir")
					+ "\\css\\grid.css' rel='stylesheet' type='text/css' />");
			writer.write("<link href='" + System.getProperty("user.dir")
					+ "\\css\\mobile.css' rel='stylesheet' type='text/css' />");
			writer.write("<link href='"
					+ System.getProperty("user.dir")
					+ "\\css\\responsive-tables.css' rel='stylesheet' type='text/css' />");

			writer.write("</head>");
			writer.write("<body>");
			writer.write("<div class='container'>");
			writer.write("<div class='row'>");
			writer.write("<div class='twelve columns'>");
			writer.write("<header>");
			writer.write("<div id='logo'><img alt='Ideabytes' height='74' src='"
					+ new File("").getAbsolutePath()
					+ "\\images\\logo.png' width='176'></div>");
			writer.write("<div id='rightlogo'><img alt='cisco' height='99' src='"
					+ new File("").getAbsolutePath()
					+ "\\images\\cisco.png' width='176'></div>");
			writer.write("</header>");
			writer.write("</div>");
			writer.write("</div>");

			writer.write("<div class='row'>");
			writer.write("<div class='twelve columns'>");
			// writer.write("<h4>Results</h4>");
			writer.write("</div>");
			writer.write("</div>");

			writer.write("<div class='row'>");
			writer.write("<div class='twelve columns' style='text-align: center'>");
			writer.write("<table class='responsive'>");
			writer.write("<h4>" + Filename + " Results</h4>");
			writer.write("<tbody><tr><th>Sr No.</th><th>Step</th><th>Result</th><th>Status</th><th>Duration</th></tr></div></body></html>");

			/*
			 * writer.write(
			 * "<html><body bgcolor='bisque'><table border='1' align ='center' bgcolor='azure'>"
			 * ); writer.write("<h4><caption>" + Filename + "-" + className +
			 * "</caption></h4>");
			 * writer.write("<tr><th>Sr No.</th><th>Step</th><th>Result</th></tr>"
			 * );
			 */
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}

		imageCounter = 1;
		stepStartTime = new Date().getTime();

		return flag;

	}

	public void reporter(List<String> passedTests, List<String> failedTests,
			List<String> skippedTests, int count) throws IOException {
		EndDate = new Date();

		mainReport(count);

		File file = new File(reportsDirectoryPath
				+ System.getProperty("file.separator") + "report" + count
				+ ".html");
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		writer = new BufferedWriter(new FileWriter(file));
		/*
		 * writer.write("<html>"); writer.newLine();
		 * writer.write("<body bgcolor='bisque'>"); writer.newLine();
		 * writer.write("<img src='" + new File("").getAbsolutePath() +
		 * "\\images\\logo.jpeg' align ='right' width='200' height='80' alt='Capture'/>"
		 * );
		 * 
		 * writer.newLine(); writer.write(
		 * "<table align='center' style='background-color: aliceblue; margin-top:100px;' border='1' cellpadding='7 cellspacing='7'>"
		 * ); writer.newLine(); writer.write(
		 * "<caption style='font-size: 26px; font-weight: bold;'>Test Results</caption>"
		 * ); writer.newLine();
		 */
		writer.write("<html lang='en'>");
		writer.newLine();
		writer.write("<head>");
		writer.write("<meta charset='utf-8'>");
		writer.write("<meta content='width=device-width' name='viewport'>");
		writer.write("<link href='" + System.getProperty("user.dir")
				+ "\\css\\globals.css' rel='stylesheet' type='text/css' />");
		writer.write("<link href='" + System.getProperty("user.dir")
				+ "\\css\\grid.css' rel='stylesheet' type='text/css' />");
		writer.write("<link href='" + System.getProperty("user.dir")
				+ "\\css\\mobile.css' rel='stylesheet' type='text/css' />");
		writer.write("<link href='"
				+ System.getProperty("user.dir")
				+ "\\css\\responsive-tables.css' rel='stylesheet' type='text/css' />");

		writer.write("</head>");
		writer.write("<body>");
		readLog(writer);
		writer.write("<div class='container'>");
		writer.write("<div class='row'>");
		writer.write("<div class='twelve columns'>");
		writer.write("<header>");
		writer.write("<div id='logo'><img alt='Ideabytes' height='74' src='"
				+ new File("").getAbsolutePath()
				+ "\\images\\logo.png' width='176'></div>");
		writer.write("<div id='rightlogo'><img alt='cisco' height='99' src='"
				+ new File("").getAbsolutePath()
				+ "\\images\\cisco.png' width='176'></div>");
		writer.write("</header>");
		writer.write("</div>");
		writer.write("</div>");
		writer.write("<div class='row'>");
		writer.write("<div class='twelve columns'>");
		writer.write("<h4>Test Results</h4>");
		writer.write("</div>");
		writer.write("</div>");
		writer.write("<div class='row'>");
		writer.write("<div class='twelve columns' style='text-align: center'>");
		writer.write("<table class='responsive'>");

		writer.write("<tbody><tr><th>Project Name</th><th>Passed</th><th>Failed</th><th>Skipped</th><th>Start Time</th><th>End Time</th><th>Total Executed Time(in min)</th></tr>");
		writer.write("<tr>");
		writer.write("<td>" + projectName + "</td>");
		writer.write("<td style='background-color:#33ff33'>"
				+ passedTests.size() + "</td>");
		writer.write("<td style='background-color:#ff3333'>"
				+ failedTests.size() + "</td>");
		writer.write("<td style='background-color:#ff9900'>"
				+ (skippedTests.size()) + "</td>");
		writer.write("<td>" + StartDate.toString() + "</td>");
		writer.write("<td>" + EndDate.toString() + "</td>");
		long timeMints = TimeUnit.MILLISECONDS.toMinutes(EndDate.getTime()
				- StartDate.getTime());
		writer.write("<td>" + timeMints + "</td></tr></tbody>");
		writer.write("</table></div></div>");

		writer.write("<div class='row'>");
		writer.write("<div class='twelve columns'>");
		writer.write("<h4>Passed Tests</h4></div></div>");
		writer.write("<div class='row'><div class='twelve columns' style='text-align: center'><table class='responsive'>");
		writer.write("<tbody><tr><th>Class Name</th><th>Method Name</th>");
		/*if (IdeabytesListener.passedParametervalues.size() > 0) {
			writer.write("<th>Parameters</th>");
		}*/
		writer.write("</tr>");
		if (passedTests.size() > 0) {
			Iterator<String> passed = passedTests.iterator();
			Iterator<Object[]> passedParameters = IdeabytesListener.passedParametervalues
					.iterator();
			Iterator<String> passedClasses = IdeabytesListener.passedClassNames
					.iterator();
			Iterator<String> passedFileNames = IdeabytesListener.passedLogFiles
					.iterator();
			while (passed.hasNext()) {
				String passedTest = passed.next();
				Object[] passedParam = passedParameters.next();
				String passedClass = passedClasses.next();
				String passedFileName = passedFileNames.next();
				writer.write("<tr><td>" + passedClass + "</td><td>");
				// CHANGED CODE............
				/*
				 * writer.write("<a href='" + new File("").getAbsolutePath() +
				 * "/Custom Reports/logs/" + passedFileName + "'>" + passedTest
				 * + "</a>");
				 */
				writer.write("<a href='" + reportsDirectoryPath + "/logs/"
						+ passedFileName + "'>" + passedTest + "</a>");

				writer.write("</td>");
				/*writer.write("<td>");
				if (passedParam.length == 0) {
					writer.write("<b><i>No Parameters</i></b>");
				} else {
					for (int i = 0; i < passedParam.length; i++) {
						if ("".equals(passedParam[i].toString())) {
							writer.write("<b>No value passed here</b>");
						} else {
							writer.write(passedParam[i].toString());
						}
						if (!((i + 1) == passedParam.length)) {
							writer.write(",");
						}
					}
				}

				writer.write("</td>");*/
			}
		} else {
			writer.write("<tr><td colspan='3' align='center'>No Passed Tests</td></tr>");
		}
		writer.write("</tr></tbody></table></div></div>");

		writer.write("<div class='row'>");
		writer.write("<div class='twelve columns'>");
		writer.write("<h4>Failed Tests</h4></div></div>");
		writer.write("<div class='row'><div class='twelve columns' style='text-align: center'><table class='responsive'>");
		writer.write("<tbody><tr><th>Class Name</th><th>Method Name</th>");
		/*if (IdeabytesListener.failedParametervalues.size() > 0) {
			writer.write("<th>Parameters</th>");
		}*/
		writer.write("</tr>");
		if (failedTests.size() > 0) {
			Iterator<String> failed = failedTests.iterator();
			Iterator<Object[]> failedParameters = IdeabytesListener.failedParametervalues
					.iterator();
			Iterator<String> failedClasses = IdeabytesListener.failedClassNames
					.iterator();
			Iterator<String> failedFileNames = IdeabytesListener.failedLogFiles
					.iterator();
			while (failed.hasNext()) {
				String failedTest = failed.next();
				Object[] failedParam = failedParameters.next();
				String failedClass = failedClasses.next();
				String failedFileName = failedFileNames.next();
				writer.write("<tr><td>" + failedClass + "</td><td>");
				// CHANGED CODE...............
				/*
				 * writer.write("<a href='" + new File("").getAbsolutePath() +
				 * "/Custom Reports/logs/" + failedFileName + "'>" + failedTest
				 * + "</a>"); writer.write("<td>");
				 */

				writer.write("<a href='" + reportsDirectoryPath + "/logs/"
						+ failedFileName + "'>" + failedTest + "</a></td>");
				/*writer.write("<td>");

				if (failedParam.length == 0) {
					writer.write("<b><i>No Parameters</i></b>");
				} else {
					for (int i = 0; i < failedParam.length; i++) {
						if ("".equals(failedParam[i].toString())) {
							writer.write("<b>No value passed here</b>");
						} else {
							writer.write(failedParam[i].toString());
						}
						if (!((i + 1) == failedParam.length)) {
							writer.write(",");
						}
					}
				}
				writer.write("</td>");*/
			}
		} else {
			writer.write("<tr><td colspan='3' align='center'>No Failed Tests</td></tr>");
		}
		writer.write("</tr></tbody></table></div></div>");

		writer.write("<div class='row'>");
		writer.write("<div class='twelve columns'>");
		writer.write("<h4>Skipped Tests</h4></div></div>");
		writer.write("<div class='row'><div class='twelve columns' style='text-align: center'><table class='responsive'>");
		writer.write("<tbody><tr><th>Class Name</th><th>Method Name</th>");
		/*if (IdeabytesListener.skippedParametervalues.size() > 0) {
			writer.write("<th>Parameters</th>");
		}*/
		writer.write("</tr>");
		if (skippedTests.size() > 0) {
			Iterator<String> iter = skippedTests.iterator();
			Iterator<Object[]> skippedParameters = IdeabytesListener.skippedParametervalues
					.iterator();
			Iterator<String> skippedClasses = IdeabytesListener.skippedClassNames
					.iterator();
			while (iter.hasNext()) {
				String skippedTest = iter.next();
				Object[] skippedParam = skippedParameters.next();
				String skippedClass = skippedClasses.next();
				writer.write("<tr><td>" + skippedClass + "</td><td>");
				writer.write(skippedTest);
				/*writer.write("<td>");
				if (skippedParam.length == 0) {
					writer.write("<b><i>No Parameters</i></b>");
				} else {
					for (int i = 0; i < skippedParam.length; i++) {
						if ("".equals(skippedParam[i].toString())) {
							writer.write("<b>No value passed here</b>");
						} else {
							writer.write(skippedParam[i].toString());
						}

						if (!((i + 1) == skippedParam.length)) {
							writer.write(",");
						}
					}
				}
				writer.write("</td>");*/
			}
		} else {
			writer.write("<tr><td colspan='3' align='center'>No Skipped Tests</td></tr>");
		}
		writer.write("</tr></tbody></table></div></div>");
		writer.write("</body>");
		writer.write("</html>");
		writer.close();

	}

	public void after() throws IOException {
		iterationValue = count1;
		totalTest = new Double[iterationValue];
		for (int i = 0; i < totalTest.length; i++) {
			totalTest[i] = 0.0;
		}
		passedTest = new int[iterationValue];
		failedTest = new int[iterationValue];
		skippedTest = new int[iterationValue];
		addToLog();
		reporter(IdeabytesListener.passedTests, IdeabytesListener.failedTests,
				IdeabytesListener.skippedTests, count1);

	}

	// New Methods
	public static void log(String msg, String status) {
		// Get the 2 messages
		String[] messages = msg.split(";");
		String msg1 = ".";
		String msg2 = ".";

		msg1 = messages[0];
		if (messages.length > 1) {
			msg2 = messages[1];
		}

		// Calculate the execution time for step
		long diff = new Date().getTime() - stepStartTime;
		stepStartTime = new Date().getTime();
		String timeTaken = longToTime(diff);

		logMsg = msg2;
		addLogToFile(counter, msg1, msg2, status, timeTaken, false);
		counter++;
	}

	public static void addLogToFile(int stepNum, String expectedMsg,
			String actualMsg, String status, String timeTaken,
			boolean isMultipart) {
		try {
			String convertedTime = null;
			if (writer == null) {
				String logsDirectoryPath = reportsDirectoryPath
						+ System.getProperty("file.separator") + "logs";
				writer = new BufferedWriter(new FileWriter(new File(
						logsDirectoryPath
								+ System.getProperty("file.separator")
								+ IdeabytesReport.fileName)));
			}

			writer.write("<tr>");
			writer.write("<td align ='center'>" + stepNum);
			writer.write("</td>");
			writer.write("<td align='left'>");
			writer.write(expectedMsg);
			writer.write("</td>");
			writer.write("<td align='left'>");
			writer.write(actualMsg);
			writer.write("</td>");

			if (status.equalsIgnoreCase("passed")) {
				/*
				 * writer.write("<td align='center'>");
				 * writer.write("<span style=' color: chartreuse'>Passed</span>"
				 * ); writer.write("</td>");
				 */
				screenShotHyperLinkPassed();
			} else {
				if (!isMultipart)
					screenShotHyperLink();
				errorMsg = errorMsg + ";" + logMsg;
			}

			writer.write("<td align ='center'>");
			writer.write(timeTaken);
			writer.write("</td>");
			writer.write("</tr>");
			stepStartTime = new Date().getTime();

			convertedTime = timeTaken.replaceAll("\\:", ".");
			doubleTime = Double.parseDouble(convertedTime);
			totalTimeTaken = totalTimeTaken + doubleTime;

			if (!isMultipart && testCaseDeatils != null) {
				String[] values = new String[10];
				values[0] = testCaseDeatils[0];
				values[1] = testCaseDeatils[1];
				values[2] = testCaseDeatils[2];
				values[3] = testCaseDeatils[3];

				values[4] = String.valueOf(counter);
				values[5] = expectedMsg;
				values[6] = actualMsg;
				values[7] = status;
				values[8] = timeTaken;
				values[9] = "";

				DBlogs.add(values);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String longToTime(long time) {
		// int mil = (int) ((time % 1000));
		int sec = (int) ((time / 1000) % 60);
		int min = (int) ((time / 1000) / 60);
		String timeTaken = "";
		if (sec / 10 < 1 && min / 10 < 1)
			timeTaken = "0" + min + ":" + "0" + sec;
		else if (sec / 10 < 1)
			timeTaken = min + ":" + "0" + sec;
		else if (min / 10 < 1)
			timeTaken = "0" + min + ":" + sec;
		else
			timeTaken = min + ":" + sec;

		return timeTaken;
	}

	public static void screenShotHyperLink() {
		try {
			String name = IdeabytesReport.fileName;
			name = name.substring(0, name.lastIndexOf("."));

			writer.write("<td align='center'>");
			writer.write("<span style=' color: Red'><a href='" + imageName
					+ "' >Failed</a></span>");
			writer.write("</td>");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void screenShotHyperLinkPassed() {
		try {
			String name = IdeabytesReport.fileName;
			name = name.substring(0, name.lastIndexOf("."));

			writer.write("<td align='center'>");
			writer.write("<span style=' color: chartreuse'><a href='"
					+ imageName + "' >Passed</a></span>");
			writer.write("</td>");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void copyFile(String sourceFile, String targetFile) {
		File f = new File(sourceFile);
		try {
			if (f.exists()) {
				InputStream in = new FileInputStream(f);
				OutputStream out = new FileOutputStream(targetFile);
				int c;

				while ((c = in.read()) != -1)
					out.write(c);

				in.close();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTestCaseDetailsToLogfile(String className,
			String methodName, String testName) {
		String funtionalFlow = className
				.substring(className.lastIndexOf(".") + 1);
		/*
		 * writer.write("<div class='row'>");
		 * writer.write("<div class='twelve columns'>"); writer.write(
		 * "<div class='row'><div class='twelve columns' style='text-align: center'><table class='responsive'>"
		 * ); writer.write("<tbody><tr><th>Functional Flow</th>");
		 * writer.write("<th>Test Case Name</th>");
		 * writer.write("<th>Test Script Name</th></tr>");
		 * 
		 * writer.write("<tr><td>"+funtionalFlow+"</td>");
		 * writer.write("<td>"+testName+"</td>");
		 * writer.write("<td>"+methodName+"</td></tr>");
		 */

		/*
		 * writer.write(
		 * "<font size=\"7\" face=\"Century\" color=\"brown\"><h4 align ='left'>Functional Flow&nbsp&nbsp&nbsp</font>: "
		 * +funtionalFlow+"</h4>"); writer.write(
		 * "<font size=\"7\" face=\"Century\" color=\"brown\"><h4 align ='left'>Test Case Name&nbsp&nbsp&nbsp</font>: "
		 * +testName+"</h4>"); writer.write(
		 * "<font size=\"7\" face=\"Century\" color=\"brown\"><h4 align ='left'>Test Script Name&nbsp</font>: "
		 * +methodName+"</h4>");
		 */
		// writer.write("</tbody></table></div></div>");

		// long diff = new Date().getTime() - tcStartTime;
		// String timeTaken = longToTime(diff);
		/*
		 * writer.write("<div class='row'>");
		 * writer.write("<div class='twelve columns'>"); totalTimeTaken =
		 * Math.round(totalTimeTaken * 100.0) / 100.0;
		 * writer.write("<h4>"+"Total execution time : "
		 * +totalTimeTaken+" (mm:ss)</h4></div></div></div></body></html>");
		 */
		// System.out.println("Check the functionality");
	}
}