package convertTime;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class timesTamp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		String dateString = "2019-01-30T09:11:16Z";
		
		String d = "1548839476000";
		
		Date date1 = (Date) new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'").parse(d);
		
		System.out.println(date1);

	}

}
