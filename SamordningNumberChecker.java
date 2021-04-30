import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SamordningNumberChecker extends PersonalNumberChecker{
	
	protected boolean checkDate(String personnummer) {
		
		personnummer = personnummer.replace("-", "").replace("+", "");
		
		int length = personnummer.length();
		
		String date = personnummer.substring(length-10,length-4);
		
		String year = date.substring(0,2);
		String month = date.substring(2,4);
		
		// Subtract 60 from day to get a regular date
		String day = String.valueOf(Integer.parseInt(date.substring(4,6))-60);
		
		date = year+month+day;
		
		DateFormat format = new SimpleDateFormat("yyMMdd");
		format.setLenient(false);
		
		// Check that the date is correct
		try {
            format.parse(date);
        } catch (ParseException e) {
            System.err.println("Invalid samordningsnummer: Invalid date");
            return false;
        }		
		
		return true;
	}
	
}
