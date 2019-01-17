package SeleniumPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverTestNG_Run extends TestAttributes {
	
	String browsername="chrome";
	
	@BeforeTest

	public void beforesuite()
	{
		startResult(browsername);
	}
	
	@Test(dataProvider="RunId")
	public void mainrun(int runid, String runName) throws Throwable
	{
		try {
				System.out.println("currently running script id--->>>>"+runid);
				TestAttributes.Run_ID =0;
				TestAttributes.Run_Name = runName;
				//TestAttributes.Instance_ID = 59;
				TestAttributes.Instance_ID = runid;
				TestAttributes.Global_DataBase = "Access";
				TestAttributes.AutomationTool = "Selenium"; //SELENIUM or SEETEST
				TestAttributes.Browser = browsername.toLowerCase();
	
			/*
			 * When the selenium code is triggered for a script which has tool chaining, front end will pass a non zero value
			 * as TestAttributes.Run_ID and also additional parameters SharedDataSet, TestDataSet and StartStepId
			 */
		
			FunctionLibrary.Driver();
			
		} catch(Exception e) {		
			if(TestAttributes.executiontriggered = false){
				System.out.println("Error in execution. Possible reason coule be an issue...");
				System.out.println("with the arguments passed from front end.");
				System.out.println("while getting the test details from SQS_TEST_BATCH");
				System.out.println("while retrieving the log location from SQS_INSTANCE_RUNS");			
				System.out.println("while retrieving the step id from SQS_TEST_RESULT");
				System.out.println("while retrieving the data sets from SQS_TEST_DATASET");
				if (!TestAttributes.InitialSetUpErrorMessage.trim().equalsIgnoreCase(""))
					System.out.println("Please note there is also an initial setup error : " + TestAttributes.InitialSetUpErrorMessage.trim());
			}
			else{
				
			}
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void aftermethod()
	{
		endtest();
	}

	@AfterTest
	public void aftersuite()
	{	
		endflush();
		System.exit(TestAttributes.exitCode);
	}
	
	
	 @DataProvider(name="RunId")
     public static Object[][] getDataFromDataprovider(){
         return new Object[][] {
     
        		// regression pack 1
            /*
              { 183, "GetGo_Regression" },//GGP-Web-003_GetGo pay New Virtual card user Login with valid credentials
              { 184, "GetGo_Regression" },//GGP-Web-032_Virtual card Dashboard Page After Login      
 				{279, "	PackTwo" },//GGP-Web-058_Currency Conversion Page - Validation of invalid OTP 				
 	        	 { 261, "PackTwo" },//GGP-Web-053_Fund Tranfer Page with invalid value in amount field
 	        	 { 285, "PackTwo" },//GGP-Web-005_Fund Transfer Scenario Physical card-By Choosing Recipient Name 	        	
 	        	 { 290, "PackTwo" },//GGP-Web-010_Fund Transfer Scenario Virtual card-By Choosing Recipient Card number
 	        	 { 291, "PackTwo" },//GGP-Web-011_Fund Transfer Scenario Virtual card-By Entering Recipient Card number 	        	
 	        	 { 295, "PackTwo" },//GGP-Web-066_Fund Transfer by choosing the transaction date as future date 	        	
 	        	 { 298, "PackTwo" },//GGP-Web-069_Validation of Distribution Partners Page via Search Tool using Menu Option
 	        	 { 299, "PackTwo" },//GGP-Web-070_Edit Profile Page flow via Update Profile link in the Dashboard Page
 	        	 { 300, "PackTwo" },//GGP-Web-071_Currency Conversion page via Add currency button in the Dashboard Page
 	        	 { 301, "PackTwo" },//GGP-Web-072_Error Message validation - Addition of existing Recipient
 	        	 { 302, "PackTwo" },//GGP-Web-073_Scheduled Fund Transfer with Activity View Page
 	        	 { 303, "PackTwo" },//GGP-Web-074_Delete Scheduled Fund Transfer Activity
 	        	 */
 	        	
 	        	{ 320, "PackTwo" },//GGP-Web-022_FAQ 	        	
 	        	{ 321, "PackTwo" },//GGP-Web-024_Logout
 	        	{ 322, "PackTwo" },//GGP-Web-031_Transaction Activities - Fund Transfer
 	        	{ 323, "PackTwo" },//GGP-Web-040_Validation of Manage My Settings page - Physical user
 	        	{ 324, "PackTwo" },//GGP-Web-046_Edit Profile - Address Update-Present Address details

 	       	 
           };  
}

}