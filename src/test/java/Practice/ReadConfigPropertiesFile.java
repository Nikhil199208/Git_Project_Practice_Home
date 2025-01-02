package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigPropertiesFile {

	public static void main(String[] args) throws IOException
	{
		Properties pro= new Properties();
		
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Config.properties");
		
		pro.load(fi);
		
		String url=pro.getProperty("appurl");
		String email=pro.getProperty("email");
		String password= pro.getProperty("password");
		String orderid = pro.getProperty("orderid");
		String customerid=pro.getProperty("orderid");
		
		System.out.println("app url:"+url+" "+"email:"+email+" "+"password:"+password+" "+"oredrid:"+" "+"customerid:"+" "+customerid);
		

	}

}