package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//div/ul/li/a[text()='Desktops']"));

        //2 call selectMenu method and pass the menu = “Show All Desktops"
        selectMenu("Show All Desktops");

        //Verify the text ‘Desktops’
        verifyText(By.xpath("//h2[text()='Desktops']"), "Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        // Mouse hover on “Laptops & Notebooks” Tab and click
mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        // call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");

        //3 Verify the text ‘Laptops & Notebooks'
        verifyText(By.xpath("//h2[text()='Laptops & Notebooks']"),"Laptops & Notebooks");

    }
    @Test
    public void  verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click


//2 call selectMenu method and pass the menu = “Show All Components
        selectMenu("Show All Components");


        //.3 Verify the text ‘Components’

        verifyText(By.xpath("//h2[text()='Components']"),"Components");
    }
    @After
    public   void tearDown(){
        closeBrowser();
    }
    }



