package com.livesust.locators;

import org.openqa.selenium.support.PageFactory;
import com.livesust.testbase.TestBase;

public class ForgotPasswordPage extends TestBase {
	
	public ForgotPasswordPage() {

		PageFactory.initElements(driver, this);
	}

	public static final String ForgotPassword= "xpath==//a[text()='Forgot Password?']";
	public static final String EmailAddress= "xpath==//input[@id='floatingInputE-Mail Address']";
	public static final String Cancel= "xpath==//button[text()='Cancel']";
	public static final String Continue= "xpath==//button[text()='Continue']";
	public static final String ToastMsg= "xpath==//div[@id='toast-container']"; 
	public static final String Password= "xpath==//input[@id='floatingInputEnter Password']";
	public static final String ReEnterPassword= "xpath==//input[@id='floatingInputRe-Enter Password']";
	public static final String SaveBtn= "xpath==//button[text()='Save Password']";
	public static final String EyeIcon1= "xpath==(//div[@class='password-eye ng-star-inserted'])[1]";
	public static final String EyeIcon2= "xpath==(//div[@class='password-eye ng-star-inserted'])[2]";
	
	public static final String SuccessMsg= "Email Sent successfully";

}
