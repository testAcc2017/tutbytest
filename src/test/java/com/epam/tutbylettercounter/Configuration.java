package com.epam.tutbylettercounter;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class Configuration {
    private final static String URL = "http://epbyminw2454:4444/wd/hub/";
    protected WebDriver driver;
    private URL url;

    @BeforeTest
    @Parameters({"browserType", "platform"})
    public void initBrowser(String browserType, String platform) {
        //initialize FireFox
        if ("firefox".equalsIgnoreCase(browserType)) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            if ("windows".equalsIgnoreCase(platform)) {
                capability.setPlatform(Platform.WIN10);
            } else if ("linux".equalsIgnoreCase(platform)) {
                capability.setPlatform(Platform.LINUX);
            } else System.out.println("Unknown platform");
            try {
                url = new URL(URL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(url, capability);
            driver.manage().window().maximize();
        } else
            //initialize Chrome
            if ("chrome".equalsIgnoreCase(browserType)) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                if ("windows".equalsIgnoreCase(platform)) {
                    capability.setPlatform(Platform.WIN10);
                    capability.setCapability(ChromeOptions.CAPABILITY, options);
                } else if ("linux".equalsIgnoreCase(platform)) {
                    capability.setPlatform(Platform.LINUX);
                    capability.setCapability(ChromeOptions.CAPABILITY, options);
                } else System.out.println("Unknown platform");

                try {
                    url = new URL(URL);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, capability);
            } else
                //initialize InternetExplorer
                if ("ie".equalsIgnoreCase(browserType) || "internetexplorer".equalsIgnoreCase(browserType) || "internet explorer".equalsIgnoreCase(browserType)) {
                    DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                    if ("windows".equalsIgnoreCase(platform)) {
                        capability.setPlatform(Platform.WINDOWS);
                    } else if ("linux".equalsIgnoreCase(platform)) {
                        capability.setPlatform(Platform.LINUX);
                    } else System.out.println("Unknown platform");

                    try {
                        url = new URL(URL);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new RemoteWebDriver(url, capability);
                    driver.manage().window().maximize();
                }
    }
}
