package convertTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class convertDateToUTC {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		String dateStr = "2019-02-17T23:00:00Z";
		Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateStr);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		 TimeZone utc = TimeZone.getTimeZone("UTC");
		 dateFormatter.setTimeZone(utc);
		 
		 GregorianCalendar dateGreg = new GregorianCalendar(utc);

		 dateGreg.setTime(dateFormatter.parse(dateStr));
	      System.out.println("dateGreg "+dateGreg.getTime());
	     
	    
//	     String strDate = dateFormatter.format(dateGreg.getTime());
//	     System.out.println("Converted String: " + strDate);
	     
	     convert(dateGreg);
	     
	     dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String dateFormatted = dateFormatter.format(dateGreg.getTime()); 
		    // Displaying grogorian date ia SimpleDateFormat 
		    System.out.println("SimpleDateFormat _ 1: "+ dateFormatted); 
	        

	}
	
	public static void convert(GregorianCalendar gregorianCalendarDate) { 
	    // Creating an object of SimpleDateFormat 
	    SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); 
	    // Use format() method to change the format 
	    // Using getTime() method, 
	    // this required date is passed 
	    // to format() method 
	    String dateFormatted = formattedDate.format(gregorianCalendarDate.getTime()); 
	    // Displaying grogorian date ia SimpleDateFormat 
	    System.out.println("SimpleDateFormat: "+ dateFormatted); 
	    } 

}
