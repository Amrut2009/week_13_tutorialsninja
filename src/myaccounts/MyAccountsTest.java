package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String menu) {
        String exp = String.format("//a[text()='%s']", menu);
        driver.findElement(By.xpath("exp")).click();
    }

    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1 Click on My Account Link.
        mouseHoverToElementAndClick(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //Verify the text “Register Account”
        verifyText(By.xpath("//h2[text()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //.1 Click on My Account Link
        clickOnElement(By.xpath("//div[@id='top-links']"));

        //2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");

        //3 Verify the text “Returning Customer”.
verifyText(By.xpath("//h2[text()='Returning Customer']"),"Returning Customer");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));


        // Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        selectMyAccountOptions("Register");

        //.3 Enter First Name
        sendTextToElement(By.id("First Name"),"John");

       // 3.4 Enter Last Name
        sendTextToElement(By.id("Last Name")," Smith");

       // 3.5 Enter Email
        sendTextToElement(By.id("E-Mail"),"SmithJohn@hotmail.com");

       // 3.6 Enter Telephone
        sendTextToElement(By.id("Telephone"),"07378539512");
        //3.7 Enter Password
        sendTextToElement(By.id("Password"),"Smith12345@");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("Password Confirm"),"Smith12345@");
        //3.9 Select Subscribe Yes radio button
        sendTextToElement(By.id("radio button"),"No");
       // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("agree"));
       // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));


        //3.12 Verify the message “Your Account Has Been Created!”
        verifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");
        //3.13 Click on Continue button

       // 3.14 Click on My Account Link.
        //clickOnElement(By."");
        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
         // “Logout”
        //3.16 Verify the text “Account Logout”

        //3.17 Click on Continue
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        //4.1 Click on My Account Link.
clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/aside[1]/div[1]/a[4]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
            //“Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.id("Email"),"SmithJohn@hotmail.com");
        //4.4 Enter Last Name
        sendTextToElement(By.id("Last Name"),"Smith");
        //4.5 Enter Password
        sendTextToElement(By.id("password"),"Smith12345@");
        //4.6 Click on Login button
        clickOnElement(By.id("Login button"));
        //4.7 Verify text “My Account”
        verifyText(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]"),"My Account");

        //4.8 Click on My Account Link.
        clickOnElement(By.id("//body/div[@id='account-account']/div[2]/aside[1]/div[1]/a[1]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”

        //4.10 Verify the text “Account Logout”
        verifyText(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
