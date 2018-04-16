import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import View.Console;

public class DateFormater {
	public static LocalDate localDate(String msg) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = Console.scanString(msg);
        LocalDate data = LocalDate.parse(dataString,formatador);
		return data; 
	}
	public static LocalDateTime localDateTime(String msg) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        String dataString = Console.scanString(msg);
        LocalDateTime data = LocalDateTime.parse(dataString,formatador);
		return data; 
	}
}
	