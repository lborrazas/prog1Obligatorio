package uy.edu.um.fium.prog1.oblig;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import uy.edu.um.fium.prog1.oblig.entidades.*;



public class Principal{	
	
	public static void createEmpleado(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Es el nuevo empleado profesional?");
		System.out.println("Ingrese Y (si) o N (no)");
		char prof = sc.next().charAt(0);
		boolean boolProf = false;
		if(prof == 'Y'){
			boolProf = true;
		}
		if(prof == 'N'){
			boolProf = false;
		}
		
		System.out.println("Ingrese Cedula del Empleado");
		int cedula = sc.nextInt();
		
		System.out.println("Ingrese Nombre del empleado");
		String nombre = sc.nextLine();
		
		System.out.println("Ingrese año, mes y dia de ingreso separados por /");
		String values1 = sc.nextLine();
		String[] values1Aux = values1.split("/");
		LocalDate fechaDeNacimiento = LocalDate.of(Integer.valueOf(values1Aux[0]), Integer.valueOf(values1Aux[1]), Integer.valueOf(values1Aux[2]));
		
		System.out.println("Ingrese año, mes y dia de ingreso separados por espacios");
		String values = sc.nextLine();
		String[] valuesAux = values.split(" ");
		LocalDate fechaDeIngreso = LocalDate.of(Integer.valueOf(valuesAux[0]),Integer.valueOf(valuesAux[1]),Integer.valueOf(valuesAux[2]));
		
		System.out.println("Ingrese anos de experiencia del empleado");
		int AExp = sc.nextInt();
		
		System.out.println(" Ingrese valores x/y donde x es el lenguaje que conoce e y su nivel de experiencia");
		System.out.println(" En caso de saber mas de un lenguaje ir separando con espacios");
		System.out.println("Lenguajes: Java = 1; Net = 2; Python = 3; Base De Datos = 4");
		System.out.println("Ejemplo: 0/3 2/2 3/1");
		
		String line = sc.nextLine();
		String[] vec = line.split(" ");
		
		 ArrayList <Lang> lenguajes = new ArrayList <>();
		 ArrayList <Exp> nivelDeClasificacion = new ArrayList <>();
		
		for (int i=0; i<vec.length; i++){
			String[] vecAux = vec[i].split("/"); // queda el vector  2 1 
			int numLang = Integer.valueOf(vecAux[0]);
			int numExp = Integer.valueOf(vecAux[1]);
			Lang auxLang = Lang.fromInteger(numLang);
			Exp auxExp = Exp.fromInteger(numExp);
			lenguajes.add(auxLang);
			nivelDeClasificacion.add(auxExp);
			
		}
		
		
		 if(!boolProf){
			 Empleado empleado = new Empleado(cedula, nombre, fechaDeNacimiento, fechaDeIngreso, AExp, lenguajes, nivelDeClasificacion);
		}
		
		if(boolProf){
			System.out.println("Ingrese su Titulo Universitario");
			String titulo = sc.nextLine();
			
			System.out.println("Ingrese su numero de Caja");
			int numCaja = sc.nextInt();
			
			Empleado profesional = new Profesional(cedula, nombre, fechaDeNacimiento, fechaDeIngreso, AExp, lenguajes, nivelDeClasificacion, titulo, numCaja); 
		}
	}

	public static void createFilter(Empresa emp){
		Scanner sc = new Scanner(System.in);
		System.out.println("Quiere filtrar solo profesionales");
		System.out.println("Ingrese Y (si) o N (no)");
		char prof = sc.next().charAt(0);
		boolean boolProf = false;
		if(prof == 'Y'){
			boolProf = true;
		}
		if(prof == 'N'){
			boolProf = false;
		}
		
		System.out.println(" Ingrese valores x/y donde x es el lenguaje que desea filtrar e y su nivel de experiencia");
		System.out.println(" En caso de querer filtrar mas de un lenguaje ir separando con espacios");
		System.out.println("Lenguajes: Java = 1; Net = 2; Python = 3; Base De Datos = 4");
		System.out.println("Ejemplo: 0/3 2/2 3/1");
		
		String line = sc.nextLine();
		String[] vec = line.split(" ");
		ArrayList <Lang> lenguajes  = new ArrayList<>();
		ArrayList <Exp> experience = new ArrayList<>();
		
		for (int i=0; i<vec.length; i++){
			String[] vecAux = vec[i].split("/"); // queda el vector  2 1 
			int numLang = Integer.valueOf(vecAux[0]);
			int numExp = Integer.valueOf(vecAux[1]);
			Lang auxLang = Lang.fromInteger(numLang);
			Exp auxExp = Exp.fromInteger(numExp);
			lenguajes.add(auxLang);
			experience.add(auxExp);
		}
		
		ArrayList <Empleado> auxEmps = emp.select(boolProf, lenguajes,experience);
		emp.display(auxEmps);
			
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean boolContinue = false; // Se usa al final del main para finalizar o seguir con el programa
		System.out.println("Ingrese el nombre de su empresa");
		Empresa emp = new Empresa(sc.nextLine());
		
		do{
		System.out.println("Si desea ingresar un nuevo empleado ingrese 1");
		System.out.println("Si desea ver todos los empleados ingrese 2");
		System.out.println("Si desea filtrar una lista de empleados ingrese 3");
		
		int numAux = sc.nextInt();
		switch (numAux){
			case 1: createEmpleado();
			break;
			case 2: emp.display();
			break;
			case 3: createFilter(emp);
			break;
		}
		
		System.out.println("Desea realizar otra operacion?");
		System.out.println("Ingrese Y (si) o N (no)");
		char cont = sc.next().charAt(0);
		
		if(cont == 'Y'){
			boolContinue = true;
		}
		if(cont == 'N'){
			boolContinue= false;
		}
	}
	while(boolContinue);
	}
}