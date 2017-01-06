package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static util.StoreQAUtil.waitforElement;

public class AddTransactionPage {

    private final WebDriver driver;

    // locators
    private final By transactionnameLocator = By.id("transaction_name");
    private final By descriptionLocator = By.id("description");


    private final By assessmentLocator = By.id("requested_product");
    private final By sendreportLocator = By.id("send_report");
    private final By todateLocator = By.id("to_date");

    private final By transactionSaveLocator = By.id("transaction_save");


    private final By participanTypeLocator = By.id("participant_type");


    private final By firstnameLocator = By.id("first_name");
    private final By lastnameLocator = By.id("last_name");
    private final By dobLocator = By.id("date_of_birth");
    private final By ageLocator = By.id("age");
    private final By emailLocator = By.id("email");
    private final By exp_yrsLocator = By.id("exp_yrs");
    private final By commentsLocator = By.id("comments");


    private final By genderLocator = By.id("gender");
    private final By max_edLocator = By.id("max_ed");
    private final By sequence_saveLocator = By.id("sequence_save");


    public AddTransactionPage(WebDriver driver) {
        this.driver = driver;
    }


    public AddTransactionPage addTransactionName(String firstname) {
        waitforElement(driver, transactionnameLocator);
        driver.findElement(transactionnameLocator).sendKeys(firstname);
        return this;
    }

    public AddTransactionPage addDescription(String lastname) {
        waitforElement(driver, descriptionLocator);
        driver.findElement(descriptionLocator).sendKeys(lastname);
        return this;
    }


    public AddTransactionPage selectAssessment(String assesssment) {
        Select dropdown = new Select(driver.findElement(assessmentLocator));
        dropdown.selectByVisibleText(assesssment);
        return this;
    }

    public AddTransactionPage selectReport(String report) {
        Select dropdown = new Select(driver.findElement(sendreportLocator));
        dropdown.selectByVisibleText(report);
        return this;
    }

    public AddTransactionPage addEndDate(String endDate) {
        waitforElement(driver, todateLocator);
        driver.findElement(todateLocator).sendKeys(endDate);
        return this;
    }


    //Change the return type page name
    public ViewEmployeePage clickSaveTransaction() {
        waitforElement(driver, transactionSaveLocator);
        driver.findElement(transactionSaveLocator).click();
        return new ViewEmployeePage(driver);
    }

    public AddTransactionPage addFirstName(String firstname) {
        waitforElement(driver, firstnameLocator);
        driver.findElement(firstnameLocator).sendKeys(firstname);
        return this;
    }
    public AddTransactionPage addLastName(String lastname) {
        waitforElement(driver, lastnameLocator);
        driver.findElement(lastnameLocator).sendKeys(lastname);
        return this;
    }
    public AddTransactionPage addDOB(String dob) {
        waitforElement(driver, dobLocator);
        driver.findElement(dobLocator).sendKeys(dob);
        return this;
    }
    public AddTransactionPage addAge(String age) {
        waitforElement(driver, ageLocator);
        driver.findElement(ageLocator).sendKeys(age);
        return this;
    }
    public AddTransactionPage addEmail(String email) {
        waitforElement(driver, emailLocator);
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }
    public AddTransactionPage addExp(String expyrs) {
        waitforElement(driver, exp_yrsLocator);
        driver.findElement(exp_yrsLocator).sendKeys(expyrs);
        return this;
    }
    public AddTransactionPage addComments(String comments) {
        waitforElement(driver, commentsLocator);
        driver.findElement(commentsLocator).sendKeys(comments);
        return this;
    }



    public AddTransactionPage selectGender(String gender) {
        Select dropdown = new Select(driver.findElement(genderLocator));
        dropdown.selectByVisibleText(gender);
        return this;
    }


    public AddTransactionPage selectEducation(String education) {
        Select dropdown = new Select(driver.findElement(max_edLocator));
        dropdown.selectByVisibleText(education);
        return this;
    }
    public AddTransactionPage selectParticipanType(String participant) {
        Select dropdown = new Select(driver.findElement(participanTypeLocator));
        dropdown.selectByVisibleText(participant);
        return this;
    }


    //Change the return type page name
    public TransactionSearchPage clickSaveParticipant() {
        waitforElement(driver, sequence_saveLocator);
        driver.findElement(sequence_saveLocator).click();
        return new TransactionSearchPage(driver);
    }

}
