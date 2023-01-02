package DomainOperations;

import Utilities.TestBase;
import org.jetbrains.annotations.NotNull;

import static DomainOperations.StockMaintenance.itemPrice;

public class CashDeposits extends TestBase {

    StockMaintenance stock = new StockMaintenance();
    public static int depositAmount = 0;
    public String[]  validNotes = {"1","5","10","100"};
    public boolean flag = true;
    public boolean confirmPayment(String answer) {
        if (answer.charAt(0) == 'y'){
            message = "";
            return true;
        }else if (answer.charAt(0) == 'n') {
            message = "Transaction Cancelled";
            return false;
        }else {
            message = "Invalid Input , Pay again? (y/n)";
            return false;
        }
    }

    public void getAmount(String inputLine) {
        flag = true;
        String[] payment = inputLine.trim().replaceAll(" ","").split(",");
        for (String notes : validNotes) {
            if (payment[0].equals(notes)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            message = "Invalid Notes provided, Pay again? (y/n)";
            depositAmount = 0;
        }
        try{
            depositAmount += Integer.parseInt(payment[0])*Integer.parseInt(payment[1]);
        }catch (Exception e){
            flag = true;
            message = "Invalid Input , Pay again? (y/n)";
            depositAmount = 0;
        }
        try {
            System.out.println(payment[2]);
            flag = true;
            message = "Invalid Input , Pay again? (y/n)";
            depositAmount = 0;
        }catch (Exception e){
            //
        }
    }

    public boolean amountVerification(){
        return flag;
    }

    public boolean getPayment(String payment) {
        if (payment.charAt(0) != 'y') {
            getAmount(payment);
            return true;
        }else {
            return false;
        }
    }

    public boolean verifyPayment() {
        if (depositAmount ==  itemPrice) {
            message = "Thank you for your purchase";
            depositAmount = 0;
            stock.updateItemDetails();
            return true;
        }else {
            message ="Amount is not matching. Please pay with exact change. Pay again? (y/n)";
            depositAmount = 0;
            return false;
        }
    }

    public boolean paymentFailed(char answer) {
        return answer == 'y';
    }
}
