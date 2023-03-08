package com.livesust.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.livesust.testbase.TestBase;

public class CustomerPage extends TestBase{

	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public static final String AddNewCustomerBtn= "xpath==//button[normalize-space()='Add New customer']";
	public static final String AddCustomerTitle= "xpath==//h1[@class='modal-title']";
	public static final String CloseBtn= "xpath==//button[@class='bg-transparent border-0']";
	public static final String FirstName= "xpath==//input[@id='First Name']";
	public static final String LastName= "xpath==//input[@id='Last Name']";
	public static final String DisplayName= "xpath==//input[@id='Display Name']";
	public static final String InvoiceName= "xpath==//input[@id='Invoice Name']";
	public static final String PhoneNumber1= "xpath==(//input[@id='phone'])[1]";
	public static final String PhoneNumber= "xpath==//input[@id='phone']";
	public static final String PhoneNumberPlus= "xpath==(//em[@class='fa fa-plus'])[1]";
	public static final String PhoneNumberDelete= "xpath==//div[@formarrayname='phoneNumber']//em[@class='fa fa-trash']";
	public static final String RadioBtn= "xpath==//div[@class='text-start']//div[@class='form-check form-check-inline']";
	public static final String MobileRadioBtn1= "xpath==(//input[@id='Mobile0'])[1]";
	public static final String WorkRadioBtn1= "xpath==(//input[@id='Work0'])[1]";
	public static final String HomeRadioBtn1= "xpath==(//input[@id='Home0'])[1]";
	public static final String OtherRadioBtn1= "xpath==(//input[@id='Other0'])[1]";
	public static final String PrimaryBtn1= "xpath==//div[@formarrayname='phoneNumber']/descendant::input[@id='primary0']";
	public static final String ReceivedBtn1= "xpath==(//input[@id='receivedsms'])[1]";
	public static final String Email= "xpath==//input[@id='email']";
	public static final String Email1= "xpath==(//input[@id='email'])[1]";
	public static final String EmailPlus= "xpath==(//em[@class='fa fa-plus'])[2]";
	public static final String EmailDelete= "xpath==//div[@formarrayname='emails']/descendant::em[@class='fa fa-trash']";
	public static final String PersonalBtn1= "xpath==(//label[text()='Personal'])[1]";
	public static final String BusinessBtn1= "xpath==(//label[text()='Business'])[1]";
	public static final String OtherBtn1= "xpath==//label[text()='Other']";
	public static final String PrimaryBtn2= "xpath==//div[@formarrayname='emails']/descendant::input[@id='primary']";
	public static final String PropertyAddress1= "xpath==//input[@placeholder='Search Nearest Location']";
	public static final String PropertyAddress2= "xpath==//input[@id='Address 2']";
	public static final String PropertyFirstDropdown= "xpath==(//div[@class='pac-item'])[1]";
	public static final String PropertyCity= "xpath==//div[@class='border-bottom']//input[@id='City']";
	public static final String PropertyState= "xpath==//div[@class='border-bottom']//input[@id='State']";
	public static final String PropertyZipcode= "xpath==//div[@class='border-bottom']//input[@id='Zipcode']";
	public static final String BillingAddress1= "xpath==//div[@class='form-floating form-floating-input mb-3']//input[@id='Address 1']";
	public static final String BillingAddress2= "xpath==//div[@class='form-floating form-floating-input mb-3']//input[@id='Address 2']";
	public static final String BillingCity= "xpath==//div[@class='my-3 border-bottom ng-star-inserted']//input[@id='City']";
	public static final String BillingState= "xpath==//div[@class='my-3 border-bottom ng-star-inserted']//input[@id='State']";
	public static final String BillingZipcode= "xpath==//div[@class='my-3 border-bottom ng-star-inserted']//input[@id='Zipcode']";
	public static final String CancelBtn= "xpath==//button[text()='Cancel']";
	public static final String SaveAddCustomer= "xpath==//button[text()='Save & Add New Customer']";
	public static final String SaveCustomer= "xpath==//button[text()='Save Customer']";
	public static final String PropertyType= "xpath==//button[normalize-space()='Property Type']";
	public static final String YesBtn= "xpath==//input[@id='yes']";
	public static final String NoBtn= "xpath==//input[@id='no']";
	public static final String PropertyList= "xpath==//ul[@class='dropdown-menu w-100 show']//li[@class='dropdown-item fs14 ng-star-inserted']";
	public static final String AlertPopup= "xpath==//h5[normalize-space()='Are you sure you want to leave?']";
	public static final String LeaveBtn= "xpath==//button[text()='Leave']";
	public static final String Maplist= "xpath==//div[@class='pac-item']";
	public static final String ToastMsg= "xpath==//div[@role='alert']";
	
	public static final String ErrorMsg="xpath==//p[@class='text-red-b mb-2 fs12 text-start ng-star-inserted']";
	public static final String FirstNameErr= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[1]";
	public static final String LastNameErr= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[2]";
	public static final String DisplayNameErr= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[3]";
	public static final String InvoiceNameErr= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[4]";
	public static final String PhoneNumber1Err= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[5]";
	public static final String Email1Err= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[6]";
	public static final String PropertyAdd1Err= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[7]";
	public static final String PropertyAdd2Err= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[8]";
	public static final String PropertyTypeErr= "xpath==(//p[@class='text-red-b mb-2 fs12 text-start'])[9]";
	
	
	public static final String AddCustomerTitleText="Add Customer";
	public static final String FirstErrorMsg="Please enter first name";
	public static final String LastErrorMsg="Please enter last name";
	public static final String DisplayErrorMsg="Please enter display name";
	public static final String InvoiceErrorMsg="Please enter invoice name";
	public static final String PhoneErrorMsg="Please enter phone number 1";
	public static final String EmailErrorMsg="Please enter email number 1";
	public static final String Add1ErrorMsg="Please enter address 1";
	public static final String Add2ErrorMsg="Please enter address 2";
	public static final String AddTypeErrorMsg="Please enter address type";
	public static final String Success="Customer created successfully";
	
	
}
