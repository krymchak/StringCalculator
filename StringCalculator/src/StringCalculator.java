import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	int Add(String numbers) throws NegativeException {
		ArrayList<String> delimiters = new ArrayList<String>(); // list of delimiters
		String delimiter = ""; // one delimiter
		ArrayList<Integer> negative = new ArrayList<Integer>(); // list of negative integer
		int sum = 0;
		if (numbers == "")
			return sum;
		if (numbers.contains("//")) {
			Pattern p = Pattern.compile("\\[(.*?)\\]"); // create pattern of delimiter
			Matcher m = p.matcher(numbers);
			if (m.find()) {
				delimiters.add(m.group(1)); // get delemiter from string
				while (m.find()) {
					delimiters.add(m.group(1));
				}
				int size = 0;
				for (String del : delimiters)
					size += del.length() + 2;
				numbers = numbers.substring(3 + size); // delete substring with delimeter from string
			} else { // if delimiter without square brackets
				delimiter = numbers.substring(2, 3); // get delemiter from string
				numbers = numbers.substring(4); // delete substring with delimeter from string
			}
		} else {
			delimiter = ",";
		}
		if (!delimiters.isEmpty()) { // create pattern of delimiters
			delimiter = delimiters.get(0);
			for (int i = 1; i < delimiters.size(); i++)
				delimiter += "|" + delimiters.get(i);
		}
		numbers = numbers.replaceAll("\n", delimiter);
		for (String retval : numbers.split(delimiter)) {
			int a = Integer.parseInt(retval);
			if (a < 0) {
				negative.add(a);
			} else {
				sum += a;
				sum = sum % 1001;
			}
		}
		if (!negative.isEmpty()) {
			throw new NegativeException("negatives not allowed : " + negative);
		}
		return sum;
	}

	public static void main(String args[]) {
		StringCalculator calculator = new StringCalculator();
		try {
			System.out.println(calculator.Add(""));
			System.out.println(calculator.Add("1"));
			System.out.println(calculator.Add("1,2"));
			System.out.println(calculator.Add("1,2,3"));
			System.out.println(calculator.Add("1,2,3,4"));
			System.out.println(calculator.Add("1,2\n3"));
			System.out.println(calculator.Add("//;\n1;2;3"));
			System.out.println(calculator.Add("//;\n1;2\n3"));
		} catch (NegativeException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calculator.Add("1,2,-3"));
			System.out.println(calculator.Add("//;\n1;2\n-3"));
		} catch (NegativeException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calculator.Add("//;\n1;2\n-3"));
		} catch (NegativeException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calculator.Add("1,2,-3,-4"));
		} catch (NegativeException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calculator.Add("1001,2"));
			System.out.println(calculator.Add("900,100,5"));
			System.out.println(calculator.Add("//[;;]\n1;;2;;3"));
			System.out.println(calculator.Add("//[;][:]\n1;2;3"));
			System.out.println(calculator.Add("//[;][:]\n1;2:3"));
			System.out.println(calculator.Add("//[;;][::]\n1;;2::3"));
		} catch (NegativeException e) {
			System.out.println(e.getMessage());
		}
	}
}
