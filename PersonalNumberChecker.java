import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;


public class PersonalNumberChecker {

public boolean ValidityCheck(String personnummer) {
	return formatCheck(personnummer) && checkLuhnsNumber(personnummer) && checkDate(personnummer);
}

protected boolean checkLuhnsNumber(String personnummer) {

		int lastNumber  = Integer.parseInt(personnummer.substring(personnummer.length() - 1));

		personnummer = personnummer.replace("-", "").replace("+", "");

    	String dateBirthNumber = personnummer.substring(personnummer.length()-10,personnummer.length() - 1);

		int luhnsNumber = 0;

		for (int i = 0; i < dateBirthNumber.length(); i++){
		    char c = dateBirthNumber.charAt(i);

		    int num = Character.getNumericValue(c);

		    // How much the number is supposed to be multiplied with
		    int multiply = 2 - (i % 2);

		    int result = num * multiply;

		    luhnsNumber += result < 10 ? result : (result % 10) + 1;
		}

		luhnsNumber = (10 - (luhnsNumber % 10)) % 10;

		if (luhnsNumber != lastNumber) {
			System.err.println("Invalid: Last number is incorrect");
			return false;
		}

		return true;
	}

	protected boolean formatCheck(String personnummer) {

		// Match format with regex
		Pattern pattern = Pattern.compile("^[\\d]{6}(\\d\\d)?[-+]?[\\d]{4}");
		Matcher matcher = pattern.matcher(personnummer);

		if (!matcher.matches()) {
			System.err.println("Wrong format: Can only contain numbers and the following characters: \"-\" \"+\"");
			return false;
		}

		return true;
	}

	protected boolean checkDate(String personnummer) {
		personnummer = personnummer.replace("-", "").replace("+", "");

		int length = personnummer.length();

		String date = personnummer.substring(length-10,length-4);

		DateFormat format = new SimpleDateFormat("yyMMdd");
		format.setLenient(false);

		// Check that the date is correct
		try {
            format.parse(date);
        } catch (ParseException e) {
            System.err.println("Invalid personal number: Invalid date");
            return false;
        }

		return true;
	}

}
