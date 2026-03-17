package com.comcast.crm.genericfileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws IOException, ParseException
	{
		FileReader fileR = new FileReader("./configAppData/appCommonData.json"); //get java physical object
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fileR);//parse json file into actual java obj
		JSONObject map =(JSONObject)obj; //convert to key value so downcast
		String data =(String) map.get(key);
		return data;
	}

}
