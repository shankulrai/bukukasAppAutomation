@app
Feature: Bukukas Automation Task

  Scenario Outline: Verify that Utang pelanggan should be prefilled with the amount entered.

    Given User is On loginScreen
    And check for CountryCode Field and Select "<country>"
    And Click on the Mobile Number Field and Enter "<mobileNumber>"
    Then Enter the "<OTP>" for The User mobile
    And Verify that User should successfully login to application
    Then Naviaget to hutang tab.
    And Tap on the tambah hutang piutang .
    Then Add Amount in Rp in membri tab
    Then Tap onto the Pilih dari buku kontak
    And  Pick the existing contact from the list -
    Then Add notes and select dates
    And  Tap on simpan transaksi.
    But Utang pelanggan should be prefilled with the amount entered.
    Examples:
      | country     | mobileNumber |OTP|
      |India |7406792607           |1234|