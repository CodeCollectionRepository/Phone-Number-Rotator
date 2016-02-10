import java.util.Scanner;

public class PhoneNumberInterface {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Welcome to the phone number rotator program.");
		System.out.println("Enter a 7 or 10 digit phone number without dashes or paranthesis: ");
		String number = reader.nextLine();

		PhoneNumberRotator engine = new PhoneNumberRotator(number);

		int variations = engine.calculateTotalPermutations();		
		System.out.println("The number you entered has " + variations + " potential permutations.");
		System.out.println("How many results would you like to see at once?");
		int entryNumber = reader.nextInt();
		
		int totalPages = variations / entryNumber;
		int page = 1;
		boolean keepGoing = true;

		while(keepGoing)
		{

			String[] results = engine.outputResult(entryNumber, page);
			for(int i = 0; i < results.length; i ++)
			{
				System.out.println(results[i]);
			}

			System.out.println("Page " + page + " out of " + totalPages);
			System.out.println("/n");
			System.out.println("Press 1 to view the next " + entryNumber + " results");
			System.out.println("Press 2 to change the number of results appearing at once" + 
					" (Warning: This will reset your position to the first page!)");
			System.out.println("Press 9 to exit the program");
			int whatDo = reader.nextInt();
			
			if(whatDo == 1)
			{
				page++;
			}
			else if(whatDo == 2)
			{
				page = 1;
				System.out.println("Please enter how many results you would like to see at once: ");
				entryNumber = reader.nextInt();
				totalPages = variations/entryNumber;
			}
			else if(whatDo == 9)
			{
				keepGoing = false;
			}
			else
			{
				System.out.println("Invalid number entered! Printing the next set of numbers");
			}
			
		}
		
		System.out.println("Thank you for using Phone Number Rotator program. Good bye.");
		reader.close();

	}

}
