package practiceselenium4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class HandlePropertiesFile {

	public static void main(String[] args) throws IOException {


		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\test data\\config.properties");
		
		//Load the Property File
		Properties propertyfile = new Properties();
		propertyfile.load(file);
		
		//Read data from input File
		
		String url=propertyfile.getProperty("appurl");
		String user=propertyfile.getProperty("Username");
		String pass=propertyfile.getProperty("password");
		String custID=propertyfile.getProperty("customerid");
		String ag=propertyfile.getProperty("age");
		
		
		System.out.println(url+"	"+user+"	 "+pass+"	 "+custID+"	 "+ag);
		
		
		//Read keys
		Set<Object> keys=propertyfile.keySet();
		System.out.println(keys);
		
		//another method
		propertyfile.stringPropertyNames();
		
		//print values
		Collection<Object> vals=propertyfile.values();
		System.out.println(vals);
		
		file.close();


	}

}
