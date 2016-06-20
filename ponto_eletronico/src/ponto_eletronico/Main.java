package ponto_eletronico;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm:ss");
		DateTime dt = formatter.parseDateTime("08:53:00");
		DateTime dt2 = formatter.parseDateTime("12:13:00");
		
		int minutes = Minutes.minutesBetween(dt, dt2).getMinutes();
	    long hours = minutes / 60;
	    long minnutesRemaining = minutes % 60;
	    
	    String manha = hours + ":" + minnutesRemaining + ":" + "00";

	    System.out.println("Periodo da manha = " + manha);
	    
	    DateTime dt3 = formatter.parseDateTime("13:53:00");
		DateTime dt4 = formatter.parseDateTime("18:56:00");
		
		minutes = Minutes.minutesBetween(dt3, dt4).getMinutes();
	    hours = minutes / 60;
	    minnutesRemaining = minutes % 60;
	    
	    String tarde = hours + ":" + minnutesRemaining  + ":" + "00";

	    System.out.println("Periodo da tarde = " + tarde);
	    
	    DateTime manhaDT = formatter.parseDateTime(manha);
	    manhaDT = manhaDT.plusMinutes(Integer.parseInt(tarde.split(":")[1]));
	    manhaDT = manhaDT.plusHours(Integer.parseInt(tarde.split(":")[0]));
	    
	    System.out.println("Somatorio = "+ formatter.print(manhaDT));
	}

}
