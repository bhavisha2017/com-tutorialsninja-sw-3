package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        // Mouse hover on Desktops Tab.and click
        //Click on “Show All Desktops”
        WebElement deskTops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement showAllDesktops = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        hoverOnElements(deskTops, showAllDesktops);

        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        // Verify the Product will arrange in Descending order
        List<WebElement> productNameElements = driver.findElements(By.cssSelector(".product-layout .caption h4 a"));
        int count = productNameElements.size();
        for (int i = 0; i < count - 1; i++) {
            String productName1 = productNameElements.get(i).getText();
            String productName2 = productNameElements.get(i + 1).getText();
            Assert.assertTrue(productName1.compareToIgnoreCase(productName2) >= 0);
            Thread.sleep(200);

        }
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Mouse hover on Desktops Tab. and click
        //2.2 Click on “Show All Desktops”
        WebElement deskTops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement showAllDesktops = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        hoverOnElements(deskTops, showAllDesktops);

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//img[@title='HP LP3065']"));

        //2.5 Verify the Text "HP LP3065"
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
        verifyingTheText("HP LP3065", actualMessage);

        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        while (true) {

            String monthYear1 = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            System.out.println(monthYear1); // November 2022
            String[] a = monthYear1.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]")); // /html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]
            }
        }
        //Logic to select date -
        List<WebElement> allDates = driver.findElements(By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
            //2.7.Enter Qty "1” using Select class.
            clearQty(By.xpath("//input[@id='input-quantity']"));
            sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

            //2.8 Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));

            //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            String actualMessage1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            verifyingTheText("Success: You have added HP LP3065 to your shopping cart!" + "\n×", actualMessage1);

            // 2.10 Click on link “shopping cart” display into success message
            clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));

            //2.11 Verify the text "Shopping Cart"
            String actualMessage2 = getTextFromElement(By.linkText("shopping cart"));
            verifyingTheText("shopping cart", actualMessage2);

            //2.12 Verify the Product name "HP LP3065"
            String actualMessage3 = getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
            verifyingTheText("HP LP3065", actualMessage3);

            //2.13 Verify the Delivery Date "2022-11-30"
            String actualMessage4 = getTextFromElement(By.xpath("//input[@id='input-option225']"));
            Thread.sleep(2000);
            // verifyingTheText("2022-11-30", actualMessage4);
            //2.14 Verify the Model "Product21"
            String actualMessage5 = getTextFromElement(By.xpath("//li[normalize-space()='Product Code:Product 21']"));
            verifyingTheText("Product 21", actualMessage5);

            //2.15 Verify the Total "£74.73"
            selectByVisibleTextFromDropDown(By.xpath("//span[normalize-space()='Currency']"), "Currency");
            String actualMessage6 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]"));
            verifyingTheText("£74.73", actualMessage6);
              Thread.sleep(2000);
        }
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
