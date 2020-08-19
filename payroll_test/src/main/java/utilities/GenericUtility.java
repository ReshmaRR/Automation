package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GenericUtility {
	
	  public static int createRandomnumber(int count) {

		Random rand = new Random();
		       // Generate random integers in range 0 to 999
		 int rand_int= rand.nextInt(count);
		  //System.out.println(rand_int);
		return(rand_int);
		}

		public static String createRandomString(int count) {

		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		    String s = "";
		    Random random = new Random();

		    for (int i = 0; i < count; i++) {
		        char c = alphabet.charAt(random.nextInt(26));
		        s+=c;
		    }
		    System.out.println(s);
		     return s;
		   
		}
		
		public static String currentDate() {
			
		SimpleDateFormat Dateformat= new SimpleDateFormat();
		String Date=Dateformat.format(new Date());
		System.out.println(Date);
		return Date;
		}


}
