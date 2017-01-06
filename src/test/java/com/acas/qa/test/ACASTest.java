package com.acas.qa.test;

import bsh.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;


public class ACASTest {

    private WebDriver driver;

    private static final String BASEURL = "http://www.garampopcorn.com/survey_reporteditor2112pdf/index.php/";
    public static String chromeDriverPath = "C:\\Users\\taramu1\\Documents\\thiyaga\\Dump\\ThiyagaLaptopBackup\\HomeAwayPOC\\StoreQATest\\ChromeDriver\\";

    @BeforeClass
    public void setUp() throws Exception {
       //driver = new FirefoxDriver();
       System.setProperty("webdriver.chrome.driver", chromeDriverPath+"chromedriver.exe");
		driver = new ChromeDriver();
        System.out.println("driver path is...."+chromeDriverPath);
		driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void loginPageACAS() throws Exception {
        System.out.println("Test" + BASEURL);

        driver.get(BASEURL);
        String username = "nathan.m@agalsolutions.com";
        String password = "agal@1234";
        // home page
        LoginPage loginPage = new LoginPage(driver);

        // log in
        loginPage.typeUserId(username);
        loginPage.typePwd(password);

        ProfilePage profilePage = loginPage.clickLogin();
        Thread.sleep(10000);
    }

    @Test
    public void viewEmployeeACAS() throws Exception {

        //driver.get(BASEURL);
        ProfilePage profilePage = new ProfilePage(driver);

        EmployeePage employeePage = profilePage.clickViewEmployee();
        //employeePage.clickAddEmployee();
        Thread.sleep(10000);
    }

    @Test
    public void addEmployeeACAS() throws Exception {
        //driver.get(BASEURL);
        EmployeePage employeePage = new EmployeePage(driver);

        AddEmployeePage addemployeePage = employeePage.clickAddEmployee();
        Thread.sleep(10000);
        addemployeePage.selectGender("Male");
        addemployeePage.selectManager("AMPL");
        addemployeePage.selectManagementLevel("LOW");
        addemployeePage.selectRole("Employee");
        addemployeePage.selectIsManager("Yes");

        addemployeePage.addFirstName("Nathan");
        addemployeePage.addLastName("Swaminathan");
        addemployeePage.addMiddleName("Murali");

        Random random = new Random();
        int index = random.nextInt(1000000);
        String empNo = Integer.toString(index);
        addemployeePage.addEmpNo(empNo);

        Thread.sleep(10000);
        addemployeePage.addPassword("agal@4567");
        addemployeePage.addConfirmPassword("agal@4567");
        addemployeePage.addDOB("12/06/2016");

        Random randomNumber = new Random();
        int randomNum = random.nextInt(100);
        String randomNmbr = Integer.toString(randomNum);
        String emailID = "nathan.kumar" + randomNmbr + "@agalsolutions.com";
        addemployeePage.addEmail(emailID);
        Thread.sleep(10000);

        ViewEmployeePage viewEmployeePage = addemployeePage.clickSubmitEmployee();
        String actualMessage = viewEmployeePage.getMessage();
        String expectedMessage = "×\n" +
                "Employee \"NATHAN\" Inserted Successfully";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void addTransactionACAS() throws Exception {
        //driver.get(BASEURL);
        ViewEmployeePage viewEmployeePage = new ViewEmployeePage(driver);

        AddTransactionPage addTransactionPage = viewEmployeePage.clickViewEmployee();
        Thread.sleep(10000);
        addTransactionPage.addTransactionName("Testing Transaction");
        addTransactionPage.selectAssessment("DRG");
        addTransactionPage.selectReport("Yes");
        addTransactionPage.addDescription("Transaction Test");
        addTransactionPage.addEndDate("01/06/2019");
        addTransactionPage.clickSaveTransaction();
        Thread.sleep(10000);

        addTransactionPage.selectParticipanType("Applicant");
        addTransactionPage.addFirstName("Swamy");
        addTransactionPage.addLastName("KS");
        addTransactionPage.selectGender("Male");


        Random ranNumber = new Random();
        int rdomNum = ranNumber.nextInt(100);
        String rNmbr = Integer.toString(rdomNum);
        String emailIDParticipant =  "nathan.kumar"+rNmbr+"@agalsolutions.com";
        addTransactionPage.addEmail(emailIDParticipant);
        Thread.sleep(10000);

        addTransactionPage.addExp("6");
        addTransactionPage.addComments("Participant Test");
        addTransactionPage.addAge("33");
        addTransactionPage.selectEducation("Doctorate");
        TransactionSearchPage transactionSearchPage = addTransactionPage.clickSaveParticipant();
    }

    @Test
    public void searchEmployeeACAS() throws Exception {
        //driver.get(BASEURL);
        TransactionSearchPage transactionSearchPage = new TransactionSearchPage(driver);

        Thread.sleep(10000);
        transactionSearchPage.clickTransactionSearch();
        Thread.sleep(10000);
        transactionSearchPage.addTransactionSearch("TESTING TRANSACTION");
        Thread.sleep(10000);

        String actualSearchResult = transactionSearchPage.getSearchResults();
        String expectedSearchResult = "TESTING TRANSACTION";
        assertEquals(expectedSearchResult, actualSearchResult);
    }

}