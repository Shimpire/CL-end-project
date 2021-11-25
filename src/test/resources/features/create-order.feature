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

    Then order is completed and screenshot taken of confirmation screen

    And close browser