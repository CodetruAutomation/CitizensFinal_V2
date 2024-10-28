/*
 * Copyright (c) 2016.
 * Automation Framework Selenium - Codetru
 */

package com.codetru.driver;


import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;



public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createDriver() {
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu"); // Ensure headless mode is set
            options.addArguments("window-size=1800,900");
            // Add other arguments as necessary
            return options;
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // Ensure headless mode is set
            return options;
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu"); // Ensure headless mode is set
            return options;
        }
    },
    SAFARI {
        @Override
        public WebDriver createDriver() {
            return new SafariDriver(getOptions());
        }

        @Override
        public SafariOptions getOptions() {
            SafariOptions options = new SafariOptions();
            // Safari does not support headless mode
            return options;
        }
    };

    // Abstract methods
    public abstract WebDriver createDriver();
    public abstract MutableCapabilities getOptions();
}
