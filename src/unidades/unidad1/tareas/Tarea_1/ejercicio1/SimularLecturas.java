package unidades.unidad1.tareas.Tarea_1.ejercicio1;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimularLecturas {  //Genera 50 lecturas de sensores por salida estándar, una por línea, en formato CSV
	
	public static void main(String[] args) {

		System.out.println("sensorId;timestamp;valor");	//escribir cabecera CSV
		
		int contador = 1;
		
		Random aleatorio = new Random();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		while (contador < 51) {
					
			String sensorId = "S" + contador;  //Sacamos sensorId
			LocalDateTime fechaHoraActual = LocalDateTime.now();
			String timestamp = fechaHoraActual.format(formato);  //Sacamos fecha y hora (formateado)
			float valor = -50 + aleatorio.nextFloat() * (100 - (-50));    //Sacamos valores aleatorios
					
			System.out.println(sensorId+";"+timestamp+";"+valor);   //STDOUT - Salida
			
			contador++; //aumentar sensorId
			
			
		}//while
	
	}//main
	
}//class
