package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controlador {
	
	private File directorio; 
	
	public Controlador() {
	}
	
	public void Ruta(String ruta) {
		directorio = new File(ruta);
	}
	
	public String[] getArchivos(){
		return directorio.list();
	}
	
	public void Texto(String nombre, String texto){
	
		try {
			
			FileWriter archivo = new FileWriter(directorio.getAbsolutePath() + "/" + nombre, false);
			BufferedWriter contenido = new BufferedWriter(archivo);
			contenido.append(texto);
			contenido.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String Archivos(String nombre) {
		
		String resultado = "";
		
		try {
			
			FileReader archivo = new FileReader(directorio.getAbsolutePath() + "/" + nombre);
			BufferedReader contenido = new BufferedReader(archivo);
			String linea = "";
			
			while(linea != null) {
				resultado = resultado + linea + "\n";
				linea = contenido.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}
	
	public void ola() {
		
	}
}
