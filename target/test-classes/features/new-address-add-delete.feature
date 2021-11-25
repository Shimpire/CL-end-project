Feature: MyStore - Add new user address

  @address
  Scenario Outline: Existing user adds their first address on MyStore

    Given User is on MyStore homepage

    When user logs in using email:"LilyMiles@jourrapide.com" and password:"Dohy3Ien"

    And user proceeds to addresses page

    And user goes to add new address page

    And user fills out following address details alias:"<alias>", address:"<address>", city:"<city>", postal code:"<postcode>", phone number:"<phone>"

    Then new address is added to the account: "<alias>""<address>""<city>""<postcode>""<phone>"

    And new address named "<alias>" is deleted

    Examples:
      | alias        | address           | city       | postcode | phone         |
      | The Garrison | 110 Garrison Ln   | Birmingham | B9 4BS   | 0121 772 6544 |
      | Mrs Hudson   | 221B Baker Street | London     | NW1 6XE  | 2072243688    |