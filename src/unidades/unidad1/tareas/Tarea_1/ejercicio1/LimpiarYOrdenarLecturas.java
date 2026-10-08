package unidades.unidad1.tareas.Tarea_1.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;


public class LimpiarYOrdenarLecturas {	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));  //Creo el lector
		String linea = lector.readLine();
		ArrayList<String[]> lecturas = new ArrayList<>();   //Creo ArrayList para ir guardando las lecturas
		
		while (linea != null) {
			
			if (!linea.equals("sensorId;timestamp;valor")) {
			
			//procesar línea
			String[] elementos = linea.split(";");   //Dividimos línea por elementos separados por ;
			if (elementos.length == 3){
				
				float valor = Float.parseFloat(elementos[2]);  //Convierto a número decimal
				
				String sensorId = elementos[0];						
				String timestamp = elementos[1];
					
				if (valor < -20 || valor > 60 ) {					
					//Valor descartado por fuera de rango				
				}//if
				
				else {
					float valorNormalizado = Math.round(valor * 100) / 100.0f;  //ajustar a dos decimales
					
					lecturas.add(new String[] {sensorId,timestamp,String.valueOf(valorNormalizado)});  //Guardo lectura
					
				}//else
				
			}//if
			else {
				//Lectura descartada por estar mal formada
			}//else
			
			}
			
			linea = lector.readLine();   //Condición para salir del bucle, ir leyendo líneas			
				
		}//while
			
		lecturas.sort((l1, l2) ->{                                      //Ordenamos por sensorId y en caso de empate por timestamp
			
			int sensor1 = Integer.parseInt(l1[0].substring(1));
			int sensor2 = Integer.parseInt(l2[0].substring(1));
			
			if (sensor1 != sensor2) {
				
				return Integer.compare(sensor1, sensor2);
				
			}//if
			
			return l1[1].compareTo(l2[1]);     //Comparamos los timestamp con compareTo
			
			
		});
		
		
		for (String[] lectura : lecturas) {
			
			System.out.println(lectura[0] + ";" + lectura[1] + ";" + lectura[2]);    //STDOUT mostrar salida
			
		}//for
	
	
	}//main
	
}//class
