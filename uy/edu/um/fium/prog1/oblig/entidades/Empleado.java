package uy.edu.um.fium.prog1.oblig.entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Empleado{
	
	private int cedula;
	private String nombre;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaDeIngreso;
	private int AExp; //Años de Experiencia
	private ArrayList <Lang> lenguajes = new ArrayList <>();
	private ArrayList <Exp> nivelDeClasificacion = new ArrayList <>();
	
	public Empleado(int cedula, String nombre, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso,
			int AExp, ArrayList <Lang> lenguajes,ArrayList <Exp> nivelDeClasificacion){ 
			
			this.cedula  = cedula;
			this.nombre = nombre;
			this.fechaDeNacimiento = fechaDeNacimiento;
			this.fechaDeIngreso = fechaDeIngreso;
			this.AExp = AExp;
			this.lenguajes = lenguajes;
			this.nivelDeClasificacion = nivelDeClasificacion;
	}
	
	public int getCedula(){
		int aux = this.cedula;
		return aux;
	}
	
	public ArrayList <Lang> getLenguajes(ArrayList <Lang> lenguajes){
		ArrayList <Lang> aux = this.lenguajes;
		return aux;
	}	

	public ArrayList <Exp> getNivelDeClasificacion(ArrayList <Exp> nivelDeClasificacion){
		ArrayList <Exp> aux = this.nivelDeClasificacion;
		return aux;
	}

	public void displayEmpleado(){
		System.out.println(" Nombre " + this.nombre );
		for (int i=0; i< this.lenguajes.size(); i++){
			System.out.println("lenguaje " + lenguajes.get(i).toString() + ": " + nivelDeClasificacion.get(i).toString());		
	}
	}

	public boolean checkFilter(Lang lang, Exp exp){
		boolean aux = false;
		for (int i = 0; i<this.lenguajes.size(); i++){
			if( lenguajes.get(i).equals(lang) && nivelDeClasificacion.get(i).equals(exp)){
				aux = true;
			}
		}
		return aux;
	}

		
}