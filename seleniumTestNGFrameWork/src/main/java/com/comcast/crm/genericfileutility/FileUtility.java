package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./configAppData/commonData.properties");
		Properties pobj = new Properties(); //help of this class we can load the data
		pobj.load(fis);  //load all keys
		String data = pobj.getProperty(key);  //capture data
		return data;   //return data to calling
	}

}
