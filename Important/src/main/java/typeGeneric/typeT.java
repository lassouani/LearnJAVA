package typeGeneric;

public class typeT<T, S> {
	
	private T valeur1;

	private S valeur2;
	
	
	//Retourne la valeur T
	  public T getValeur1() {
	    return valeur1;
	  }
	 
	  //Définit la valeur T
	  public void setValeur1(T valeur1) {
	    this.valeur1 = valeur1;
	  }
	 
	  //Retourne la valeur S
	  public S getValeur2() {
	    return valeur2;
	  }
	 
	  //Définit la valeur S
	  public void setValeur2(S valeur2) {
	    this.valeur2 = valeur2;
	  }      

}
