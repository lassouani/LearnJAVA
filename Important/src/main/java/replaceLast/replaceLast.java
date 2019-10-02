package replaceLast;

public class replaceLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String docId = "Dr ALLAN JOSEPH ";
		System.out.println(docId);
		System.out.println(docId.length());
		
		String h = docId.replaceAll(" $","");
		
		System.out.println(h);
		System.out.println(h.length());
		
		
		// méthode 2
		StringBuffer buffer = new StringBuffer(docId);
		docId = buffer.reverse().toString().replaceFirst(" ","");
		docId = new StringBuffer(docId).reverse().toString();
		System.out.println(docId);
		
	}

}
