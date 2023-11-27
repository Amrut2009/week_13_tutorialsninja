package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class DeskTopsTest extends Utility {
    String baseUrl="http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }@Test
    public void  verifyProductArrangeInAlphaBaticalOrder(){
        //Mouse hover on Desktops Tab.and click
mouseHoverToElementAndClick(By.xpath(" 1 Rel XPath //body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
// Select Sort By position "Name: Z to A"
selectByVisibleText(By.xpath("//select[@id='input-sort']"),"Name: Z to A");
        //.4 Verify the Product will arrange in Descending order
verifyText(By.xpath("//option[contains(text(),'Name (Z - A)')]"),"name(Z-A)");

    }
    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //1 Mouse hover on Laptops & Notebooks Tab and click
mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // Click on “Show All Laptops & Notebooks”
clickOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));
        //3 Select Sort By "Price (High > Low)"
selectByValueFromDropDown(By.xpath("#input-sort"),"Price (High > Low)");
        //.4 Select Product “MacBook
selectByValueFromDropDown(By.xpath(" //a[normalize-space()='MacBook']"),"MacBook");
      //  2.5 Verify the text “MacBook”
        Thread.sleep(3000);
verifyText(By.xpath(" //a[normalize-space()='MacBook']"),"MacBook");
        //6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[2]/button[1]/span[1]"));
        //.7 Verify the message “Success: You have added MacBook to your shopping cart!”
verifyText(By.xpath(" //body/div[@id='common-home']/div[1]")," You have added MacBook to your shopping cart!");

        //.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[@id='cart-total']"));

        //.9 Verify the text "Shopping Cart"
verifyText(By.xpath("//h1[contains(text(),'Shopping Cart')"),"Shopping Cart");

       // 10 Verify the Product name "MacBook"
        verifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");

        //2.11 Change Quantity "2"
        verifyText(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");

        //.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]") );

//.13 Verify the message “Success: You have modified your shopping cart"
        verifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"),"Success: You have modified your shopping cart!");


        //4 Verify the Total £737.45
verifyText(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),"total");

//.15 Click on “Checkout” button"
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //.16 Verify the text “Checkout”
        verifyText(By.xpath("//a[contains(text(),'Checkout')]"),"Checkout");

        //.17 Verify the Text “New Customer”
        verifyText(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");
//.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //20 Fill the mandatory fields
        sendTextToElement(By.id("First Name"),"John");
        sendTextToElement(By.id("Last Name"),"Smith");
        sendTextToElement(By.id("E-Mail"),"SmithJohn@hotmail.com");
        sendTextToElement(By.id("Password"),"Smith12345@");
        sendTextToElement(By.id("Password Confirm"),"Smith12345@");
        sendTextToElement(By.id("Telephone"),"07378539512");
        sendTextToElement(By.id("Address 1"),"langley road");
        sendTextToElement(By.id("City"),"london");
        sendTextToElement(By.id("Post Code"),"sl25en");
        selectByValueFromDropDown(By.id("Country"),"United Kingdom");
        selectByValueFromDropDown(By.id("Region / State"),"Berkshire");

        //.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-register']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//strong[contains(text(),'Add Comments About Your Order')]"),"Add Comments About Your Order");

        //.23 Check the Terms & Conditions check box
sendText(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]"),"Terms & Conditions");
//2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

//.25 Verify the message “Warning: Payment method required!"
        verifyText(By.xpath("//body/div[@id='checkout-checkout']"),"Warning: Payment method required!");


    }
    @After
    public void tearDown(){
        closeBrowser();
    }



}
