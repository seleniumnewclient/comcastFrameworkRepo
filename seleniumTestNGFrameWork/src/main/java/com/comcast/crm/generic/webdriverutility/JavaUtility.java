package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int randNumber = r.nextInt();
		return randNumber;
	}
	public String getSystemDateYYYYDDMM()
	{
		Date dateobj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String date = sdf.format(dateobj); //returns actual date
		return date;
	}
	public String getRequiredDateYYYYDDMM(int days)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate = sdf.format(cal.getTime());
		return reqdate;
	}
}
