package replaceLast;

public class replaceRegex {

	
	public static void main(String[] args) {
		
		String date = "20090604094900+0100";
		String txt = "Test %{Info:2} Period %{Start Date:6251} to %{End Date:6252}";
		
		
		System.out.println(txt.replaceAll("\\%\\{.*\\}", ""));
		
		System.out.println(date.replaceAll("\\+.*", ""));
		
	}
}
