package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.livesust.locators.SignInPage;
import com.livesust.testbase.TestBase;
import com.livesust.utils.TestUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInPageStep extends TestBase{
	
	SignInPage Signin;
	SignInPage signin = new SignInPage();
	
	@Given("^user is on signin screen$")
	public void userIsOnSigninScreen() throws Throwable {
		try {
			//openapp
			Thread.sleep(2000);
			TestUtils.selectBrowser();	
			System.out.println("Livesust Website is launched");
			
			}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Livesust Website");
		}
	}
	@When("^user enter the values (.*) and (.*)$")
	public void userEnterTheValuesAnd(String email,String password) throws Throwable {
		try {
			Thread.sleep(2000);
			clickelement(SignInPage.Email);
			sendKeystoElement(SignInPage.Email,email);
			System.out.println("Email is entered");
			Thread.sleep(2000);
			clickelement(SignInPage.Password);
			sendKeystoElement(SignInPage.Password,password);
			System.out.println("Password is entered");
			clickelement(SignInPage.EyeIcon);
			System.out.println("password is shown");
			clickelement(SignInPage.RememberMe);
			Thread.sleep(1000);
			clickelement(SignInPage.EyeIcon);
			System.out.println("password is hidden");

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Livesust Website");
		}
	}
	@Then("^user click on login button$")
	public void userClickOnLoginButton() throws Throwable {
		try {
			Thread.sleep(1000);
			clickelement(SignInPage.LogInBtn);
			System.out.println("Clicked signin button");
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Deelchat application");
		}
	}
	
	
	@And("^assert the error message for unregistered email credential$")
	public void assertTheErrorMessageForUnregisteredEmailCredential() throws Throwable {
		try {
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
				String validationText = validation.substring(1).trim();
				System.out.println("error message:"+validationText);
				System.out.println("error message:"+SignInPage.InvalidEmailMsg);
				Assert.assertEquals(validationText,SignInPage.InvalidEmailMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.InvalidEmailMsg );
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Livesust Website");
		}
	}
	
	@And("^assert the error message for without credential$")
	public void assertTheErrorMessageForWithoutCredential() throws Throwable {
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,SignInPage.EnterEmailMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.EnterEmailMsg );
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Livesust Website");
		}
	}
	
	@And("^assert the error message for without enter email$")
	public void assertTheErrorMessageForWithoutEnterEmail() throws Throwable {
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				System.out.println("error message:"+SignInPage.InvalidUsernameMsg);
				Assert.assertEquals(validationText,SignInPage.InvalidUsernameMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.InvalidUsernameMsg);
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Livesust Website");
		}
	}
	
	@And("^assert the error message for without enter password$")
	public void assertTheErrorMessageForWithoutEnterPassword() throws Throwable {
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,SignInPage.EnterPasswordMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.EnterPasswordMsg );
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Livesust Website");
		}
	}
	
	
	@And("^assert the error message for invalid email credential$")
	public void assertTheErrorMessageForInvalidEmailCredential() throws Throwable {
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,SignInPage.WrongFormat);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.WrongFormat);
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to logged with invalid email");
		}
	}

	@And("assert the error message for invalid password credential")
	public void assertTheErrorMessageForInvalidPasswordCredential() {
		try {
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
				String validationText = validation.substring(1).trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,SignInPage.InvalidPasswordMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.InvalidPasswordMsg );
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to logged with invalid password");
		}

	}
	
	@And("^check the user is successfully logged into app$")
	public void checkTheUserIsSuccessfullyLoggedintoApp() throws Throwable {
		try {
			System.out.println("User successfully logged into app");
			Thread.sleep(1000);		
			
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
				String validationText = validation.substring(1).trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,SignInPage.SuccessMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.SuccessMsg );
			}
			close();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to logged into app");
		}
	}

}
