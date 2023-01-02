package DomainOperations;

import Utilities.ExcelHandlers;

import java.util.Map;

import static Utilities.TestBase.*;

public class StockMaintenance {

    public static int itemPrice = 0;
    public static int item_No = 0;
    public static int item_quantity = 0;
    public static String item_name ;

    public void getItemDetails(String tray_no) {
        Map<String,String> itemList = null;

        try {
           itemList = ExcelHandlers.getByColumnTestDataInMap(dataSheetLocation,dataSheetName,"Tray_No", String.valueOf(tray_no));
            if (Integer.parseInt(itemList.get("Quantity")) > 0){
                item_name=itemList.get("Item");
                itemPrice = Integer.parseInt(itemList.get("Price"));
                item_quantity = Integer.parseInt(itemList.get("Quantity"));
                item_No = Integer.parseInt(tray_no);
                System.out.println("Item : "+item_name);
                System.out.println("Price : "+itemPrice);
            }else{
                message = "Item Out of Stock";
                throw new Exception(message);
            }
        }catch (Exception e){
            itemPrice =  0;
        }
        if (item_quantity <= 0){
            itemPrice = 0;
            message = "Item Out of Stock";
        }
    }

    public void updateItemDetails(){
        --item_quantity;
        ExcelHandlers.UpdateTestDataToExcel(dataSheetLocation,dataSheetName,"Tray_No", String.valueOf(item_No),"Quantity",String.valueOf(item_quantity));
    }


}
