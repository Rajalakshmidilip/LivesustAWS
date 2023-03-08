package com.livesust.locators;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.livesust.testbase.TestBase;

public class SignInPage extends TestBase{
	public SignInPage() {

		PageFactory.initElements(driver, this);
	}

	public static final String SignIn= "xpath==//li[@class='button_line']//a[normalize-space()='Sign In']";
	public static final String Email= "xpath==//input[@id='Username / E-Mail Address']";
	public static final String Password= "xpath==//input[@id='Password']";
	public static final String RememberMe= "xpath==//input[@id='rememberMe']";
	public static final String ForgotPassword= "xpath==//a[text()='Forgot Password?']";
	public static final String LogInBtn= "xpath==//button[text()='Log In']";
	public static final String EyeIcon= "xpath==//div[@class='password-eye']";
	public static final String ToastMsg= "xpath==//div[@role='alert']"; 
	public static final String ErrorMsg= "xpath==//p[@class='text-red-b fw-600 text-center fs14']";
	public static final String Logout= "xpath==//div[@id='navBar_01']//span[text()='Logout']";
	public static final String LandingScreenTitle= "//h3[text()='Provider Log In']";
	
	public static final String InvalidUsernameMsg = "Please enter username or email id";
	public static final String InvalidEmailMsg ="Invalid email";
	public static final String InvalidPasswordMsg ="Invalid password";
	public static final String EnterPasswordMsg ="Please enter password";
	public static final String EnterEmailMsg ="Enter username and password";
	public static final String SuccessMsg= "Login successfully"; 
	public static final String WrongFormat= "Incorrect username or password";
	
	
	public static void userSignIn() throws Throwable {
		try {

			clickelement(SignInPage.Email);
			sendKeystoElement(SignInPage.Email,PropertyFile("email", AppProperties));
			System.out.println("Email is entered");
			Thread.sleep(1000);
			clickelement(SignInPage.Password);
			sendKeystoElement(SignInPage.Password,PropertyFile("password", AppProperties));
			System.out.println("Password is entered");
			clickelement(SignInPage.EyeIcon);
			System.out.println("password is shown");
			clickelement(SignInPage.LogInBtn);
			System.out.println("Clicked signin button");

			Thread.sleep(1000);
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,SignInPage.SuccessMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.SuccessMsg );
			}
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Deelchat application");
		}
	}

	public static void userSignIn2() throws Throwable {
		try {

			clickelement(SignInPage.Email);
			sendKeystoElement(SignInPage.Email,"devuser@yopmail.com");
			System.out.println("Email is entered");
			Thread.sleep(1000);
			clickelement(SignInPage.Password);
			sendKeystoElement(SignInPage.Password,"Devuser@123");
			System.out.println("Password is entered");
			clickelement(SignInPage.EyeIcon);
			System.out.println("password is shown");
			clickelement(SignInPage.LogInBtn);
			System.out.println("Clicked signin button");
			
//			Thread.sleep(1000);
//			WebElement errormsg = getElement(SignInPage.ToastMsg);
//			explicitwaitvisible(SignInPage.ToastMsg);
//			if(errormsg.isDisplayed()) {
//				String validation = errormsg.getText().trim();
//				String validationText = validation.substring(1).trim();
//				System.out.println("error message:"+validationText);
//				Assert.assertEquals(validationText,SignInPage.SuccessMsg);
//				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.SuccessMsg );
//			}
			
			
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to launch Deelchat application");
		}
	}

	
}