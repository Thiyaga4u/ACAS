package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.StoreQAUtil.waitforElement;


public class ProfilePage {

    private final WebDriver driver;

    // locators
    private final By employeeLink = By.xpath("//span[text()='Employee']");
    private final By viewEmployeeLink = By.xpath("//a[text()='View Employee']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeePage clickViewEmployee() {
        waitforElement(driver, employeeLink);
        driver.findElement(employeeLink).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(viewEmployeeLink).click();
        return new EmployeePage(driver);
    }

}
