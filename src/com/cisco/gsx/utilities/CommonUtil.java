package com.cisco.gsx.utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cisco.gsx.reports.IdeabytesReport;

public class CommonUtil {

	public static WebDriver driver = null;
	public static List<String> windowHandlers;
	public static WebElement webElement;
	public static List<WebElement> webelements;
	public static int defaultBrowserTimeOut = 60;
	public static String parentWindowHandle = null;
	private static int windowCount = 1;
	// static FirefoxDriver driver = new FirefoxDriver();
	public static void openBrowser(String browserType) {

		try {
			browserType = "firefox";
	        //browserType = "iexplorer";

			if (browserType.equalsIgnoreCase("firefox")) {
				// System.out.println("fire");
				try {
					driver = new FirefoxDriver();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("fire gone");

			} else if (browserType.equalsIgnoreCase("iexplorer")) {
				System.out.println("iexplorer");
				try {
					System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer32.exe");
				     DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
				             //capabilitiesIE.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				             //capabilitiesIE.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				             capabilitiesIE.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				              //capabilitiesIE.setCapability("requireWindowFocus", true);
				              //capabilitiesIE.setCapability("enablePersistentHover", false);
				              driver = new InternetExplorerDriver(capabilitiesIE); 
					
					//driver = new InternetExplorerDriver();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// driver = new InternetExplorerDriver();

			} else if (browserType.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
				//driver = new ChromeDriver();
				
			}

			// driver.manage().timeouts().implicitlyWait(defaultBrowserTimeOut,TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out
					.println("Error occured whlie createing coresponding browser object"
							+ browserType
							+ " *** "
							+ getErroMsg(e.getMessage()));
			String error = "Error occured whlie createing coresponding browser object : "
					+ browserType;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie createing coresponding browser object : "
							+ browserType, "Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}

	}

	public static String getTextFromTextBox(String locator) {
		WebElement element;
		String text = "NO VALUE RETRIVED";
		try {
			element = findElement(locator);

			text = element.getAttribute("value").trim();
			// System.out.println(" Elemet text :::" + text);
		} catch (Exception e) {
		}
		element = null;
		return text;
	}

	public static boolean isElementPresent1(String locator) {
		  
		  String[] arrLocator = locator.split("#");
		  String locatorTag = arrLocator[0].trim();
		  String objectLocator = arrLocator[1].trim();
		  try{
		          driver.findElement(By.xpath(objectLocator));
		           return true; 
		        }catch(NoSuchElementException ne){
		        }
		return false; 
		 }
	
	
	public static boolean isElmentPrsent(String locator) {

		WebElement element = CommonUtil.findElement(locator);
		if (element.isDisplayed()) {

			return true;
		} else {

			return false;
		}
	}

	public static void closeBrowser() {
		if (driver != null)
			driver.close();
	}

	public static void openUrl(String url) {
		try {
			if (driver != null)
				driver.get(url);
		} catch (Exception e) {
			System.out
					.println("Error occured whlie opening the coresponding base url"
							+ url + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie opening the coresponding base url : "
					+ url;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie opening the coresponding base url : "
							+ url, "Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}
	}

	public static void waitForPageToStartLoading() {
		try {
			Object result = ((JavascriptExecutor) driver)
					.executeScript("return document['readyState']");
			int iCount = 0;
			while (!result.toString().equalsIgnoreCase("loading")
					&& iCount < 10) {
				Thread.sleep(1000);
				result = ((JavascriptExecutor) driver)
						.executeScript("return document['readyState']");
				iCount++;
			}
		} catch (Exception e) {
			System.out.println("Exception from page load : " + e.getMessage());
		}
	}

	public static void waitForPageload() {

		try {

			Object result = ((JavascriptExecutor) driver)
					.executeScript("return document['readyState']");
			int iCount = 0;
			while (!result.toString().equalsIgnoreCase("complete")
					&& iCount < 10) {

				explicitlyWait(5);
				result = ((JavascriptExecutor) driver)
						.executeScript("return document['readyState']");
				iCount++;
				System.out.println("Browser Status in While Loop::"
						+ result.toString() + "::");
			}
			System.out.println("Page Load is completed");
		} catch (Exception e) {
			System.out.println("Exception from page load : " + e.getMessage());
		}
	}

	
	public static int elementcount(String locator,String text)
	
	{
		 List<WebElement> sessions = CommonUtil.findElements(locator);
		  boolean status = false;
		  int count = 0; 
		  for(int j=0;j<sessions.size();j++)
		  {
		      status = StringUtils.containsIgnoreCase(sessions.get(j).getText(), text);
		      if(status ==true)
		      {
		       count++;
		      }
		    
		  }
		  return count;
	}
	
	
	
	
	public static void maximizeWindow() {
		  driver.manage().window().maximize();
		 }
	public static void enterText(String field, String value) {

		try {
			webElement = findElement(field);
			if (webElement.isDisplayed()) {
				webElement.clear();
				webElement.sendKeys(value);
			}
		} catch (Exception e) {
			System.out
					.println("Error occured whlie entering the value into textbox"
							+ value + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie entering the value into textbox:"
					+ value;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie entering the value into textbox : "
							+ value,
					"Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}
	}

	public static void selectValueFromDropDownBox(String field, String value) {
		try {
			webElement = findElement(field);
			if (webElement.isDisplayed()) {
				Select select = new Select(webElement);
				select.selectByVisibleText(value);
			}
		} catch (Exception e) {
			System.out
					.println("Error occured whlie select the value from dropdownbox "
							+ value + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie select the value from dropdownbox :"
					+ value;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie select the value from dropdownbox : "
							+ value, "Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}
	}

	public static boolean isAlertPresent() {

		try {
			Alert alert = driver.switchTo().alert();
			//alert.accept();
			return true;
		} catch (NoAlertPresentException Ex) {
			// Ex.printStackTrace();

			return false;
		}
	}

	
	// It will wait seconds
	public static void explicitlyWait(int time) {

		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void click(String field) {
		try {
			WebElement element = findElement(field);
			if (element != null) {
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Error occured whlie click on the element "
					+ field + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie click on the element :" + field;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie click on the element : " + field,
					"Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}
	}

	public static void click(String field, int time) {
		try {
			WebElement element = findElement(field);
			if (element != null)
				element.click();
			explicitlyWait(time);
		} catch (Exception e) {
			System.out.println("Error occured whlie click on the element "
					+ field + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie click on the element :" + field;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie click on the element : " + field,
					"Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}
	}

	public static void isChecked(String field) {

		try {
			WebElement element = findElement(field);
			if (element != null)

				if (!element.isSelected()) {
					element.click();
				}

		} catch (Exception e) {
			System.out.println("Error occured whlie selecting the check box "
					+ field + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie selecting the check box :"
					+ field;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie selecting the check box : " + field,
					"Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}

	}

	public static void isUnChecked(String field) {

		try {
			WebElement element = findElement(field);
			if (element != null)

				if (element.isSelected()) {
					element.click();
				}

		} catch (Exception e) {
			System.out.println("Error occured whlie unchecking  the check box "
					+ field + " *** " + getErroMsg(e.getMessage()));
			String error = "Error occured whlie unchecking  the check box :"
					+ field;
			error = error.replaceAll("'", "\"");
			if (IdeabytesReport.getErrorMsg() != null
					&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
				error = IdeabytesReport.getErrorMsg() + ";" + error;
				IdeabytesReport.setErrorMsg(error);
			} else {
				IdeabytesReport.setErrorMsg(error);
			}
			e.printStackTrace();
			logMessage(
					"Error occured whlie unchecking  the check box : " + field,
					"Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}

	}

	public static String getText(String locator) {
		WebElement element;
		String text = "NO VALUE RETRIVED";
		try {
			element = findElement(locator);
			if (element != null)
				text = element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		element = null;
		return text;
	}

	public static String getAttribute(String locator, String attribute) {
		WebElement element;
		String text = "NO VALUE RETRIVED";
		try {
			element = findElement(locator);
			if (element != null)
				text = element.getAttribute(attribute).trim();
		} catch (Exception e) {
		}
		element = null;
		return text;

	}

	/*
	 * This method will return true when the radio button or check box is
	 * selected. return : boolean
	 */
	public static boolean isElementSelected(String locator) {
		WebElement element = findElement(locator);
		return element.isSelected();
	}

	public static String getSelectedDropDownValue(String dropDownLocator) {
		String selectedValue = "";
		try {
			WebElement element = findElement(dropDownLocator);
			Select selectBox = new Select(element);
			selectedValue = selectBox.getFirstSelectedOption().getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectedValue;
	}

	public static WebElement findElement(String locator) {

		if (locator != null) {

			String[] arrLocator = locator.split("#");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					webElement = driver.findElement(By.id(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("name")) {
					webElement = driver.findElement(By.name(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					webElement = driver.findElement(By.xpath(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					webElement = driver.findElement(By.linkText(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("class")) {
					webElement = driver
							.findElement(By.className(objectLocator));
				} else {
					String error = "Please Check the Given Locator Syntax :"
							+ locator;
					System.out
							.println("Please Check the Given Locator Syntax : "
									+ locator);
					error = error.replaceAll("'", "\"");
					if (IdeabytesReport.getErrorMsg() != null
							&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase(
									"")) {
						error = IdeabytesReport.getErrorMsg() + ";" + error;
						IdeabytesReport.setErrorMsg(error);
					} else {
						IdeabytesReport.setErrorMsg(error);
					}
					logMessage("Please Check the Given Locator Syntax : ",
							"Exception occurred.Exception : " + locator, "FAIL");
					return null;
				}
			} catch (Exception exception) {
				String error = "Please Check the Given Locator Syntax :"
						+ locator;
				error = error.replaceAll("'", "\"");
				if (IdeabytesReport.getErrorMsg() != null
						&& !IdeabytesReport.getErrorMsg().equalsIgnoreCase("")) {
					error = IdeabytesReport.getErrorMsg() + ";" + error;
					IdeabytesReport.setErrorMsg(error);
				} else {
					IdeabytesReport.setErrorMsg(error);
				}
				exception.printStackTrace();
				CommonUtil.logMessage(
						"Please Check the Given Locator Syntax : ",
						"Exception occurred.Exception : " + locator, "FAIL");
				return null;
			}
		}
		return webElement;
	}

	public static List<WebElement> findElements(String locator) {

		if (locator != null) {
			String[] arrLocator = locator.split("#");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();

			if (locatorTag.equalsIgnoreCase("id")) {
				webelements = driver.findElements(By.id(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("name")) {
				webelements = driver.findElements(By.name(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("xpath")) {
				webelements = driver.findElements(By.xpath(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("linkText")) {
				webelements = driver.findElements(By.linkText(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("class")) {
				webelements = driver.findElements(By.className(objectLocator));
			} else {
				System.out.println("Please Check the Locator Syntax Given :"
						+ locator);
				return null;
			}
		}
		return webelements;
	}

	public static void closeCriticalAlert(String criticalAlert) {

		WebElement webElement = findElement(criticalAlert);
		if (webElement.isDisplayed()) {

			driver.findElement(By.xpath(".//*[@id='ok']")).click();
		}
	}

	public static void switchWindow() {

		waitForWindowToAppear();
		String mainWindowHandle = driver.getWindowHandle();
		Set sWindows = driver.getWindowHandles();
		Iterator ite = sWindows.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
			}
		}
		waitForPageload();
	}
	
	public static String getAlertText() {

		  try {
		   String alertText = driver.switchTo().alert().getText();
		   return alertText;
		  } catch (NoAlertPresentException Ex) {
		   // Ex.printStackTrace();
		   return "No Alert present to get the text from the Alert";
		  }
		 }

	public static void switchWindows() {
		explicitlyWait(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	
	public static void navigateBack() {

		  try {
		   driver.navigate().back();
		  } catch (Exception e) {
		   e.printStackTrace();
		   logMessage(
		     "Error occured whlie navigating to the back",
		     "Exception occurred.Exception : "
		       + getErroMsg(e.getMessage()), "fail");
		  }
		 }
	
	
	public static String getErroMsg(String msg) {

		int a = msg.indexOf("(");
		return msg.substring(0, a);
	}

	public static void logMessage(String expectedMsg, String actualMsg,
			String status) {

		if (status.equalsIgnoreCase("pass")) {
			takeScreenShot();
			IdeabytesReport.log(expectedMsg + ";" + actualMsg, "Passed");
		} else {
			takeScreenShot();
			IdeabytesReport.log(expectedMsg + ";" + actualMsg, "Failed");
			CommonUtil.closeBrowser();
			Assert.assertTrue(false);
		}
	}

	public static void takeScreenShot() {
		try {
			if (driver != null) {
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				String name = IdeabytesReport.fileName;

				name = name.substring(0, name.lastIndexOf("."));
				// ******* ../../images
				IdeabytesReport.imageName = IdeabytesReport.getReportDirPath()
						+ System.getProperty("file.separator") + "images"
						+ System.getProperty("file.separator") + name
						+ IdeabytesReport.imageCounter + ".png";

				FileUtils
						.copyFile(scrFile, new File(IdeabytesReport.imageName));

				IdeabytesReport.imageName = "..\\images"
						+ System.getProperty("file.separator") + name
						+ IdeabytesReport.imageCounter + ".png";
				IdeabytesReport.imageCounter++;
			}
		} catch (IOException e) {
			System.out.println("Unable to take screenshot.");
			e.printStackTrace();
		}
	}

	public static void navigateUrl(String url) {

		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			logMessage(
					"Error occured whlie navigating to the  : " + url,
					"Exception occurred.Exception : "
							+ getErroMsg(e.getMessage()), "fail");
		}
	}

	public static int getNumberOfRowsInTable(String tableId) {
		// Grab the table
		WebElement table = findElement(tableId);
		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = " + allRows.size());
		return allRows.size();

	}

	public static void handleAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtil.logMessage("Unable to Find the Alert .",
					"Exception occurred.Exception : ", "FAIL");
		}
	}

	public static String getNumbersFromString(String text) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(text);
		while (m.find()) {
			return m.group().trim();
		}

		return null;
	}

	/*
	 * public static void isMailRecived(String requestId) {
	 * 
	 * boolean flag = false;
	 * 
	 * try { if (EmailUtils.isMailRecived(requestId)) { flag = true; } else {
	 * explicitlyWait(1);
	 * 
	 * } } catch (ParseException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * if (flag) { CommonUtil.logMessage("Mail recived successfully.",
	 * "Mail recived successfully.", "PASS"); } else {
	 * CommonUtil.logMessage("Mail recived successfully.",
	 * "Mail not recived successfully.", "FAIL"); }
	 * 
	 * }
	 */

	/*
	 * public static void switchToOriginalWindow() { try { if
	 * (windowHandlers.size() > 1) windowHandlers.remove(windowHandlers.size() -
	 * 1); Iterator<String> itr = windowHandlers.iterator(); String handler =
	 * ""; while (itr.hasNext()) handler = itr.next();
	 * System.out.println("handler : " + handler.toString()); //
	 * System.out.println("Title is :"+driver.getTitle().toString()); if
	 * (handler != "") driver = driver.switchTo().window(handler);
	 * System.out.println("Title is :" + driver.getTitle().toString());
	 * 
	 * } catch (Exception e) { logMessage("Switch to parent window.",
	 * "Exception occured. Exception : " + e.getMessage(), "fail"); } }
	 */
	public static void switchToOriginalWindow() {
		// String s1 = getParentWindow();
		driver.switchTo().window(getParentWindow());
	}

	public static void parseChars(String letter, Robot robot) {
		for (int i = 0; i < letter.length(); i++) {
			char chary = letter.charAt(i);
			typeCharacter(Character.toString(chary), robot);
		}
	}

	public static void typeCharacter(String letter, Robot robot) {

		if (Character.isLetterOrDigit(letter.charAt(0))) {
			try {
				boolean upperCase = Character.isUpperCase(letter.charAt(0));
				String variableName = "VK_" + letter.toUpperCase();
				KeyEvent ke = new KeyEvent(new JTextField(), 0, 0, 0, 0, ' ');
				Class clazz = ke.getClass();
				Field field = clazz.getField(variableName);
				int keyCode = field.getInt(ke);
				robot.delay(80);
				if (upperCase)
					robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
				if (upperCase)
					robot.keyRelease(KeyEvent.VK_SHIFT);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			if (letter.equals("!")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("@")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_2);
				robot.keyRelease(KeyEvent.VK_2);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("#")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("#")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("$")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_4);
				robot.keyRelease(KeyEvent.VK_4);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("%")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_5);
				robot.keyRelease(KeyEvent.VK_5);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("^")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_6);
				robot.keyRelease(KeyEvent.VK_6);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("&")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_7);
				robot.keyRelease(KeyEvent.VK_7);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("*")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_8);
				robot.keyRelease(KeyEvent.VK_8);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals("=")) {
				robot.keyPress(KeyEvent.VK_EQUALS);
				robot.keyRelease(KeyEvent.VK_EQUALS);
			} else if (letter.equals(" ")) {
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			} else if (letter.equals("/")) {
				robot.keyPress(KeyEvent.VK_BACK_SLASH);
				robot.keyRelease(KeyEvent.VK_BACK_SLASH);
			} else if (letter.equals("\\")) {
				robot.keyPress(KeyEvent.VK_BACK_SLASH);
				robot.keyRelease(KeyEvent.VK_BACK_SLASH);
			} else if (letter.equals("_")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals(":")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_SEMICOLON);
				robot.keyRelease(KeyEvent.VK_SEMICOLON);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals(";")) {
				robot.keyPress(KeyEvent.VK_SEMICOLON);
				robot.keyRelease(KeyEvent.VK_SEMICOLON);
			} else if (letter.equals(",")) {
				robot.keyPress(KeyEvent.VK_COMMA);
				robot.keyRelease(KeyEvent.VK_COMMA);
			} else if (letter.equals("?")) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_SLASH);
				robot.keyRelease(KeyEvent.VK_SLASH);
				robot.keyRelease(KeyEvent.VK_SHIFT);
			} else if (letter.equals(" ")) {
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			} else if (letter.equals(".")) {
				robot.keyPress(KeyEvent.VK_PERIOD);
				robot.keyRelease(KeyEvent.VK_PERIOD);
			}

		}
	}

	public static void downloadFile(String fileName) {

		String filePath = System.getProperty("user.dir") + File.separator
				+ fileName + ".zip";

		System.out.println("filePath Download Method : -" + filePath);
		try {

			File f = new File(filePath.trim());
			if (filePath.endsWith(".zip")) {

				if (f.exists()) {
					f.delete();
					System.out.println("Deleted File Name : " + filePath);

				}
			}

			filePath = System.getProperty("user.dir") + File.separator
					+ fileName + ".XLS";
			File f1 = new File(filePath.trim());
			if (filePath.endsWith(".XLS")) {

				if (f1.exists()) {
					f1.delete();
					System.out.println("Deleted File Name : " + filePath);

				}
			}

			filePath = System.getProperty("user.dir") + File.separator
					+ fileName + ".CSV";
			File f2 = new File(filePath.trim());
			if (filePath.endsWith(".CSV")) {

				if (f2.exists()) {
					f2.delete();
					System.out.println("Deleted File Name : " + filePath);

				}
			}

			filePath = System.getProperty("user.dir") + File.separator
					+ fileName;
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_S);

			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			/*
			 * robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_Y);
			 * robot.keyRelease(KeyEvent.VK_ALT);
			 * robot.keyRelease(KeyEvent.VK_Y);
			 */
			Thread.sleep(1000);

			parseChars(filePath, robot);

			Thread.sleep(2000);

			/*
			 * robot.keyPress(KeyEvent.VK_ENTER);
			 * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(2000);
			 */

			// parseChars(fileName,robot);
			// Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			/*
			 * robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_Y);
			 * robot.keyRelease(KeyEvent.VK_ALT);
			 * robot.keyRelease(KeyEvent.VK_Y);
			 */
			Thread.sleep(4000);
			// robot.keyPress(KeyEvent.VK_ESCAPE);
			// robot.keyRelease(KeyEvent.VK_ESCAPE);
			// Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectMouseOverOption(String field) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String mouseOver = field + ";";
		js.executeScript(mouseOver);
		System.out.println("validate online method end");

		explicitlyWait(5);
	}
	
	public static void mouseOverOption(String locator) {

		WebElement element = CommonUtil.findElement(locator);
	      
	      Actions action = new Actions(driver);
	      action.moveToElement(element).build().perform();
	      
	}

	public static String getParentWindow() {
		String main_window = driver.getWindowHandle();
		return main_window;
	}

	public static void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to
													// the next found window
													// handle (that's your newly
													// opened window)
		}
	}

	public static void switchToFrame(String locator) {
		WebElement element = CommonUtil.findElement(locator);
		driver.switchTo().frame(element);
	}

	public static void switchToFrame() {
		driver.switchTo().frame(0);
	}

	public static void doubleclick(String field) {
		webElement = CommonUtil.findElement(field);
		Actions builder = new Actions(driver);
		Action doubleClick = builder.doubleClick(webElement).build();
		doubleClick.perform();
	}

	/*
	 * public static void closeAllBrowsers(){ driver.quit(); }
	 */
	public static void waitForWindowToAppear() {

		for (int j = 0; j <= 15; j++) {

			int noOfWindows = driver.getWindowHandles().size();

			if (windowCount != noOfWindows) {

				windowCount = noOfWindows;
				System.out.println("window count :" + windowCount);
				/*
				 * for (String winHandle : driver.getWindowHandles()) {
				 * driver.switchTo().window(winHandle); }
				 */
				break;
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public static String getTitle(){
		return driver.getTitle();
	}
	public static void getDimensions(){
		System.out.println("*********Height********"+driver.manage().window().getSize().getHeight());
		System.out.println("*********Weight********"+driver.manage().window().getSize().getWidth());
	}

}// End Class