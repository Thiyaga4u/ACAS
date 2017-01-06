package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import static util.StoreQAUtil.waitforElement;

public class EmployeePage {

    private final WebDriver driver;

    // locators
    private final By addEmployeeLocator =By.xpath("//i[@class='fa fa-plus-square']");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public AddEmployeePage clickAddEmployee() {
        waitforElement(driver, addEmployeeLocator);
        driver.findElement(addEmployeeLocator).click();
        return new AddEmployeePage(driver);
    }

}
