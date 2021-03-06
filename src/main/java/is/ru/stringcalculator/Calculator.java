package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
	{
		if(text.contains("-"))
		{
			negativeNumbers(text);
		}

		if(text.equals(""))
		{
			return 0;
		}
		else if(text.contains("//"))
		{
			return sum(newDelimeter(text));
		}
		else if(text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}
		else
		{
			return 1;
		}
	}


	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
	    return numbers.split(",|\n");
	}

	private static String[] newDelimeter(String numbers)
	{
		String newDelimeter = numbers.substring(2,3);
		numbers = numbers.substring(3);
		numbers = numbers.replaceAll("\n","");
		numbers = numbers.replaceAll(newDelimeter,",");

		return numbers.split(",");
	}

	private static void negativeNumbers(String numbers) throws IllegalArgumentException
	{
		String[] text = numbers.split("-");
		String message = "Negatives not allowed: ";
		for(int i = 1; i < text.length; i++)
		{
			message = message + "-" + text[i].substring(0,1);
			if(i < text.length - 1)
			{
				message = message + ",";
			}
		}
	}

    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for(String number : numbers)
        {
        	if(toInt(number) <= 1000)
        	{
        		total = total + toInt(number);
        	}
		}
		return total;
    }
}