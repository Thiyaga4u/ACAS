package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.StoreQAUtil.waitforElement;

public class ViewEmployeePage {

    private final WebDriver driver;

    // locators
    private final By messageLocator =By.id("message");

    // locators
    private final By transactionLink = By.xpath("//span[text()='Transaction']");
    private final By addtransactionLink = By.xpath("//a[text()='Add Transaction']");

    public ViewEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        String s = driver.findElement(messageLocator).getText();
        return s;
    }

    public AddTransactionPage clickViewEmployee() {
        waitforElement(driver, transactionLink);
        driver.findElement(transactionLink).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(addtransactionLink).click();
        return new AddTransactionPage(driver);
    }



}
