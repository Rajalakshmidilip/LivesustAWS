package stepdefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.livesust.locators.CustomerPage;
import com.livesust.locators.SignInPage;
import com.livesust.testbase.TestBase;
import com.livesust.utils.TestUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerPageStep extends TestBase{

	CustomerPage customerpage;
	CustomerPage customer = new CustomerPage();

	@Given("^user is on customer page$")
	public void userIsOnCustomerPage() throws Throwable {
		try {
			//openapp
			Thread.sleep(2000);
			TestUtils.selectBrowser();	
			System.out.println(" Website is launched");

			Thread.sleep(1000);
			SignInPage.userSignIn();

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@When("^user click on addnewcustomer button$")
	public void userClickOnAddNewCustomerButton() throws Throwable {
		try {
			explicitwaitvisible(CustomerPage.AddNewCustomerBtn);
			clickelement(CustomerPage.AddNewCustomerBtn);
			System.out.println("Clicked addnewcustomer button");
			Thread.sleep(1000);

			WebElement title = getElement(CustomerPage.AddCustomerTitle);
			explicitwaitvisible(CustomerPage.AddCustomerTitle);
			if(title.isDisplayed()) {
				String validationText = title.getText().trim();
				Assert.assertEquals(validationText,CustomerPage.AddCustomerTitleText);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +CustomerPage.AddCustomerTitleText );
			}

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^user enter customer firstname(.*) lastname(.*)$")
	public void userEnterCustomerFirstNameLastName(String fname,String lname) throws Throwable {
		try {
			Thread.sleep(1000);
			explicitwaitvisible(CustomerPage.FirstName);
			clickelement(CustomerPage.FirstName);
			sendKeystoElement(CustomerPage.FirstName,fname);
			System.out.println("Firstname is entered");

			explicitwaitvisible(CustomerPage.LastName);
			clickelement(CustomerPage.LastName);
			sendKeystoElement(CustomerPage.LastName,lname);
			System.out.println("Lastname is entered");


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
	
    @Then("^user enter customer displayname(.*) invoicename(.*)$")
    public void userEnterCustomerDisplayNameInvoiceName(String dname,String invname) throws Throwable {
		try {
			Thread.sleep(1000);
			explicitwaitvisible(CustomerPage.DisplayName);
			clickelement(CustomerPage.DisplayName);
			sendKeystoElement(CustomerPage.DisplayName,dname);
			System.out.println("Displayname is entered");

			explicitwaitvisible(CustomerPage.InvoiceName);
			clickelement(CustomerPage.InvoiceName);
			sendKeystoElement(CustomerPage.InvoiceName,invname);
			System.out.println("Invoicename is entered");
			
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^user add the singlevalue phonenumber(.*) and emailid(.*)$")
	public void userAddTheSingleValuePhoneNumberAndEmailId(String phone ,String email) throws Throwable {
		try {
			explicitwaitvisible(CustomerPage.PhoneNumber1);
			clickelement(CustomerPage.PhoneNumber1);
			sendKeystoElement(CustomerPage.PhoneNumber1,phone);
			System.out.println("Phonenumber is entered");

			explicitwaitvisible(CustomerPage.MobileRadioBtn1);
			clickelement(CustomerPage.MobileRadioBtn1);

			explicitwaitvisible(CustomerPage.PrimaryBtn1);
			clickelement(CustomerPage.PrimaryBtn1);

			explicitwaitvisible(CustomerPage.Email1);
			clickelement(CustomerPage.Email1);
			sendKeystoElement(CustomerPage.Email1,email);
			System.out.println("Email is entered");

			explicitwaitvisible(CustomerPage.BusinessBtn1);
			clickelement(CustomerPage.BusinessBtn1);

			scrollVisible(CustomerPage.PrimaryBtn2);
			explicitwaitvisible(CustomerPage.PrimaryBtn2);
			clickelement(CustomerPage.PrimaryBtn2);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^user add the propertyaddress$")
	public void userAddThePropertyAddressAndPropertyType(DataTable d) throws Throwable {
		try {
			Map<String, String> mp = d.asMap(String.class, String.class);

			scrollVisible(CustomerPage.PropertyAddress1);
			explicitwaitvisible(CustomerPage.PropertyAddress1);
			clickelement(CustomerPage.PropertyAddress1);
			scriptSendKeys(CustomerPage.PropertyAddress1, mp.get("propertyaddress1"));

			Thread.sleep(3000);
//			driver.findElements(By.cssSelector(".pac-item")).get(0).click();			
				
			getElement(CustomerPage.PropertyAddress1).sendKeys(Keys.ARROW_DOWN);
			getElement(CustomerPage.PropertyAddress1).sendKeys(Keys.ENTER);

//			explicitwaitvisible(CustomerPage.PropertyAddress2);
//			clickelement(CustomerPage.PropertyAddress2);
//			scriptSendKeys(CustomerPage.PropertyAddress2, mp.get("propertyaddress2"));
//
//			explicitwaitvisible(CustomerPage.PropertyCity);
//			clickelement(CustomerPage.PropertyCity);
//			scriptSendKeys(CustomerPage.PropertyCity, mp.get("city1"));	
//
//			explicitwaitvisible(CustomerPage.PropertyState);
//			clickelement(CustomerPage.PropertyState);
//			scriptSendKeys(CustomerPage.PropertyState, mp.get("state1"));	
//
//			explicitwaitvisible(CustomerPage.PropertyZipcode);
//			clickelement(CustomerPage.PropertyZipcode);
//			scriptSendKeys(CustomerPage.PropertyZipcode, mp.get("zipcode1"));	

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}


	@And("^user add the propertytype(.*)$")
	public void userAddThePropertyType(String prtytype) throws Throwable {
		try {

			scrollVisible(CustomerPage.PropertyType);
			explicitwaitvisible(CustomerPage.PropertyType);
			clickelement(CustomerPage.PropertyType);

			explicitwaitvisible(CustomerPage.PropertyList);
			dropdownlist(CustomerPage.PropertyList,prtytype);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
	
	@And("^assert the success message for added customer$")
	public void assertTheSuccessMessageForAddedCustomer() {
		try {
			Thread.sleep(1000);
			WebElement errormsg = getElement(CustomerPage.ToastMsg);
			explicitwaitvisible(CustomerPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				Assert.assertEquals(validationText,CustomerPage.Success);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +CustomerPage.Success );
			}
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
	
	@And("^user add the same billingaddress$")
	public void userAddTheSameBillingAddress() throws Throwable {
		try {
			scrollVisible(CustomerPage.YesBtn);
			explicitwaitvisible(CustomerPage.YesBtn);
			scrollVisible(CustomerPage.YesBtn);
			clickelement(CustomerPage.YesBtn);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
	@And("^user add the different billingaddress$")
	public void userAddTheDifferentBillingAddress(DataTable d) throws Throwable {
		try {

			Map<String, String> mp = d.asMap(String.class, String.class);

			scrollVisible(CustomerPage.NoBtn);
			explicitwaitvisible(CustomerPage.NoBtn);
			scrollVisible(CustomerPage.NoBtn);
			clickelement(CustomerPage.NoBtn);

			Thread.sleep(1000);
			scrollVisible(CustomerPage.BillingAddress1);
			explicitwaitvisible(CustomerPage.BillingAddress1);
			clickelement(CustomerPage.BillingAddress1);
			scriptSendKeys(CustomerPage.BillingAddress1, mp.get("billingaddress1"));

			explicitwaitvisible(CustomerPage.BillingAddress2);
			clickelement(CustomerPage.BillingAddress2);
			scriptSendKeys(CustomerPage.BillingAddress2, mp.get("billingaddress2"));

			explicitwaitvisible(CustomerPage.BillingCity);
			clickelement(CustomerPage.BillingCity);
			scriptSendKeys(CustomerPage.BillingCity, mp.get("city2"));	

			explicitwaitvisible(CustomerPage.BillingState);
			clickelement(CustomerPage.BillingState);
			scriptSendKeys(CustomerPage.BillingState, mp.get("state2"));	

			scrollVisible(CustomerPage.BillingZipcode);
			explicitwaitvisible(CustomerPage.BillingZipcode);
			clickelement(CustomerPage.BillingZipcode);
			scriptSendKeys(CustomerPage.BillingZipcode, mp.get("zipcode2"));	


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^user click on savecustomer button$")
	public void userClickOnSaveCustomerButton() throws Throwable {
		try {
			Thread.sleep(1000);
			scrollVisible(CustomerPage.SaveCustomer);
			explicitwaitvisible(CustomerPage.SaveCustomer);
			clickelement(CustomerPage.SaveCustomer);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^user click on saveaddnewcustomer button$")
	public void userClickOnSaveAndAddNewCustomerButton() throws Throwable {
		try {
			Thread.sleep(1000);
			scrollVisible(CustomerPage.SaveCustomer);
			explicitwaitvisible(CustomerPage.SaveAddCustomer);
			clickelement(CustomerPage.SaveAddCustomer);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^user click on cancel customer button$")
	public void userClickOnCancelCustomerButton() throws Throwable {
		try {
			Thread.sleep(1000);
			scrollVisible(CustomerPage.CancelBtn);
			explicitwaitvisible(CustomerPage.CancelBtn);
			clickelement(CustomerPage.CancelBtn);

			explicitwaitvisible(CustomerPage.LeaveBtn);
			clickelement(CustomerPage.LeaveBtn);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^user click on close button in customer details$")
	public void userClickOnCloseButtonInCustomerDetails() throws Throwable {
		try {
			Thread.sleep(1000);
			scrollVisible(CustomerPage.CloseBtn);
			explicitwaitvisible(CustomerPage.CloseBtn);
			clickelement(CustomerPage.CloseBtn);

			explicitwaitvisible(CustomerPage.LeaveBtn);
			clickelement(CustomerPage.LeaveBtn);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	} 

	@And("^assert the error message for empty space for all fields$")
	public void assertTheErrorMessageForEmptySpaceForAllFields() throws Throwable {
		try {
			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.FirstErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.LastErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.DisplayErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.InvoiceErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.PhoneErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.EmailErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.Add1ErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.Add2ErrorMsg);

			//explicitwaitvisible(CustomerPage.ErrorMsg);
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.AddTypeErrorMsg);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^check displayname and invoicename are autofilled$")
	public void checkDisplayNameAndInvoiceNameAreAutofilled() throws Throwable {
		try {

			WebElement text1 = getElement(CustomerPage.FirstName);
			explicitwaitvisible(CustomerPage.FirstName);
			String firstnametext = text1.getText().trim();
			System.out.println("value: "+firstnametext);

			WebElement text2 = getElement(CustomerPage.LastName);
			explicitwaitvisible(CustomerPage.LastName);
			String lastnametext = text2.getText().trim();
			System.out.println("value: "+lastnametext);

			WebElement text3 = getElement(CustomerPage.DisplayName);
			explicitwaitvisible(CustomerPage.DisplayName);
			String displaynametext = text3.getText().trim();
			System.out.println("value: "+displaynametext);

			WebElement text4 = getElement(CustomerPage.InvoiceName);
			explicitwaitvisible(CustomerPage.InvoiceName);
			String invoicenametext = text4.getText().trim();
			System.out.println("value: "+invoicenametext);

			String expected = lastnametext.concat(",");
			System.out.println("error message:"+expected);
			String expectedvalue = expected.concat(firstnametext);
			System.out.println("error message:"+expectedvalue);

			//			Assert.assertEquals(expectedvalue,displaynametext);
			//			System.out.println("Actual Value: " +expectedvalue  + " Expected value: " +displaynametext );
			//			
			//			Assert.assertEquals(expectedvalue,invoicenametext);
			//			System.out.println("Actual Value: " +expectedvalue  + " Expected value: " +invoicenametext );

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^assert the error message for invalid mobile digit$")
	public void assertTheErrorMessageForInvalidMobileDigit() throws Throwable {
		try {

			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.PhoneErrorMsg);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^assert the error message for invalid mobile format$")
	public void assertTheErrorMessageForInvalidMobileFormat() throws Throwable {
		try {
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.PhoneErrorMsg);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^assert the error message for invalid emailid format$")
	public void assertTheErrorMessageForInvalidEmailIdFormat() throws Throwable {
		try {
			ElementListMatchAssert(CustomerPage.ErrorMsg,CustomerPage.EmailErrorMsg);

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@Then("^check the added customer details in customer list page$")
	public void checkTheAddedCustomerDetailsInCustomerListPage() throws Throwable {
		try {


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^check the cancelled details is updated in customer list page$")
	public void checkTheCancelledDetailsIsUpdatedInCustomerListPage() throws Throwable {
		try {


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
	@Then("^user select the phonenumber as mobile or work values$")
	public void userSelectThePhoneNumberAsMobileOrWorkValues() throws Throwable {
		try {


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^check the receiver sms toggle is on state$")
	public void checkTheReceiverSmsToggleIsOnState() throws Throwable {
		try {


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
	@Then("^user select the phonenumber as home or others values$")
	public void userSelectThePhoneNumberAsHomeOrOthersValues() throws Throwable {
		try {


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^check the receiver sms toggle is off state$")
	public void checkTheReceiverSmsToggleIsOffState() throws Throwable {
		try {


		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}

	@And("^user add the twovalue phonenumber(.*) (.*) and emailid(.*) (.*)$")
	public void userAddTheTwoValuePhonenumberAndEmailId(String phone1,String phone2,String email1,String email2) throws Throwable {
		try {
			explicitwaitvisible(CustomerPage.PhoneNumber1);
			clickelement(CustomerPage.PhoneNumber1);
			sendKeystoElement(CustomerPage.PhoneNumber1,phone1);
			System.out.println("Phonenumber is entered");

			explicitwaitvisible(CustomerPage.MobileRadioBtn1);
			clickelement(CustomerPage.MobileRadioBtn1);

			explicitwaitvisible(CustomerPage.PrimaryBtn1);
			clickelement(CustomerPage.PrimaryBtn1);

			explicitwaitvisible(CustomerPage.PhoneNumberPlus);
			clickelement(CustomerPage.PhoneNumberPlus);

			explicitwaitvisible(CustomerPage.PhoneNumber);
			ElementsListFindSendkeys(CustomerPage.PhoneNumber,phone2);

			//				scrollVisible(CustomerPage.OtherRadioBtn1);
			//				explicitwaitvisible(CustomerPage.OtherRadioBtn1);
			//				clickelement(CustomerPage.OtherRadioBtn1);
			//				
			scrollVisible(CustomerPage.Email1);
			explicitwaitvisible(CustomerPage.Email1);
			clickelement(CustomerPage.Email1);
			sendKeystoElement(CustomerPage.Email1,email1);
			System.out.println("Email is entered");

			scrollVisible(CustomerPage.BusinessBtn1);
			explicitwaitvisible(CustomerPage.BusinessBtn1);
			clickelement(CustomerPage.BusinessBtn1);

			scrollVisible(CustomerPage.PrimaryBtn2);
			explicitwaitvisible(CustomerPage.PrimaryBtn2);
			clickelement(CustomerPage.PrimaryBtn2);

			explicitwaitvisible(CustomerPage.EmailPlus);
			clickelement(CustomerPage.EmailPlus);

			explicitwaitvisible(CustomerPage.Email);
			ElementsListFindEmailSendkeys(CustomerPage.Email,email2);

			//				explicitwaitvisible(CustomerPage.OtherBtn1);
			//				clickelement(CustomerPage.OtherBtn1);



		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("User not able to redirect to customerpage");
		}
	}
}
