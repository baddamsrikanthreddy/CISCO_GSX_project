package com.cisco.gsx.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Threadex {

	static WebDriver driver = null;
	static int pageLoadTimeout = 10;

	@Test
	public void m1() {

		try {
			// String url = "https://yourdomain.com";

			// driver = new FirefoxDriver();

			// IExplorerdriver
			/*
			 * System.setProperty("webdriver.ie.driver",
			 * "C:\\IEDriverServer.exe"); DesiredCapabilities capab =
			 * DesiredCapabilities.internetExplorer();
			 * capab.setCapability(InternetExplorerDriver
			 * .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); driver
			 * = new InternetExplorerDriver(capab);
			 */

			// chrome driver
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\chromedriver.exe"); driver = new ChromeDriver();
			 */

			// safaridriver

			driver = new SafariDriver();

			TimeoutThread timeoutThread = new TimeoutThread(pageLoadTimeout);
			timeoutThread.start();

			driver.get("http://wwwin-tools-stage.cisco.com/secadmin/prse/homePage.i");
			// for IE
			// timeoutThread.handleTimeout();

			// if we return from driver.get() call and timeout actually occured,
			// wait for hanlder to complete
			if (timeoutThread.timeoutOccurred) {

				while (!timeoutThread.completed)
					Thread.sleep(200);

			} else {

				// else cancel the timeout thread
				timeoutThread.interrupt();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	class TimeoutThread extends Thread {

		int timeout;
		boolean timeoutOccurred;
		boolean completed;

		public TimeoutThread(int seconds) {
			this.timeout = seconds;
			this.completed = false;
			this.timeoutOccurred = false;
		}

		public void run() {
			try {

				Thread.sleep(timeout * 1000);
				this.timeoutOccurred = true;
				this.handleTimeout();
				this.completed = true;

			} catch (InterruptedException e) {
				return;
			} catch (Exception e) {
				System.out.println("Exception on TimeoutThread.run(): "
						+ e.getMessage());
			}
		}

		public void handleTimeout() {

			System.out.println("Typing in user/pass for basic auth prompt");

			try {
				Robot robot = new Robot();

				// type is defined elsewhere - not illustrating for this example
				CommonUtil.parseChars("Cisco\\mbasam", robot);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(500);

				CommonUtil.parseChars("Bebold541!", robot);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				System.out.println("Failed to type keys: " + e.getMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
