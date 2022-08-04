package org.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHelperMethods {

    private WebDriver driver;

    public void initChromeWebBrowser(){
        System.setProperty("webdriver.chrome.driver", Locators.chrome_web_driver_location);
        driver = new ChromeDriver();
    }

    public void getURL(String url){
        driver.get(url);
    }

    public void enterLoginCredentials(String user, String password){
        driver.findElement(By.id(Locators.login_username_id)).sendKeys(user);
        driver.findElement(By.id(Locators.login_password_id)).sendKeys(password);
        driver.findElement(By.xpath(Locators.login_button_xpath)).click();
    }

    public String grabSecureAreaText(){
        String secureAreaText = driver.
                findElement(By.xpath(Locators.secure_area_text_xpath)).getText();
        System.out.println("secureAreaText: " + secureAreaText);
        driver.close();
        return secureAreaText;
    }

    public String grabLoginErrorMessage(){
        String loginErrorMessageText = driver.
                findElement(By.xpath(Locators.long_error_message_xpath)).getText();
        loginErrorMessageText = loginErrorMessageText.replaceAll("\n.", "");
        System.out.println("loginErrorMessageText: " + loginErrorMessageText);
        driver.close();
        return loginErrorMessageText;
    }
}
