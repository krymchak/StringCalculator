public class StringCalculator {

	int Add(String numbers) {
		if (numbers == "")
			return 0;
		if (!numbers.contains(","))
			return Integer.parseInt(numbers);
		return Character.getNumericValue(numbers.charAt(0)) + Character.getNumericValue(numbers.charAt(2));
	}

	public static void main(String args[]) {
		StringCalculator calculator = new StringCalculator();
		System.out.println(calculator.Add(""));
		System.out.println(calculator.Add("1"));
		System.out.println(calculator.Add("1,2"));
	}
}
