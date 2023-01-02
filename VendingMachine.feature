Feature: Validating functionality of Vending Machine

  Scenario Outline: Verify Positive flow of Application, Machine only accepts valid notes ( 1, 5, 10 ,100 )
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    Then purchase success message should appear
    Examples:
      | tray_no | payment_confirmation | amount |
      | 1       | yes                   | 5,1   |

  Scenario Outline: Validation Tray No with valid inputs, and only Integer should accept
    Given a vending machine application
    And user will prompt to enter tray no <tray_no>
    When user inputs valid tray no
    Then item details should display
    Examples:
      | tray_no |
      | 1     |

  Scenario Outline: Validation Tray No with invalid inputs, and only Integer should accept
    Given a vending machine application
    And user will prompt to enter tray no <tray_no>
    When user inputs invalid tray no
    Then system should display Invalid Tray no message
    Examples:
      | tray_no |
      | 13     |


  Scenario Outline: Validate Confirm Purchase, and should accept on Yes/no.
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And user inputs yes as confirm purchase
    Then system should display valid input on Confirm purchase
    Examples:
      | tray_no | payment_confirmation |
      | 1       | yes                  |


  Scenario Outline: Validate Confirm Purchase with Invalid Input, and should accept on Yes/no.
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And user inputs no as confirm purchase
    Then system should display valid input on Confirm purchase
    Examples:
      | tray_no | payment_confirmation |
      | 2       | no                   |


  Scenario Outline: Validate Confirm Purchase with invalid input, and should accept on Yes/no.
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And user inputs invalid confirm purchase
    Then system should display Invalid input on Confirm purchase
    Examples:
      | tray_no | payment_confirmation |
      | 1       | doe                  |


  Scenario Outline: Validate Notes and No of Notes in Application , should accept valid Integer and 2 parameters separated with comma (,)
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    Then purchase success message should appear
    Examples:
      | tray_no | payment_confirmation | amount |
      | 1       | yes                   | 5,1   |


  Scenario Outline: Validate Notes and No of Notes in Application , should accept Integer and 2 parameters separated with comma (,)
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    And user inputs invalid notes and no of notes
    Then system should display Invalid Notes message
    Examples:
      | tray_no | payment_confirmation | amount |
      | 1       | yes                   | 3,5   |

  Scenario Outline: Validate Notes and No of Notes in Application , should accept Integer and 2 parameters separated with comma (,)
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    And user inputs invalid notes and no of notes
    Then system should display Invalid input message
    Examples:
      | tray_no | payment_confirmation | amount |
      | 1       | yes                   | 5,1,4   |

  Scenario Outline: Validate provided Amount and Item price
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    And user inputs not sufficient amount item
    Then system should display Amount is not matching message
    Examples:
      | tray_no | payment_confirmation | amount |
      | 1       | yes                   | 1,3   |

  Scenario Outline: Validate Not Sufficient amount error message , should accept Yes/No
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    And user inputs not sufficient amount item
    Then system should display Amount is not matching message
    And user will prompt to input confirmation <repay_confirmation>
    Then user will prompt to repay amount
    Examples:
      | tray_no | payment_confirmation | amount | repay_confirmation |
      | 1       | yes                   | 1,3   |  yes               |

  Scenario Outline: Validate Not Sufficient amount error message and validate Transaction cancellation , should accept Yes/No
    Given a vending machine application
    When user will prompt to enter tray no <tray_no>
    Then item details should display
    And user will prompt to confirm his purchase <payment_confirmation>
    And application will ask for valid notes and no of notes <amount>
    And user inputs not sufficient amount item
    Then system should display Amount is not matching message
    And user will prompt to input confirmation <repay_confirmation>
    Then system should display Transaction Cancelled message
    Examples:
      | tray_no | payment_confirmation | amount | repay_confirmation |
      | 1       | yes                   | 1,3   |  no               |



