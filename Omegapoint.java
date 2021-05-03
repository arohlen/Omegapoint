import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Omegapoint {
	public static void main(String[] args)  throws IOException
    {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

		PersonalNumberChecker pChecker = new PersonalNumberChecker();
		SamordningNumberChecker sChecker = new SamordningNumberChecker();
		OrganisationNumberChecker oChecker = new OrganisationNumberChecker();

        while (true) {

        	String personnummer = reader.readLine();

			personnummer = personnummer.replace(" ","");

        	if (pChecker.ValidityCheck(personnummer)) {
        		System.out.println("Valid personal number");
        	}

        	if (sChecker.ValidityCheck(personnummer)) {
        		System.out.println("Valid samordningsnumner");
        	}

        	if (oChecker.ValidityCheck(personnummer)) {
        		System.out.println("Valid organisation number");
        	}

    	}

	}

}
