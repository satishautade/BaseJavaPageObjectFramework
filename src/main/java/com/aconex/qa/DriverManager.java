package com.aconex.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by satish on 17/6/15.
 */
public class DriverManager {

        private static WebDriver driver;

        static
        {
            String browserName = PropertyReader.getBrowserName().toLowerCase();
            switch(browserName){
                case "firefox": driver = new FirefoxDriver(); break;

                case "ie": System.setProperty("webdriver.ie.driver", PropertyReader.getIeDriverPath());
                    driver = new InternetExplorerDriver();
                    break;

                case "chrome": System.setProperty("webdriver.chrome.driver", PropertyReader.getChromeDriverPath());
                    driver = new ChromeDriver();
                    break;
                default: System.out.println("Invalid broser name encountered. Please check browser name.");

            }
        }
        public static WebDriver getDriver() {
            return driver;
        }

        private static void setDriver(WebDriver driver) {
            DriverManager.driver = driver;
        }

    }

