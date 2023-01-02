package DomainOperations;

import Utilities.ExcelHandlers;
import Utilities.TestBase;

import java.util.List;
import java.util.Map;


public class LoadStocks extends TestBase {
    
    public static List<Map<String,String>> Stocks;

    public void Initialization() throws Exception {
        Stocks =  ExcelHandlers.getAllData(dataSheetLocation,dataSheetName);

    }
}
