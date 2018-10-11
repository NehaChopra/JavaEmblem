package Java8Features.Java8DateTimeAPI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalExample {

	public static void main(String[] args) {
		
		/****************************************************************LocalDate*****************************************************************************************/
		
		/*
		 *  Local date in ISO format (yyyy-MM-dd) without time
		 */
		
		LocalDate todayDate = LocalDate.now();
		System.out.println("Current local date: " + todayDate);
		//Current local date: 2018-10-11
		
		System.out.println("Year : " + todayDate.getYear() + "\nMonth : "+todayDate.getMonth() + "\nDay of month : "+todayDate.getDayOfMonth()+
				"\nDay of year : "+todayDate.getDayOfYear() + "\nDay of week : "+todayDate.getDayOfWeek());
		
		/*
		 * Year : 2018
			Month : OCTOBER
			Day of month : 11
			Day of year : 284
			Day of week : THURSDAY
		 */
		System.out.println("Next date in respective to Current local date: " + todayDate.plusDays(1));
		//Next date in respective to Current local date: 2018-10-12
	
		/*
		 * enum ChronoUnit implements TemporalUnit
		 */
		LocalDate nextWeek = todayDate.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next Week: "+nextWeek);
		//Next Week: 2018-10-18
		
		/*
		 * Period - between dates
		 */
		System.out.println("Period between 2 dates : "+Period.between(nextWeek, todayDate));
		//Period between 2 dates : P-7D
		
		/****************************************************************LocalTime*****************************************************************************************/
		
		
		/*
		 *  Local Time 
		 */
		
		LocalTime todayTime = LocalTime.now();
		System.out.println("Current local time: " + todayTime);
		//Current local time: 11:19:48.867
		
		System.out.println("Hour : " + todayTime.getHour() + "\nMIN : "+todayTime.getMinute() + "\nSEC : "+todayTime.getSecond());
		/*
		 * Hour : 11
			MIN : 19
			SEC : 48
		 */
		
		System.out.println("Next time in respective to Current local time: " + todayTime.plusHours(1));
		//Next time in respective to Current local time: 12:19:48.867
		
		/*
		 * enum ChronoUnit implements TemporalUnit
		 */
		LocalTime nextHour = todayTime.plus(1, ChronoUnit.HOURS);
		System.out.println("Next Hour: "+nextHour);
		//Next Hour: 12:48:08.828
		
		/*
		 * Duration - between time
		 */
		System.out.println("Duration between 2 time : "+Duration.between(nextHour, todayTime));
		//Duration between 2 time : PT-1H
		
		/*****************************************************************LocalDateTime****************************************************************************************/
		
		
		/*
		 *  Get the current date and time 
		 *  Local date and time, where time zone is not taken into count
		 *  Date and time format without accouting the timezone.
		 */
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Current local date and time: " + today);//Current local date and time: 2018-10-11T11:06:34.995
		
		System.out.println("Year : " + today.getYear() + "\nMonth : "+today.getMonth() + "\nDay of month : "+today.getDayOfMonth()+
				"\nDay of year : "+today.getDayOfYear() + "\nDay of week : "+today.getDayOfWeek());
		/*
		 * Year : 2018
			Month : OCTOBER
			Day of month : 11
			Day of year : 284
			Day of week : THURSDAY
		 */
		
		System.out.println("Next date time in respective to Current local date and time: " + today.plusDays(1));
		//Next date time in respective to Current local date and time: 2018-10-12T11:09:03.053
		
		/*
		 * enum ChronoUnit implements TemporalUnit
		 */
		LocalDateTime nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next Year: "+nextYear);
		//Next Year: 2019-10-11T11:48:08.832
		/*****************************************************************LocalDateTime****************************************************************************************/
	}
}
