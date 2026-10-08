package unidades.unidad1.tareas.Tarea_1.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;


public class TransformarLecturas {
	
	public static void main(String[] args) throws IOException {
		
		String ficheroEntrada = args[0];
		String ficheroSalida = args[1];

		BufferedReader lector = new BufferedReader(new FileReader(ficheroEntrada));     //creo lector
		BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroSalida));
		String linea = lector.readLine();
		
		float umbral = 30.0f;   //umbral por defecto
		
		if (args.length > 2) {
			
			umbral = Float.parseFloat(args[2].split("=")[1]);
			
		}//if
		
		escritor.write(linea + ";estado");    //Escribe la cabecera
		escritor.newLine(); 
		
		linea = lector.readLine();   //Pasa a la primera línea de datos
		
		while (linea != null) {   //leer csv
			
			if (!linea.isEmpty()) {
			
			String elementos[] = linea.split(";");
			
			if (elementos.length == 3) {
			
			float valor = Float.parseFloat(elementos[2]);			
			
			if (valor >= umbral) {
		
				escritor.write(linea + ";" + "ALERTA");    //escribe
				escritor.newLine();                             //para que pase a la siguiente línea	
				
			}//if
			else {
				escritor.write(linea + ";" + "OK");
				escritor.newLine();
			}//else
			
			}
			}
			
			linea = lector.readLine();    //condición para salir del bucle
			
		}//while
	
		escritor.close();
		lector.close();      //Cerramos los Buffer
		
	}//main
	
}//class
