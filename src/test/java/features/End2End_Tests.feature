Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario Outline: Customer place an order by purchasing an item from search
    Given User is on Home Pagee.
    When User searches for "<productName>".
    And Choose to buy Two items.
    And Moves to checkout cart page, enter personal details on checkout page and place the order.
    Then User can view the order and download the invoice.


    Examples:
      | productName               | 
      | Apple MacBook Pro 13-inch |