package Java8Features.Java8DateTimeAPI;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedExample {

	public static void main(String[] args) {
		
		/****************************************************************ZonedDateTime*****************************************************************************************/
		
		/*
		 *  ZonedDateTime date and time accounting the timezone also.
		 */
		ZonedDateTime today = ZonedDateTime.now();
		System.out.println("Current ZonedDateTime : " + today);
		//Current ZonedDateTime : 2018-10-11T11:36:11.773+05:30[Asia/Kolkata]

		Set<String> zones = ZoneId.getAvailableZoneIds();
		for(String id: zones) {
			System.out.print(id+ " , ");
		}
		System.out.println();
		/*
		 * Available zones : 
		 * Asia/Aden , America/Cuiaba , Etc/GMT+9 , Etc/GMT+8 , Africa/Nairobi , America/Marigot , Asia/Aqtau , Pacific/Kwajalein , America/El_Salvador , 
		 * Asia/Pontianak , Africa/Cairo , Pacific/Pago_Pago , Africa/Mbabane , Asia/Kuching , Pacific/Honolulu , Pacific/Rarotonga , America/Guatemala , 
		 * Australia/Hobart , Europe/London , America/Belize , America/Panama , Asia/Chungking , America/Managua , America/Indiana/Petersburg , Asia/Yerevan , 
		 * Europe/Brussels , GMT , Europe/Warsaw , America/Chicago , Asia/Kashgar , Chile/Continental , Pacific/Yap , CET , Etc/GMT-1 , Etc/GMT-0 , 
		 * Europe/Jersey , America/Tegucigalpa , Etc/GMT-5 , Europe/Istanbul , America/Eirunepe , Etc/GMT-4 , America/Miquelon , Etc/GMT-3 , 
		 * Europe/Luxembourg , Etc/GMT-2 , Etc/GMT-9 , America/Argentina/Catamarca , Etc/GMT-8 , Etc/GMT-7 , Etc/GMT-6 , Europe/Zaporozhye , 
		 * Canada/Yukon , Canada/Atlantic , Atlantic/St_Helena , Australia/Tasmania , Libya , Europe/Guernsey , America/Grand_Turk , US/Pacific-New , 
		 * Asia/Samarkand , America/Argentina/Cordoba , Asia/Phnom_Penh , Africa/Kigali , Asia/Almaty , US/Alaska , Asia/Dubai , Europe/Isle_of_Man , 
		 * America/Araguaina , Cuba , Asia/Novosibirsk , America/Argentina/Salta , Etc/GMT+3 , Africa/Tunis , Etc/GMT+2 , Etc/GMT+1 , Pacific/Fakaofo , 
		 * 
		 * etc................
		 */
	
		ZoneId defaultSystemZone = ZoneId.systemDefault();
      System.out.println("defaultSystemZone: " + defaultSystemZone);
      //defaultSystemZone: Asia/Kolkata
	}
}
