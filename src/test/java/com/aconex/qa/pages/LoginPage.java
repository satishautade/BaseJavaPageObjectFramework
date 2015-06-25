package com.aconex.qa.pages;

import com.aconex.qa.DriverManager;
import com.aconex.qa.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LoadableComponent<LoginPage> {

    private final WebDriver driver;
    private final String pageUrl;

    @FindBy(how=How.ID,using = "userName" )
    WebElement username;

    @FindBy(how=How.ID,using = "password" )
    WebElement password;

    @FindBy(how=How.ID,using = "login" )
    WebElement loginButton;


    public LoginPage(){
        this.driver= DriverManager.getDriver();
        this.pageUrl= PropertyReader.getAppUrl();
        PageFactory.initElements(driver, this);
        this.get();
    }

    @Override
    protected void load() {
        driver.get(pageUrl);
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl=driver.getCurrentUrl();
        if(!currentUrl.equalsIgnoreCase(pageUrl)){
            driver.get(pageUrl);
        }
    }

    public TasksPage login(String username, String password){
        this.username.clear();
        this.username.sendKeys(username);

        this.password.clear();
        this.password.sendKeys(password);

        loginButton.click();

        WebDriverWait wait = new WebDriverWait(this.driver,10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By.id("frameMain"))));

        return new TasksPage();
    }


    public void close() throws InterruptedException {
        Thread.sleep(5000); //should never be used inside a test
        this.driver.close();
    }
}
