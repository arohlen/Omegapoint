
public class OrganisationNumberChecker extends PersonalNumberChecker{

	
	protected boolean checkDate(String personnummer) {
		
		personnummer = personnummer.replace("-", "").replace("+", "");
		
		int length = personnummer.length();
		
		if (length == 12 && Integer.parseInt(personnummer.substring(0,2)) != 16) {
			System.err.println("Invalid organisation number: Invalid date");
			return false;
		}
		
		String date = personnummer.substring(length-10,length-4);
		
		int month = Integer.parseInt(date.substring(2,4));
		
		if (month < 20) 
		{
			System.err.println("Invalid organisation number: Invalid date");
			return false;
		}
	
		
		return true;
	}
}
