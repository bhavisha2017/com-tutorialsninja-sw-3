package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        //Mouse Hover on "Desktops" Tab and click
        WebElement deskTops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(deskTops).click().build().perform();


        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");

        //3 Verify the text ‘Desktops’
        String actualMessage = getTextFromElement(By.xpath("//a[normalize-space()='Desktops']"));
        verifyingTheText("Desktops",actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        //Mouse hover on “Laptops & Notebooks” Tab and click
        WebElement laptopsAndNoteBooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptopsAndNoteBooks).click().build().perform();

        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //Verify the text ‘Laptops & Notebooks’
        String actualMessage = getTextFromElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        verifyingTheText("Laptops & Notebooks",actualMessage);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //Mouse hover on “Components” Tab and click
        WebElement components = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(components).click().build().perform();

        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        //Verify the text ‘Components’
        String actualMessage = getTextFromElement(By.xpath("//a[normalize-space()='Components']"));
        verifyingTheText("Components",actualMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
