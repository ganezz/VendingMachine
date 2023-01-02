package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    public static Properties prop = new Properties();

    public static String dataSheetLocation;
    public static String dataSheetName;
    public static String message="";

    public TestBase(){
        try {
            FileInputStream ip = new FileInputStream(new File("src/main/resources/project.properties"));
            prop.load(ip);
            dataSheetLocation = prop.getProperty("DataSheetLocation");
            dataSheetName = prop.getProperty("DataSheetName");
        } catch (Exception var3) {
            System.out.println("Property File not able to find : "+var3);
        }
    }

}
