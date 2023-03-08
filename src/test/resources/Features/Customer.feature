Feature: Verify the Customer Functionality

  Background: CustomerPage
    Given user is on customer page

  @Cust
  Scenario Outline: Verify user add new customer details successfully
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    Then user enter customer displayname<dname> invoicename<invname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
    And assert the success message for added customer
    Then check the added customer details in customer list page

    Examples: 
      | fname     | lname | dname | invname |phone      | email            | prtytype |
      | sangeetha | test  | test  | san     |7339014501 | test@yopmail.com | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details with empty space for all fields
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    Then user enter customer displayname<dname> invoicename<invname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 |  |
      | propertyaddress2 |  |
      | city1            |  |
      | state1           |  |
      | zipcode1         |  |
   # And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
    And assert the error message for empty space for all fields

    Examples: 
      | fname | lname | dname | invname |phone | email | prtytype |
      |       |       |       |         |      |       |          |

  @Custo
  Scenario Outline: Verify user add new customer details with invalid mobile digit
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
     And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
     And assert the error message for invalid mobile digit
    Examples: 
      | fname     | lname | phone  | email            | prtytype |
      | sangeetha | test  | 100000 | test@yopmail.com | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details with invalid mobile format
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
    And assert the error message for invalid mobile format

    Examples: 
      | fname     | lname | phone      | email            | prtytype |
      | sangeetha | test  | *J9?0K40"R | test@yopmail.com | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details with invalid emailid format
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
    And assert the error message for invalid emailid format

    Examples: 
      | fname     | lname | phone      | email          | prtytype |
      | sangeetha | test  | 7339414501 | $an%^@gmail..1 | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details with different billing address
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the different billingaddress
      | billingaddress1 | Disney World, Orlando, FL, USA |
      | billingaddress2 |                                |
      | city2           | Anaheim                        |
      | state2          | California                     |
      | zipcode2        |                          92802 |
    Then user click on savecustomer button
    Then check the added customer details in customer list page

    Examples: 
      | fname     | lname | phone      | email            | prtytype |
      | sangeetha | test  | 7339414501 | test@yopmail.com | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details and cancel button
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on cancel customer button
    And check the cancelled details is updated in customer list page

    Examples: 
      | fname     | lname | phone      | email            | prtytype |
      | sangeetha | test  | 7339414501 | test@yopmail.com | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details and saveaddnew customer button
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on saveaddnewcustomer button
    And assert the success message for added customer
    Then check new customer detail popup is showing or not
    Then check the added customer details in customer list page

    Examples: 
      | fname     | lname | phone      | email            | prtytype |
      | sangeetha | test  | 7339414501 | test@yopmail.com | Home     |

  @Custom
  Scenario Outline: Verify user add new customer details and close button in customer details
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on close button in customer details
    And check the cancelled details in customer list page

    Examples: 
      | fname     | lname | phone      | email            | prtytype |
      | sangeetha | test  | 7339414501 | test@yopmail.com | Home     |

  Scenario Outline: Verify user add customer details and check the receiver sms is default set to yes state for mobile or work values
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user select the phonenumber as mobile or work values
    And check the receiver sms toggle is on state

    Examples: 
      | fname     | lname | phone      |
      | sangeetha | test  | 7339414501 |

  Scenario Outline: Verify user add customer details and check the receiver sms is default set to no state for home or others values
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the singlevalue phonenumber<phone> and emailid<email>
    Then user select the phonenumber as home or others values
    And check the receiver sms toggle is off state

    Examples: 
      | fname     | lname | phone      |
      | sangeetha | test  | 7339414501 |

 @Custom
  Scenario Outline: Verify user add customer details with two values in mobile and email field
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the twovalue phonenumber<phone1> <phone2> and emailid<email1> <email2>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
    And assert the success message for added customer
    Then check the added customer details in customer list page

    Examples: 
      | fname     | lname | phone1     | phone2     | email1            | email2                 | prtytype |
      | sangeetha | test  | 7339414501 | 7339414500 | test2@yopmail.com | test2@yopmail.com Home | Home     |

  Scenario Outline: Verify user add customer details with three values in mobile and email field
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the threevalue phonenumber<phone1> <phone2> <phone3> and emailid<email1> <email2> <email3>
    Then user add the propertyaddress
      | propertyaddress1 | Disneyland Park  |
      | propertyaddress2 | Disneyland Drive |
      | city1            | Anaheim          |
      | state1           | California       |
      | zipcode1         |            92802 |
    And user add the propertytype<prtytype>
    And user add the same billingaddress
    Then user click on savecustomer button
    And assert the success message for added customer
    Then check the added customer details in customer list page

    Examples: 
      | fname     | lname | phone1     | phone2     | phone3     | email1            | email2            | email3            | prtytype |
      | sangeetha | test  | 7339414501 | 7339414502 | 7339414503 | test1@yopmail.com | test2@yopmail.com | test3@yopmail.com | Home     |

  Scenario Outline: Verify user add customer details with more than five values in mobile and email field
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the fivevalue phonenumber<phone> and emailid<email>
    Then check if it is displayed more than five phone and email values

    Examples: 
      | fname     | lname | phone      | email            |
      | sangeetha | test  | 7339414501 | test@yopmail.com |

  Scenario Outline: Verify user can delete mobile and email values is set to primary
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the twovalue phonenumber<phone1> <phone2> and emailid<email1> <email2>
    Then check field is not able to delete if set to primary

    Examples: 
      | fname     | lname | phone1     | phone2     | email1            | email2                 |
      | sangeetha | test  | 7339414501 | 7339414500 | test2@yopmail.com | test2@yopmail.com Home |

  Scenario Outline: Verify user can delete mobile and email values is set to primary
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the twovalue phonenumber<phone1> <phone2> and emailid<email1> <email2>
    Then check field is able to delete if not set to primary

    Examples: 
      | fname     | lname | phone1     | phone2     | email1            | email2                 |
      | sangeetha | test  | 7339414501 | 7339414500 | test2@yopmail.com | test2@yopmail.com Home |

  Scenario Outline: Verify user set only one mobile and email values as primary
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the twovalue phonenumber<phone1> <phone2> and emailid<email1> <email2>
    Then check field is able to choose primary for one value

    Examples: 
      | fname     | lname | phone1     | phone2     | email1            | email2                 |
      | sangeetha | test  | 7339414501 | 7339414500 | test2@yopmail.com | test2@yopmail.com Home |

  Scenario Outline: Verify user can delete mobile and email values is not set to primary
    When user click on addnewcustomer button
    Then user enter customer firstname<fname> lastname<lname>
    And user add the twovalue phonenumber<phone1> <phone2> and emailid<email1> <email2>
    Then check field is not able to choose primary for multiple values

    Examples: 
      | fname     | lname | phone1     | phone2     | email1            | email2                 |
      | sangeetha | test  | 7339414501 | 7339414500 | test2@yopmail.com | test2@yopmail.com Home |
