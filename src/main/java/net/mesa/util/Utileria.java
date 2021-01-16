package net.mesa.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();

		nombreOriginal.replace(" ", "-");
		
		//String nombreFinal = ramdomAlphaNumeric(2) + nombreOriginal;
	
		try {
		// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreOriginal);
			
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreOriginal;
		} catch (IOException e) {
			System.out.println("Error ocurriooooooooo" + e.getMessage());
			return null;
		}
	}
	
	public static String ramdomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder= new StringBuilder();
		while(count++ != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
}
