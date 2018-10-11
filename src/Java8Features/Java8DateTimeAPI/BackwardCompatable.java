package Java8Features.Java8DateTimeAPI;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class BackwardCompatable {

	public static void main(String[] args) {
		/*
		 * toInstant() method is added to the original Date and Calendar objects.
		 */
		Date todayDate = new Date();
		System.out.println("Today Date: "+todayDate);
		//Today Date: Thu Oct 11 12:36:20 IST 2018
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(todayDate.toInstant(), ZoneId.systemDefault());
		System.out.println("localDateTime : "+localDateTime);
		//localDateTime : 2018-10-11T12:36:20.379
		
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(todayDate.toInstant(), ZoneId.systemDefault());
		System.out.println("zonedDateTime : "+zonedDateTime);
		//zonedDateTime : 2018-10-11T12:36:20.379+05:30[Asia/Kolkata]
	}
}
