package model;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import view.Console;

public class DateFormater {
	public static LocalTime localTime(String msg) {
		LocalTime localTime = null;
		try{
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss[.fffffffff]");
        String dataString = Console.scanString(msg);
        localTime = LocalTime.parse(dataString,formatador);
		} catch (Exception e) {
			System.out.println("Formato de Hora Inválido!");
		}
		return localTime; 
	}
	public static LocalDateTime localDateTime() {
		return LocalDateTime.now(); 
	}
}
	