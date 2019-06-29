public class StringCalculator {

	int Add(String numbers) {
		String delimiter = ",";
		int sum = 0;
		if (numbers == "")
			return sum;
		if (numbers.contains("//")) {
			delimiter = numbers.substring(2, 3); // get delemiter from string
			numbers = numbers.substring(4); // delete substring with delimeter from string
		}
		numbers = numbers.replaceAll("\n", delimiter);
		for (String retval : numbers.split(delimiter)) {
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
		System.out.println(calculator.Add("//;\n1;2;3"));
		System.out.println(calculator.Add("//;\n1;2\n3"));

	}
}
