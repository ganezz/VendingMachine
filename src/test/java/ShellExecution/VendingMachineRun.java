package ShellExecution;

import DomainOperations.CashDeposits;
import DomainOperations.Display;
import DomainOperations.LoadStocks;
import DomainOperations.StockMaintenance;
import Utilities.TestBase;

import java.util.Scanner;

import static DomainOperations.StockMaintenance.itemPrice;

public class VendingMachineRun extends TestBase {


    public static void main(String[] args) throws Exception {
        LoadStocks load = new LoadStocks();
        CashDeposits cash = new CashDeposits();
        StockMaintenance stock = new StockMaintenance();
        Scanner input = new Scanner(System.in);
        boolean invalidAmount,flag=false;

        load.Initialization();



        do{
            new Display().DisplayAllItems();
            System.out.println("Enter Tray No");

            stock.getItemDetails(input.next());
            if (itemPrice == 0){
                System.out.println(message);
            }else {
                System.out.println("Proceed with payment? (yes/no)");
                if (!cash.confirmPayment(input.next())){
                    System.out.println(message);
                }else{
                    do {
                        invalidAmount = false;
                        System.out.println("Please enter note amount and no of notes. Press ‘y’ if done");
                        while (!invalidAmount && cash.getPayment(input.next()) ) {
                            invalidAmount = cash.amountVerification();
                        }
                        if (!invalidAmount && cash.verifyPayment()) {
                            System.out.println(message);
                            break;
                        } else {
                            System.out.println(message);
                            invalidAmount = cash.confirmPayment(input.next());
                            System.out.println(message);
                        }
                    }while (invalidAmount);
                }
            }
            System.out.println("---------------next transaction--------------------");
            System.out.println("Would you want to buy again? (yes/no)");
        flag = cash.confirmPayment(input.next());
        System.out.println(message);
        }while (flag);

    }

}
