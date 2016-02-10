
public class PhoneNumberRotator 
{
	private int[] phoneNumber, boundaryValues;
	private char[][] rotationalValues;
	
	PhoneNumberRotator(String input)
	{

		phoneNumber = new int[input.length()];
		boundaryValues = new int[input.length()];
		rotationalValues = new char[input.length()][];

		for(int i = 0; i < input.length(); i++)
		{
			phoneNumber[i] = 11;
		}
		for(int j = 0; j < input.length(); j++)
		{
			phoneNumber[j] = Character.getNumericValue(input.charAt(j));
		}
		populateArrays();
		calculateBoundaries();
	}
	
	
	public int calculateTotalPermutations()
	{
		return boundaryValues[0] * (rotationalValues[0].length);
	}
	
	public String[] outputResult(int pagination, int pageNumber)
	{
		String[] outputPhoneNumbers = new String[pagination];
		for(int q = 0; q < outputPhoneNumbers.length; q++)
		{
			outputPhoneNumbers[q] = "";
		}
		int startNumber = (pageNumber -1)*pagination;
		int[] startPosition = new int[phoneNumber.length];
		
		for(int i = 0; i < phoneNumber.length; i++)
		{
			startPosition[i] = startNumber / boundaryValues[i];
			startNumber = startNumber % boundaryValues[i];
		}
		
		//Start counting out the phone numbers to be printed
		
		boolean notEnd = true;
		for(int j = 0; j < pagination && notEnd; j++)
		{
			for(int k = 0; k < phoneNumber.length; k++)
			{
				outputPhoneNumbers[j] += rotationalValues[k][startPosition[k]];
			}
			startPosition[startPosition.length - 1]++;
			// validate the position to ensure not out of bounds
			if(startPosition[startPosition.length - 1] >= rotationalValues[rotationalValues.length - 1].length)
			{
				for(int x = startPosition.length - 1; x > 0; x--)
				{
					if(startPosition[x] > rotationalValues[x].length - 1)
					{
						startPosition[x] = 0;
						startPosition[x -1]++;
					}
				}
				if(startPosition[0] > rotationalValues[0].length)
				{
					notEnd = false;
				}
			}
		}
		
		return outputPhoneNumbers;
	}
	
	private void calculateBoundaries()
	{
		for(int k = phoneNumber.length  - 1; k >= 0; k--)
		{
			int multiplied = 1;
			for(int l = k; l < phoneNumber.length - 1; l++)
			{
				multiplied = multiplied * (rotationalValues[l].length);
			}
			boundaryValues[k] = multiplied;
		}
	}
	
	private void populateArrays()
	{
		
		for(int i = 0; i < phoneNumber.length; i++)
		{
			switch(phoneNumber[i])
			{
				case 0:
					rotationalValues[i] = new char[]{'0'};
					break;
				case 1:
					rotationalValues[i] = new char[]{'1'};
					break;
				case 2:
					rotationalValues[i] = new char[]{'2', 'A', 'B', 'C'};
					break;
				case 3:
					rotationalValues[i] = new char[]{'3', 'D', 'E', 'F'};
					break;
				case 4:
					rotationalValues[i] = new char[]{'4', 'G', 'H', 'I'};
					break;
				case 5:
					rotationalValues[i] = new char[]{'5', 'J', 'K', 'L'};
					break;
				case 6:
					rotationalValues[i] = new char[]{'6', 'M', 'N', 'O'};
					break;
				case 7:
					rotationalValues[i] = new char[]{'7', 'P', 'Q', 'R', 'S'};
					break;
				case 8:
					rotationalValues[i] = new char[]{'8', 'T', 'U', 'V'};
					break;
				case 9:
					rotationalValues[i] = new char[]{'9', 'W', 'X', 'Y', 'Z'};
					break;					
			}
		}
	}

}
