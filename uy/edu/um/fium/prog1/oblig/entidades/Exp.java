package uy.edu.um.fium.prog1.oblig.entidades;

public enum Exp{
	NO_CONOCE,
	JUNIOR,
	SEMI_SENIOR,
	SENIOR;
	
	public static Exp fromInteger(int x){
		Exp aux;
		switch (x){
			case 0: aux = NO_CONOCE;
			break;
			case 1: aux = JUNIOR;
			break;
			case 2: aux = SEMI_SENIOR;
			break;
			case 3: aux = SENIOR;
			break;
			default: aux = null;
			break;
		}
		return aux;
	}
	
	public String toString(){
		switch(this){
			case NO_CONOCE: return "Java";
			case JUNIOR: return "Net";
			case SEMI_SENIOR: return "Semi Senior";
			case SENIOR: return "Senior";
			default: throw new IllegalArgumentException();
		}
	}
}
