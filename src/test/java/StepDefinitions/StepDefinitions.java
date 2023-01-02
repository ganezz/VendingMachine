package StepDefinitions;

import DomainOperations.CashDeposits;
import DomainOperations.Display;
import DomainOperations.LoadStocks;
import DomainOperations.StockMaintenance;
import Utilities.TestBase;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class StepDefinitions  extends TestBase {

    LoadStocks load = new LoadStocks();
    CashDeposits cash = new CashDeposits();
    StockMaintenance stock = new StockMaintenance();

    public int tray_no = 0;
    public String choice = null,payment;
    @Given("^a vending machine application$")
    public void a_vending_machine_application() throws Exception {
        load.Initialization();
        new Display().DisplayAllItems();
    }

    @When("^user will prompt to enter tray no (.+)$")
    public void user_will_prompt_to_enter_tray_no(String trayno) {
        this.tray_no = Integer.parseInt(trayno);
        stock.getItemDetails(trayno);
    }

    @Then("^item details should display")
    public void item_details_should_display() {
        stock.getItemDetails(String.valueOf(tray_no));
    }

    @When("user inputs valid tray no")
    public void user_inputs_valid_tray_no() {
        stock.getItemDetails(String.valueOf(tray_no));
    }
    
    @Then("^purchase success message should appear$")
    public void purchase_success_message_should_appear() {
        cash.verifyPayment();
        Assert.assertEquals(message,"Thank you for your purchase");
    }

    @And("^user will prompt to confirm his purchase (.+)$")
    public void user_will_prompt_to_confirm_his_purchase(String paymentconfirmation) {
        choice = paymentconfirmation;
        cash.confirmPayment(paymentconfirmation);
    }

    @And("^application will ask for valid notes and no of notes (.+)$")
    public void application_will_ask_for_valid_notes_and_no_of_notes(String amount) {
        payment = amount;
        cash.getAmount(amount);
    }

    @When("^user inputs invalid tray no$")
    public void user_inputs_invalid_tray_no()  {
//        stock.getItemDetails(String.valueOf(tray_no));
    }

    @Then("^system should display Invalid Tray no message$")
    public void system_should_invalid_tray_no_message()  {
       Assert.assertEquals(message,"Item Out of Stock");
    }

    @Then("^system should display Invalid input on Confirm purchase$")
    public void system_should_display_invalid_input_on_confirm_purchase()  {
        Assert.assertEquals(message,"Invalid Input , Pay again? (y/n)");
    }

    @Then("^system should display valid input on Confirm purchase$")
    public void system_should_display_valid_input_on_confirm_purchase()  {
        //System will pass
    }

    @And("^user inputs invalid confirm purchase$")
    public void user_inputs_invalid_confirm_purchase()  {
       cash.confirmPayment(choice);
    }

    @Then("^system should display Invalid Notes or Invalid input$")
    public void system_should_display_invalid_notes_or_invalid_input()  {
        Assert.assertEquals(message,"Invalid Input , Pay again? (y/n)");
    }

    @And("^user inputs invalid notes and no of notes$")
    public void user_inputs_invalid_notes_and_no_of_notes()  {
       cash.getPayment(payment);
    }

    @Then("^system should display Amount is not matching message$")
    public void system_should_display_amount_is_not_matching_message()  {
        Assert.assertEquals(message,"Amount is not matching. Please pay with exact change. Pay again? (y/n)");
    }

    @And("^user inputs not sufficient amount item$")
    public void user_inputs_not_sufficient_amount_item()  {
        cash.verifyPayment();
    }

    @Then("^system should display Transaction Cancelled message$")
    public void system_should_display_transaction_cancelled_message()  {
        Assert.assertEquals(message,"Transaction Cancelled");
    }

    @And("^user will prompt to input confirmation (.+)$")
    public void user_will_prompt_to_input_confirmation(String confirmation)  {
        cash.confirmPayment(confirmation);
    }

    @Then("^user will prompt to repay amount$")
    public void user_will_prompt_to_repay_amount()  {
       cash.amountVerification();
    }

    @And("^user inputs yes as confirm purchase$")
    public void user_inputs_yes_as_confirm_purchase()  {
       cash.confirmPayment(choice);
    }


    @And("^user inputs no as confirm purchase$")
    public void user_inputs_nos_confirm_purchase()  {
        cash.confirmPayment(choice);
    }

    @Then("^system should display Invalid Notes message$")
    public void system_should_display_invalid_notes_message()  {
        Assert.assertEquals(message,"Invalid Notes provided, Pay again? (y/n)");
    }

    @And("^user inputs valid notes and no of notes$")
    public void user_inputs_valid_notes_and_no_of_notes()  {
        cash.getAmount(payment);
    }

    @Then("^system should display Invalid input message$")
    public void system_should_display_invalid_input_message()  {
        Assert.assertEquals(message,"Invalid Input , Pay again? (y/n)");
    }


}
