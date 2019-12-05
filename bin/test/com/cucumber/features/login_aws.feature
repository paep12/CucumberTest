Feature: Login in AWS
With a default User
The data in this test is fake

  Scenario: As a constant user from AWS , i want to login with one of my AWS accounts
  
    Given i open the page with the URL
	And i click in My account option
	When i see the menu, i click in Account Settings
	Then i can enter the correct ID
	And i click in the Next Button
	Then i can enters "pablo" and "pablo"
	And i click in the login button