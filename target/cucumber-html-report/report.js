$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/End2End_Tests.feature");
formatter.feature({
  "line": 1,
  "name": "Automated End2End Tests",
  "description": "Description: The purpose of this feature is to test End 2 End integration.",
  "id": "automated-end2end-tests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Home Pagee.",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User searches for \"\u003cproductName\u003e\".",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Choose to buy Two items.",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Moves to checkout cart page, enter personal details on checkout page and place the order.",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User can view the order and download the invoice.",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;",
  "rows": [
    {
      "cells": [
        "productName"
      ],
      "line": 13,
      "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;1"
    },
    {
      "cells": [
        "Apple MacBook Pro 13-inch"
      ],
      "line": 14,
      "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Home Pagee.",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User searches for \"Apple MacBook Pro 13-inch\".",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Choose to buy Two items.",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Moves to checkout cart page, enter personal details on checkout page and place the order.",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User can view the order and download the invoice.",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "E2ETests.moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "E2ETests.User_can_view_the_order_and_download_the_invoice()"
});
formatter.result({
  "status": "skipped"
});
});