package SeleniumPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverTestNG_Chrome extends TestAttributes {
	
	String browsername="Chrome";
	
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
            { 179, "GetGo_Regression" },//GGP-Web-001_Login Page Validation
             { 180, "GetGo_Regression" },//GGP-Web-002_Login Page validation with Invalid Credentials and Error Message
             { 181, "GetGo_Regression" },//GGP-Web-013_New Virtual card registration
             { 182, "GetGo_Regression" },//GGP-Web-029_Forgot Password
             { 183, "GetGo_Regression" },//GGP-Web-003_GetGo pay New Virtual card user Login with valid credentials
             { 184, "GetGo_Regression" },//GGP-Web-032_Virtual card Dashboard Page After Login
             { 185, "GetGo_Regression" },//GGP-Web-033_Physical card Dashboard Page After Login
             { 186, "GetGo_Regression" },//GGP-Web-004_GetGo pay New Physical card user Login with valid credential
             { 187, "GetGo_Regression" },//GGP-Web-016_Loading Partner via SEARCH LOADING PARTNERS link
             { 188, "GetGo_Regression" },//GGP-Web-007_Add a  new recipients and tag it as a favourite
             { 189, "GetGo_Regression" },//GGP-Web-008_Add a  new recipients, tag it as a favourite and delete it
             { 190, "GetGo_Regression" },//GGP-Web-009_Add a  new recipients, tag it as a favourite and update it
             { 191, "GetGo_Regression" },//GGP-Web-034_Loading Partner via Partners Menu Option
             { 194, "GetGo_Regression" },//GGP-Web-030_Transaction Activities - Physical user
             { 195, "GetGo_Regression" },//GGP-Web-035_Transaction Activities - Virtual User
             { 196, "GetGo_Regression" },//GGP-Web-036_Loading Partner using search tool via Partners Menu Option     
             { 197, "GetGo_Regression" },//GGP-Web-037_Loading Partner using search tool via SEARCH LOADING PARTNERS link
       

        	 //regression pack 2
        	
          	    {246, "PackTwo" },//GGP-Web-038_Verify Account Page - Manage My Settings option
				{247, "	PackTwo" },//GGP-Web-039_Verify Account Page with invalid Password - Manage My Settings option
				{248, "	PackTwo" },//GGP-Web-041_Validation of Manage My Settings page - Virtual user
				{249, "	PackTwo" },//GGP-Web-042_Edit Profile - Edit Mobile Number Update Page
				{250, "	PackTwo" },//GGP-Web-060_Edit Profile - Mobile number update with invalid data in mobile number field
				{276, "	PackTwo" },//GGP-Web-043_Edit Profile - Edit Mobile Number Update Page with OTP page validation
				{277, "	PackTwo" },//GGP-Web-044_Edit Profile - Edit Mobile Number Update Page with Invalid OTP details
				{253, "	PackTwo" },//GGP-Web-019_Edit Profile - Edit Mobile Number Update
				{254, "	PackTwo" },//GGP-Web-045_Edit Profile - Address Update Page Validation
				{255, "	PackTwo" },//GGP-Web-017_Edit Profile - Address Update-permanent and present
				{256, "	PackTwo" },//GGP-Web-047_Edit Profile - Other Details Update Page Validation
				{257, "	PackTwo" },//GGP-Web-018_Edit Profile - Other Details Update
				{264, "	PackTwo" },//GGP-Web-055_Currency Conversion Page Validation
				{265, "	PackTwo" },//GGP-Web-059_Currency Conversion Menu option is not displayed for virtual user
				{266, "	PackTwo" },//GGP-Web-056_Currency Conversion Page - Error Message
				{278, "	PackTwo" },//GGP-Web-057_Currency Conversion Page - Validation of  OTP page
				{279, "	PackTwo" },//GGP-Web-058_Currency Conversion Page - Validation of invalid OTP
				{269, "	PackTwo" },//GGP-Web-012_Currency Conversion PHP to USD
				{270, "	PackTwo" },//GGP-Web-048_Validation of More option Drop Down List
				{271, "	PackTwo" },//GGP-Web-021_Terms and Conditions
				{272, "	PackTwo" },//GGP-Web-023_Privacy Policy
				{273, "	PackTwo" },//GGP-Web-028_About the Cards
				{274, "	PackTwo" },//GGP-Web-027_Contact Us
				{275, "	PackTwo" },//GGP-Web-049_Profile Picture- Drop Down List Option-Manage settings and Logout
				
				{283, "	PackTwo" },//GGP-Web-061_virtual card registation with out email validation
				{284, "	PackTwo" },//GGP-Web-062_virtual card registation with out email validation with both present and permanent

			
			 //regression pack 3
				 { 258, "PackTwo" },//GGP-Web-050_Fund Transfer Page Validation
	        	 { 259, "PackTwo" },//GGP-Web-051_Fund Tranfer Page with invalid characters in recipient card number field
	        	 { 260, "PackTwo" },//GGP-Web-052_Fund Tranfer Page with recipient card number less than 16 digits
	        	 { 261, "PackTwo" },//GGP-Web-053_Fund Tranfer Page with invalid value in amount field
	        	 { 285, "PackTwo" },//GGP-Web-005_Fund Transfer Scenario Physical card-By Choosing Recipient Name
	        	 { 263, "PackTwo" },//GGP-Web-054_Fund Tranfer Page with invalid OTP details
	        	 { 287, "PackTwo" },//GGP-Web-006_Fund Transfer Scenario Physical card - By Entering Recipient Card number
	        	 { 290, "PackTwo" },//GGP-Web-010_Fund Transfer Scenario Virtual card-By Choosing Recipient Card number
	        	 { 291, "PackTwo" },//GGP-Web-011_Fund Transfer Scenario Virtual card-By Entering Recipient Card number
	        	 { 292, "PackTwo" },//GGP-Web-063_Fund Tranfer Page with Activity Page validation
	        	 { 293, "PackTwo" },//GGP-Web-064_Fund Transfer Page with Scheduled Transfer and Activity Page validation
	        	 { 294, "PackTwo" },//GGP-Web-065_Fund Transfer Page with Scheduled Transfer and Manage Scheduled Send Money Activity Page validation
	        	 { 295, "PackTwo" },//GGP-Web-066_Fund Transfer by choosing the transaction date as future date
	        	 { 296, "PackTwo" },//GGP-Web-067_Fund Transfer Error message validation with Zero Accout Balance
	        	 { 297, "PackTwo" },//GGP-Web-068_Validation of Distribution Partners Page via Menu Option
	        	 { 298, "PackTwo" },//GGP-Web-069_Validation of Distribution Partners Page via Search Tool using Menu Option
	        	 { 299, "PackTwo" },//GGP-Web-070_Edit Profile Page flow via Update Profile link in the Dashboard Page
	        	 { 300, "PackTwo" },//GGP-Web-071_Currency Conversion page via Add currency button in the Dashboard Page
	        	 { 301, "PackTwo" },//GGP-Web-072_Error Message validation - Addition of existing Recipient
	        	 { 302, "PackTwo" },//GGP-Web-073_Scheduled Fund Transfer with Activity View Page
	        	 { 303, "PackTwo" },//GGP-Web-074_Delete Scheduled Fund Transfer Activity
	        	 { 304, "PackTwo" },//GGP-Web-075_Validation of Distribution Partners Page via Find Distribution Partners link using Virtual user
	        	 { 305, "PackTwo" },//GGP-Web-076_Upgrade Virtual To Physical link in Dashboard
	        	 
	        	 { 313, "PackTwo" },//GGP-Web-077_Footer Link validation in Login page-About the Cards
	        	 { 314, "PackTwo" },//GGP-Web-078_Footer Link validation in Login page- About GetGo
	        	 { 315, "PackTwo" },//GGP-Web-079_Footer Link validation in Login page- FREQUENTLY ASKED QUESTIONS
	        	 { 316, "PackTwo" },//GGP-Web-080_Footer Link validation in Login page- TERMS AND CONDITIONS
	        	 { 317, "PackTwo" },//GGP-Web-081_Footer Link validation in Login page- PRIVACY POLICY
	        	 { 318, "PackTwo" },//GGP-Web-082_Footer Link validation in Login page- CONTACT US
		         { 319, "PackTwo" },//GGP-Web-083_Validation of Manage recipient search textbox
		         
		         { 320, "PackTwo" },//GGP-Web-022_FAQ 	        	
	 	         { 321, "PackTwo" },//GGP-Web-024_Logout
	 	         { 322, "PackTwo" },//GGP-Web-031_Transaction Activities - Fund Transfer
	 	         { 323, "PackTwo" },//GGP-Web-040_Validation of Manage My Settings page - Physical user
	 	         { 324, "PackTwo" },//GGP-Web-046_Edit Profile - Address Update-Present Address details
	
   
           };  
}

}