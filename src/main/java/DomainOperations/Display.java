package DomainOperations;

import java.util.Map;

import static DomainOperations.LoadStocks.Stocks;

public class Display {

    public void DisplayAllItems() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("------------------    Vending Machine    ---------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("|  Tray No   |   Items     |     Price     |     Quantity     |");
        System.out.println("--------------------------------------------------------------");
        for (Map<String, String> items : Stocks){
            if(items.get("Quantity").equals("0")){
                System.out.println("|  "+items.get("Tray_No")+"         |                                                  ");
            }else {
                System.out.println("|  " + items.get("Tray_No") + "         |  " + items.get("Item") + "           " + items.get("Price") + "               " + items.get("Quantity") + "     ");
            }
            System.out.println("--------------------------------------------------------------");
        }
    }
}
