Feature: MyStore - make a purchase

  @purchase
  Scenario: Existing user buys some products from the shop

    Given user is on MyStore main page

    When user logs in with email:"LilyMiles@jourrapide.com" and password:"Dohy3Ien"

    And user proceeds to Clothes category

    And user chooses desired product

    And user chooses product size: M

    And user puts in quantity of products to order: 5

    And user proceeds to checkout

    And user confirms the selected delivery address is correct

    And user chooses delivery method

    And user selects payment option and completes order

    Then user takes a screenshot of order confirmation

    And user waits 5s

    And close browser

#    And user fills out following address details alias:"<alias>", address:"<address>", city:"<city>", postal code:"<postcode>", phone number:"<phone>"
#
#    Then new address is added to the account: "<alias>""<address>""<city>""<postcode>""<phone>"
#
#    And new address named "<alias>" is deleted