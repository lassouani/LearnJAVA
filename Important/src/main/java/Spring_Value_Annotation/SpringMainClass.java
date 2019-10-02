package Spring_Value_Annotation;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("Spring_Value_Annotation");
		context.refresh();
		System.out.println("===========Refreshing the spring context===========");
		DBConnection dbConnection = context.getBean(DBConnection.class);

		dbConnection.printDBConfigs();
		
		// close the spring context
		context.close();
	}

}
