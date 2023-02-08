package rahulshettypackage.PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Fileconnection {

	static File file = new File("C:\\Users\\UdithRapolu\\OneDrive - ValueMomentum, Inc\\Documents\\Maven\\rahulshetty\\src\\test\\java\\rahulshettypackage\\PageObject\\rahulshettylogindetail");
	static Properties prop;
	public Fileconnection() {
		try {
			
			FileInputStream fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(file.exists())
			{
				System.out.println("file is connected");
			}else {
				System.out.println("file is not connect");
			}
		}
	}
		public String geturl()
		{
			return prop.getProperty("Url");
		}
		
		public String getusernamre()
		{
			return prop.getProperty("Username");
		}
		public String getpassword()
		{
			return prop.getProperty("Password");
		}
	
	
}
