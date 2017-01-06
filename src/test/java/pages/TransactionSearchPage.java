package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.StoreQAUtil.waitforElement;


public class TransactionSearchPage {

    private final WebDriver driver;


    private final By transactionLink = By.xpath("//span[text()='Transaction']");
    private final By transactionSearchLink = By.xpath("//a[text()='Transaction Search']");
    private final By transactionSearchTextLocator = By.xpath(".//*[@id='transaction_all_filter']/label/input");
    private final By searchResultsLocator = By.xpath("//*[@id='transaction_all']/tbody/tr[1]/td[2]");

    public TransactionSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public TransactionSearchPage clickTransactionSearch() {
        waitforElement(driver, transactionLink);
        driver.findElement(transactionLink).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(transactionSearchLink).click();
        return this;
    }

    public TransactionSearchPage addTransactionSearch(String search) {
        waitforElement(driver, transactionSearchTextLocator);
        driver.findElement(transactionSearchTextLocator).sendKeys(search);
        return this;
    }

    public String getSearchResults() {
        String s = driver.findElement(searchResultsLocator).getText();
        return s;
    }
}
