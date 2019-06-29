public class StringCalculator {

	int Add(String numbers) {
		int sum = 0;
		if (numbers == "")
			return sum;
		numbers = numbers.replaceAll("\n", ",");
		for (String retval : numbers.split(",")) {
			sum += Integer.parseInt(retval);
		}
		return sum;
	}

	public static void main(String args[]) {
		StringCalculator calculator = new StringCalculator();
		System.out.println(calculator.Add(""));
		System.out.println(calculator.Add("1"));
		System.out.println(calculator.Add("1,2"));
		System.out.println(calculator.Add("1,2,3"));
		System.out.println(calculator.Add("1,2,3,4"));
		System.out.println(calculator.Add("1,2\n3"));
	}
}
