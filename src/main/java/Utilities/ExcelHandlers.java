package Utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.Assert;

import java.util.*;


public class ExcelHandlers extends TestBase {

    public static Map<String, String> getByColumnTestDataInMap(String testDataFile, String sheetName, String columnName , String testCaseId) throws Exception {
        Map<String, String> TestDataInMap = new TreeMap();
        String query = null;
        query = String.format("SELECT * FROM `%s` WHERE `%s`='%s'", sheetName,columnName, testCaseId);
        Fillo fillo = new Fillo();
        Connection conn = null;
        Recordset recordset = null;

        try {
            conn = fillo.getConnection(testDataFile);
            recordset = conn.executeQuery(query);

            while(recordset.next()) {
                Iterator var8 = recordset.getFieldNames().iterator();

                while(var8.hasNext()) {
                    String field = (String)var8.next();
                    TestDataInMap.put(field, recordset.getField(field));
                }
            }
        } catch (FilloException var10) {
            message = "Item Out of Stock";
        }

        conn.close();
        return TestDataInMap;
    }

    public static void UpdateTestDataToExcel(String testDataFilePath, String sheetName, String conditionColumn, String testCaseId, String updateColName, String updateDataValue) {
        Connection conn = null;
        Fillo fillo = new Fillo();

        try {
            conn = fillo.getConnection(testDataFilePath);
            String query = String.format("UPDATE %s SET `" + updateColName + "`='%s' where `"+conditionColumn+"`='%s'", sheetName, updateDataValue, testCaseId);
            conn.executeUpdate(query);
        } catch (FilloException var8) {
           Assert.fail("Query not updated "+var8);
        }
        conn.close();
    }

    public static List<Map<String, String>> getAllData(String testDataFile, String sheetName) throws Exception {
        String query = null;
        query = String.format("SELECT * FROM `%s`", sheetName);
        Fillo fillo = new Fillo();
        Connection conn = null;
        Recordset recordset = null;
        List<Map<String,String>> allData = new ArrayList<>();

        try {
            conn = fillo.getConnection(testDataFile);
            recordset = conn.executeQuery(query);

            while(recordset.next()) {
                Map<String, String> TestDataInMap = new TreeMap<>();
                Iterator var8 = recordset.getFieldNames().iterator();

                while(var8.hasNext()) {
                    String field = (String)var8.next();
                    TestDataInMap.put(field, recordset.getField(field));
                }

                allData.add(TestDataInMap);
            }
        } catch (FilloException var10) {
            throw new Exception("Test data cannot find . . ."+var10);
        }

        conn.close();
        return allData;
    }

}
