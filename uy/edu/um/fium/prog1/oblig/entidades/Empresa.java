package uy.edu.um.fium.prog1.oblig.entidades;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Empresa{
	
	private String name;
	
	private ArrayList <Empleado> empleados = new ArrayList <>();
	//size tamano del arraylist
	
	public Empresa(String name){
		this.name = name;
	}
	
	public void nuevoEmpleado(int cedula, String nombre, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso,
			int AExp, ArrayList <Lang> lenguajes,ArrayList <Exp> nivelDeClasificacion){
				Empleado empleado = new Empleado(cedula, nombre, fechaDeNacimiento, fechaDeIngreso, AExp, lenguajes, nivelDeClasificacion);
			empleados.add(empleado);
			}
			
	public ArrayList <Empleado> select (boolean boolProf, ArrayList <Lang> lenguajes,ArrayList <Exp> nivelDeClasificacion){
		ArrayList <Empleado> aux = new ArrayList <>();
		
		int checkCounter = 0;
		for (int i=0; i<empleados.size(); i++){
			 if( empleados.get(i) instanceof Profesional == boolProf){ // boolProf es si es prof o no
				 for(int j=0; i<lenguajes.size(); j++){
					 if(empleados.get(i).checkFilter(lenguajes.get(j), nivelDeClasificacion.get(j))){
						 checkCounter++;
					 }
				 }
				 if (checkCounter == lenguajes.size()){
					 aux.add(empleados.get(i)); //ESTO ES LINDO
				 }
			 }
		}
	return aux;
	}
	
	public void display(){
		
		System.out.println("Empleados pertenecientes a " + this.name);
		for(int i=0; i<empleados.size(); i++){
			System.out.print( i + " ");
			empleados.get(i).displayEmpleado();
		}
	}
	
	public void display(ArrayList <Empleado> select){
		for(int i=0; i<select.size(); i++){
			System.out.print( i + " ");
			select.get(i).displayEmpleado();
		}
	}
		
		
								
}
		
	
