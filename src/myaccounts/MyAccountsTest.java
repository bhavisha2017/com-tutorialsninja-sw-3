package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
       //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        verifyingTheText("Register Account",actualMessage);
         Thread.sleep(2000);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //2.3 Verify the text “Returning Customer”.
        String actualMessage1 = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        verifyingTheText("Returning Customer",actualMessage1);
        Thread.sleep(2000);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"),"Prime");

        //3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"),"Testing");

        //3.5 Enter Email
        sendTextToElement(By.id("input-email"),"prime12224AB@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"),"02088693750");

        //3.7 Enter Password
        sendTextToElement(By.id("input-password"),"prime123AC");

        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"),"prime123AC");

        //3.9 Select Subscribe Yes radio button
       clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        String actualMessage1 = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        verifyingTheText("Your Account Has Been Created!",actualMessage1);

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
          selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”
        String actualMessage2 = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyingTheText("Account Logout",actualMessage2);

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(2000);

    }@Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
         // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"prime1234AB@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.id("input-password"),"prime123AC");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        verifyingTheText("My Account",actualMessage);

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        String actualMessage1 = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyingTheText("Account Logout",actualMessage1);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(2000);
    }
    @After
    public void tearDown(){
    //    closeBrowser();
    }
}
