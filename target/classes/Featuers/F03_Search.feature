@smoke
  Feature:user could search using product name or by SKU
    Scenario Outline: user could search using product name
      When User write product name "<item_name>" on Search Field and click on search button
      Then All Products with product name "<item_name>" apears on the web page
      Examples:
        | item_name|
        | book |
        | laptop |
        | nike |

      Scenario Outline: user could search using product by SKU
        When User write product "<SKU>" on Search Field and click on search button
        And  User click on the product in search result
        Then The product has the same "<SKU>"


        Examples:
        |SKU|
        |SCI_FAITH|
        | APPLE_CAM|
        | SF_PRO_11|


