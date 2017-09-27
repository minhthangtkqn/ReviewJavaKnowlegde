package pkc_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
//		Candidate candidate = new A1Candidate("name", 22, "Viet Nam", "BKDN");
//		candidate.display();
		
//		char str = 'á';
//		System.out.println(Integer.toHexString(str | 0x10000).substring(1));
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		
		//Get current time and format it
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
	}

	
}
