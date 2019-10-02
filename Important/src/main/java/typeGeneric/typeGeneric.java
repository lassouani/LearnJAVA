package typeGeneric;

import java.util.ArrayList;
import java.util.List;

public class typeGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		List<Integer> m = new ArrayList<Integer>();
		m.add(0);
		m.add(1);
		
		personne p =new personne();
		p.setId("0");
		p.setNom("nome");
		p.setPrenom("presnom");
		p.setList(l);
		p.setList(m);
		
		for (Object str : p.getList()) {
			System.out.println(str.getClass().getSimpleName());
			System.out.println(str);
		}
		
		
		
		/*
		#############################################################
		#
		#
		#
		############################################################# */
			
		typeT<String, String> type =  new typeT<String, String>();
		type.setValeur1("ici");

	}

}
