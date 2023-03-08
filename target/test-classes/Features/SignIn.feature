Feature: Verify the Signin Functionality
 Background:SigninPage
 Given user is on signin screen
	  
   @signin 
Scenario Outline: Verify user signin with unregistered email credential 
    When user enter the values <email> and <password>
    Then user click on login button 
    And assert the error message for unregistered email credential
    
     Examples:
    | email 		 			 | password      |
	  | san@yopmail.com  | Password@123  | 
 
   @signin    
Scenario Outline: Verify user signin with without user credential 
    When user enter the values <email> and <password>
    Then user click on login button 
    And assert the error message for without credential  
    
     Examples:
    | email			  | password    |
	  | 					  | 					  | 
	
   @signin  
Scenario Outline: Verify user signin with without enter email
    When user enter the values <email> and <password>
    Then user click on login button 
    And assert the error message for without enter email  
    
     Examples:
    | email			  | password    |
	  | 					  | Password@123	| 
	
	  @signin 
Scenario Outline: Verify user signin with without enter password  
    When user enter the values <email> and <password>
    Then user click on login button 
    And assert the error message for without enter password
    
     Examples:
    | email				 				| password    |
	  | san@yopmail.com			| 					  | 

  
    @signin 
Scenario Outline: Verify user signin with invalid email credential 
    When user enter the values <email> and <password>
    Then user click on login button 
    And assert the error message for invalid email credential
    
      Examples:
    | email				 		 | password      |
    | san$%^@gmail..1  | Password@123  |


    @signin  
Scenario Outline: Verify user signin with invalid password credential 
    When user enter the values <email> and <password>
    Then user click on login button 
    And assert the error message for invalid password credential
    
      Examples:
    | email 		        					| password    |
    | Liveautomation@yopmail.com  | hello@123   |
    
      
  @signin 
Scenario Outline: Verify user signin with valid credential 
    When user enter the values <email> and <password>
    Then user click on login button
    And check the user is successfully logged into app
    
    Examples:
    | email 		 						       | password      |
    | Liveautomation@yopmail.com   | Password@123  | 
