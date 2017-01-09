package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import static util.StoreQAUtil.waitforElement;

public class AddEmployeePage {

    private final WebDriver driver;

    // locators
    private final By firstnameLocator = By.id("first_name");
    private final By lastnameLocator = By.id("last_name");
    private final By middlenameLocator = By.id("middle_name");
    private final By empnoLocator = By.id("emp_no");
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("password");
    private final By confirmpasswordLocator = By.id("confirm_password");
    private final By submitAddEmployeeLocator = By.id("insert_button");

    private final By genderLocator = By.id("gender");
    private final By managerLocator = By.id("manager_id");
    private final By managementlevelLocator = By.id("management_level");
    private final By roleLocator = By.id("access");
    private final By ismanagerLocator = By.id("is_manager");
    private final By dobLocator = By.id("date_of_birth");

    private final By FirstNamevalidnMsg = By.xpath("//small[text()='First name should contain characters only']");
    private final By LastNamevalidnMsg = By.xpath("//small[text()='Last name should contain characters only']");
    private final By MiddleNamevalidnMsg = By.xpath("//small[text()='Middle name should contain characters only']");


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }


    public AddEmployeePage addFirstName(String firstname) {
        waitforElement(driver, firstnameLocator);
        driver.findElement(firstnameLocator).clear();
        driver.findElement(firstnameLocator).sendKeys(firstname);
        return this;
    }

    public AddEmployeePage addLastName(String lastname) {
        waitforElement(driver, lastnameLocator);
        driver.findElement(lastnameLocator).clear();
        driver.findElement(lastnameLocator).sendKeys(lastname);
        return this;
    }

    public AddEmployeePage addMiddleName(String middlename) {
        waitforElement(driver, middlenameLocator);
        driver.findElement(middlenameLocator).clear();
        driver.findElement(middlenameLocator).sendKeys(middlename);
        return this;
    }

    public AddEmployeePage addEmpNo(String empno) {
        waitforElement(driver, empnoLocator);
        driver.findElement(empnoLocator).sendKeys(empno);
        return this;
    }

    public AddEmployeePage addEmail(String email) {
        waitforElement(driver, emailLocator);
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public AddEmployeePage addPassword(String password) {
        waitforElement(driver, passwordLocator);
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }


    public AddEmployeePage addConfirmPassword(String confirmpassword) {
        waitforElement(driver, confirmpasswordLocator);
        driver.findElement(confirmpasswordLocator).sendKeys(confirmpassword);
        return this;
    }

    public AddEmployeePage addDOB(String dob) {
        waitforElement(driver, dobLocator);
        driver.findElement(dobLocator).sendKeys(dob);
        return this;
    }


    public AddEmployeePage selectGender(String gender) {
        Select dropdown = new Select(driver.findElement(genderLocator));
        dropdown.selectByVisibleText(gender);
        return this;
    }

    public AddEmployeePage selectManager(String manager) {
        Select dropdown = new Select(driver.findElement(managerLocator));
        dropdown.selectByVisibleText(manager);
        return this;
    }

    public AddEmployeePage selectManagementLevel(String managementlevel) {
        Select dropdown = new Select(driver.findElement(managementlevelLocator));
        dropdown.selectByVisibleText(managementlevel);
        return this;
    }

    public AddEmployeePage selectRole(String role) {
        Select dropdown = new Select(driver.findElement(roleLocator));
        dropdown.selectByVisibleText(role);
        return this;
    }

    public AddEmployeePage selectIsManager(String ismanager) {
        Select dropdown = new Select(driver.findElement(ismanagerLocator));
        dropdown.selectByVisibleText(ismanager);
        return this;
    }

    //Change the return type page name
    public ViewEmployeePage clickSubmitEmployee() {
        waitforElement(driver, submitAddEmployeeLocator);
        driver.findElement(submitAddEmployeeLocator).click();
        return new ViewEmployeePage(driver);
    }

    public String getFirstNamevalidnMsg() {
        String s = driver.findElement(FirstNamevalidnMsg).getText();
        return s;
    }

    public String getLastNamevalidnMsg() {
        String s = driver.findElement(LastNamevalidnMsg).getText();
        return s;
    }

    public String getMiddleNamevalidnMsg() {
        String s = driver.findElement(MiddleNamevalidnMsg).getText();
        return s;
    }


}
