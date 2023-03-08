package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.livesust.locators.ForgotPasswordPage;
import com.livesust.locators.SignInPage;
import com.livesust.testbase.TestBase;
import com.livesust.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPageStep extends TestBase {
	
	ForgotPasswordPage ForgotPassword;
	ForgotPasswordPage forgotpassword = new ForgotPasswordPage();
	
	@Given("^user is on forgotpassword screen$")
	public void userIsOnForgotPasswordScreen() throws Throwable {
		try {
			//openapp
			Thread.sleep(2000);
			TestUtils.selectBrowser();	
			System.out.println("Yikes Website is launched");
			
			explicitwaitvisible(ForgotPasswordPage.ForgotPassword);
			clickelement(ForgotPasswordPage.ForgotPassword);
				
			}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Deelchat application");
		}
	}

	@When("^user enter the valid forgotpassword email (.*)$")
	public void userEnterTheValidForgotPasswordEmail(String email) throws Throwable {
		try {
			Thread.sleep(2000);
			explicitwaitvisible(ForgotPasswordPage.EmailAddress);
			clickelement(ForgotPasswordPage.EmailAddress);
			sendKeystoElement(ForgotPasswordPage.EmailAddress,email);
			System.out.println("Email is entered");
				
			}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Deelchat application");
		}
	}

	@Then("^user click on continue button$")
	public void userClickOnContinueButton() throws Throwable {
		try {
			explicitwaitvisible(ForgotPasswordPage.Continue);
			clickelement(ForgotPasswordPage.Continue);
			Thread.sleep(2000);
			}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Deelchat application");
		}
	}

	@And("^assert the success message$")
	public void assertTheSuccessMessage() {
		try {
			WebElement errormsg = getElement(ForgotPasswordPage.ToastMsg);
			explicitwaitvisible(ForgotPasswordPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
				String validationText = validation.substring(1).trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,ForgotPasswordPage.SuccessMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +ForgotPasswordPage.SuccessMsg );
			}
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to logged with invalid email");
		}
	}


}
