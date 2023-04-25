package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        //1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement laptopsAndNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptopsAndNotebooks).click().build().perform();

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        String expectedMessage = "Price (High > Low)";
        String actualMessage = driver.findElement(By.xpath("//option[contains(text(),'Price (High > Low)')]")).getText();

        if (actualMessage.contains(expectedMessage)) {
            System.out.println("PASS: Product price arranged in High to Low order");
        } else {
            System.out.println("FAIL: Product price NOT arranged in High to Low order");
        }
    }
    @Test
    public void  verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

         //2.1 Mouse hover on Laptops & Notebooks Tab and click
        WebElement laptopsAndNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptopsAndNotebooks).click().build().perform();

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//img[@title='MacBook']"));

        //2.5 Verify the text “MacBook”
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        verifyingTheText("MacBook",actualMessage);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualMessage1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        verifyingTheText( "Success: You have added MacBook to your shopping cart!"+"\n×", actualMessage1);

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.9 Verify the text "Shopping Cart"
        verifyText("Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"), "Shopping Cart");

        //2.10 Verify the Product name "MacBook"
        verifyText("MacBook", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");

        //2.11 Change Quantity "2"
        By qut1 = By.xpath("//td//input[@type='text']");
        sendTextToElement(qut1,"2");

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualMessage4 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        verifyingTheText( "Success: You have modified your shopping cart!"+"\n×", actualMessage4);

        //2.14 Verify the Total £737.45
        clickOnElement(By.id("form-currency"));
        clickOnElement(By.name("GBP"));
        String actualMessage5 = getTextFromElement(By.xpath("//tbody//tr//td[6]"));
        verifyingTheText( "£737.45", actualMessage5);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        String actualMessage6 = getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        verifyingTheText( "Checkout", actualMessage6);

        //2.17 Verify the Text “New Customer”
        String actualMessage7 = getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        verifyingTheText( "New Customer", actualMessage7);

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
         Thread.sleep(2000);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"),"Prime");
        sendTextToElement(By.name("lastname"),"Testing");
        sendTextToElement(By.id("input-payment-email"),"prime12AB@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"),"02088693750");
        sendTextToElement(By.name("address_1"),"111 abc road");
        sendTextToElement(By.name("city"),"London");
        sendTextToElement(By.name("postcode"),"HA2 9SE");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"),"United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"),"Bedfordshire");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        clickOnElement(By.xpath("//textarea[@name='comment']"));

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required
        String actualMessage8 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        verifyingTheText( "Warning: Payment method required!"+"\n×", actualMessage8);
        Thread.sleep(2000);
    }
    @After
    public void tearDown(){
       closeBrowser();
    }


}
