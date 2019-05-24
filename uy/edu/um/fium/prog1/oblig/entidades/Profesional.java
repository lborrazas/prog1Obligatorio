package uy.edu.um.fium.prog1.oblig.entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Profesional
		extends Empleado{
			
			private String titulo;
			private int numCaja;
			
			public Profesional(int cedula, String nombre, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso,
					int AExp, ArrayList <Lang> lenguajes,ArrayList <Exp> nivelDeClasificacion, String titulo, int numCaja){
				
				super(cedula, nombre, fechaDeNacimiento, fechaDeIngreso, AExp, lenguajes, nivelDeClasificacion);
				this.titulo = titulo;
				this.numCaja = numCaja;
			
			}
		}