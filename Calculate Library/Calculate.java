// Brandon Nguyen, 2nd Period, 9/23/16

public class Calculate {
	// Squares the input number
	public static int square(int number) {
		return (number * number);
	}

	// Cubes the input number
	public static int cube(int number) {
		return (number * number * number);
	}

	// returns the average of the two numbers inputed
	public static double average(double num1, double num2) {
		return ((num1 + num2) / 2.0);
	}

	// returns the average of the three numbers inputed
	public static double average(double num1, double num2, double num3) {
		return ((num1 + num2 + num3) / 3.0);
	}

	// converts radians to degrees
	public static double toDegrees(double radian) {
		return ((radian * 180.0) / 3.14159);
	}

	// Converts degrees to radians
	public static double toRadians(double degrees) {
		return ((degrees * 3.14159) / 180.0);
	}

	// plugs in a, b, and c, into their places in the discriminant
	public static double discriminant(double a, double b, double c) {
		return ((b * b) - (4 * a * c));
	}

	// uses converts the fraction from a mixed fraction to an improper fraction
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
		return ("\"" + (wholeNum * denominator + numerator) + "/" + denominator + "\"");
	}

	// changes fraction from improper to mixed
	public static String toMixedNum(int numerator, int denominator) {
		return ("\"" + (numerator / denominator) + "_" + (numerator % denominator) + "/" + denominator + "\"");
	}

	// uses foil to multiply the binomials out
	public static String foil(int num1, int num2, int num3, int num4, String var) {
		int a = (num1 * num3);
		int b = ((num1 * num4) + (num2 * num3));
		int c = (num2 * num4);
		return ("\"" + a + var + "^2" + " + " + b + var + " + " + c + "\"");
	}

	// checks to see if the first number could be evenly divided by the second
	// number
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("num can't be zero.");
		}
		if (numerator % denominator == 0) {
			return true;
		} else {
			return false;
		}
	}

	// returns the absolute value of the input number
	public static double absValue(double num) {
		if (num > 0) {
			return (num);
		} else {
			return (num * -1);
		}
	}

	// returns the larger number between the two inputs
	public static int max(int num1, int num2) {
		if (num1 > num2) {
			return (num1);
		} else {
			return (num2);
		}
	}

	// returns the largest number between the three input numbers
	public static double max(double num1, double num2, double num3) {
		if (num1 > num2 && num1 > num3) {
			return (num1);
		} else if (num2 > num1 && num2 > num3) {
			return (num2);
		} else {
			return (num3);
		}
	}

	// reutrns the smallest number between the two input numbers
	public static int min(int num1, int num2) {
		if (num1 > num2) {
			return (num2);
		} else {
			return (num1);
		}
	}

	// rounds the input number to the smallest hundreds place
	public static double round2(double num) {
		if (num > 0) {
			num = num * 100 + .5;
		} else {
			num = num * 100 - .5;
		}
		return ((int) num / 100.0);
	}

	// multiplies the base by itself for how many times the exponent calls for
	public static double exponent(double base, int exponent) {
		if (exponent < 0) {
			throw new IllegalArgumentException("num can't be negative.");
		}
		double product = 1;
		for (int i = 1; i <= exponent; i++) {
			product = base * product;
		}
		return (product);
	}

	// starts from 1 and multiplies every number between one and the max inputed
	public static int factorial(int max) {
		if (max < 0) {
			throw new IllegalArgumentException("num can't be negative.");
		}
		int product = 1;
		for (int i = 1; i <= max; i++) {
			product = product * i;
		}
		return (product);
	}

	// checks to see if the number inputed can be divided by any number other
	// than itself and one
	public static boolean isPrime(int num) {
		boolean prime = true;
		for (int i = 2; i < num; i++) {
			if (Calculate.isDivisibleBy(num, i) == true) {
				prime = false;
			}
		}
		return prime;
	}

	// looks for the greatest common factor between the two numbers inputed
	public static int gcf(int num1, int num2) {
		int gcf = 1;
		int smallNum = Calculate.min(num1, num2);
		for (int i = 2; i < smallNum; i++) {
			if (Calculate.isDivisibleBy(num1, i) && Calculate.isDivisibleBy(num2, i) == true) {
				gcf = i;
			}
		}
		return gcf;
	}

	// finds the square root of the number to the hundreds place
	public static double sqrt(double square) {
		if (square < 0) {
			throw new IllegalArgumentException("num can't be negative.");
		}
		double squareRoot = 1;
		while (squareRoot * squareRoot > (square + .1) || squareRoot * squareRoot < (square - .1)) {
			while (squareRoot * squareRoot < square) {
				squareRoot = squareRoot + .01;
			}
			if (squareRoot * squareRoot > square) {
				squareRoot = squareRoot - .01;
			}
		}
		return (Calculate.round2(squareRoot));
	}

	// uses the quadratic formula to solve for the inputs of a, b, and c
	public static String quadForm(int a, int b, int c) {
		String answer = "";
		double discrim = Calculate.discriminant(a, b, c);
		if (discrim < 0) {
			return ("no real roots");
		}
		double answer1 = ((-b) + Calculate.sqrt(discrim)) / (2 * a);
		double answer2 = ((-b) - Calculate.sqrt(discrim)) / (2 * a);
		// if the answers are the same, then it only returns one answer, but if
		// they aren't
		// then it returns the smallest number before the larger number
		if (answer1 == answer2) {
			answer += answer1;
			return (answer);
		} else if (answer1 > answer2) {
			answer = "\"" + Calculate.round2(answer2) + " and " + Calculate.round2(answer1) + "\"";
			return (answer);
		} else {
			answer = "\"" + Calculate.round2(answer1) + " and " + Calculate.round2(answer2) + "\"";
			return (answer);
		}
	}
}