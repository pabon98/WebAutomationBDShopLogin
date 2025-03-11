package utilities;

import org.testng.annotations.DataProvider;

public class Datasets {
   @DataProvider(name = "invalidUserCredentials")
   public static Object invalidCredentials(){
       Object[][] data = {
               {"xohed58570@calmpros.com", "1234@123"},
               {"xohed58570@abc.com", "1234@123ab"},
               {"xohed58570@calmpros.com","111111"},
               {"xohed@abc.com", "121212"},
               {"",""},
               {"xohed58570@calmpros.com", "1234@123ab"}
       };
       return data;
   }

}
