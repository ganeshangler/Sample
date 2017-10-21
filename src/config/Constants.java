package config;

public class Constants 
{
    	
	public static String getPath_TestData=System.getProperty("user.dir")+"\\src\\dataEngine\\";
	public static final String Path_TestData = getPath_TestData.replace("\\", "\\\\");
			
	public static final String File_TestData = "TestData1.xls";
	public static String getPath_ObjectRepo=System.getProperty("user.dir")+"\\ObjectRepo.properties";
	public static final String path_ObjectRepo=getPath_ObjectRepo.replace("\\", "\\\\");

	public static final String File_LoginTestsheet_name="Login_Data";	
	
	public static final String Login_Username="admin@angleritech.com";
	public static final String Login_Password="angler*#1400";

}
