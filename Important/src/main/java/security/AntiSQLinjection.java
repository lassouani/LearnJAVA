package security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AntiSQLinjection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String txt ="Dear Dr. Henry Leven: Thank you for referring Ms. Everywoman for evaluation. As\r\n" + 
				"										you know, she is a 40-year-old woman who has had chronic gastrointestinal\r\n" + 
				"										symptoms. Approximately 18 years ago, she was hospitalized with a bleeding\r\n" + 
				"										ulcer. She had a CT scan of the abdomen, which revealed findings consistent with\r\n" + 
				"										focal nodular hyperplasia (FNH). She has had epigastric abdominal pain as well\r\n" + 
				"										as a significant change in her bowel movements from baseline constipation to\r\n" + 
				"										frequent diarrhea. The past medical history is otherwise negative. She takes no\r\n" + 
				"										prescription medications. The remainder of the history is not contributory.";
		System.out.println(txt.trim());
		
		String r="";
		for (String str : txt.split("\r\n")) {
			str += str.trim();
			r=str;
		}
		
		System.out.println(r);
		
		PreparedStatement stmt = null;
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:3306:xe","system","oracle");  
			  
			stmt=con.prepareStatement("insert into Emp values(?,?)");  
			stmt.setInt(1,101);//1 specifies the first parameter in the query  
			stmt.setString(2,"Ratan");  
		
			stmt.executeQuery();
			
			stmt.close();
		}catch (Exception e) {
			
		}finally {
			if (stmt != null) {
				stmt.close();
			}
			
		}

	}
	
}
