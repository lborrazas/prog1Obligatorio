package uy.edu.um.fium.prog1.oblig.entidades;

public enum Lang{
	JAVA,
	NET,
	PYTHON,
	BASE_DE_DATOS ;

	public static Lang fromInteger(int x){
		Lang aux;
		switch (x){
			case 1: aux = JAVA;
			break;
			case 2: aux = NET;
			break;
			case 3: aux = PYTHON;
			break;
			case 4: aux = BASE_DE_DATOS;
			break;
			default: aux = null;
			break;
		}
		return aux;
	}
	
	public String toString(){
		switch(this){
			case JAVA: return "Java";
			case NET: return "Net";
			case PYTHON: return "Python";
			case BASE_DE_DATOS: return "Base de datos";
			default: throw new IllegalArgumentException();
		}
	}
	
	
}		

