Feature: Place Order

  Scenario: user check out item
  	When search dress item
    And add dress item
    And search shirt item
    And add shirt item
    And user filling billing
    And user place order
    Then validate valid scenario