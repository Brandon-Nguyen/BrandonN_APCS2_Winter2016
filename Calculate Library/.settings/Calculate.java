/**
 * 
 */

/**
 * @author APCS2
 *
 */
public class Calculate {
	public static int square(int number) {
		return (number * number);
	}

	public static int cube(int number) {
		return (number * number * number);
	}

	public static double average(double num1, double num2) {
		return ((num1 + num2) / 2.0);
	}

	public static double average(double num1, double num2, double num3) {
		return ((num1 + num2 + num3) / 3.0);
	}

	public static double toDegrees(double num) {
		return ((num * 180.0) / 3.14159);
	}

	public static double toRadians(double num) {
		return ((num * 3.14159) / 180.0);
	}

	public static double discriminant(double num1, double num2, double num3) {
		return ((num2 * num2) - (4 * num1 * num3));
	}

	public static String toImproperFrac(int num1, int num2, int num3) {
		return ("\"" + (num1 * num3 + num2) + "/" + num3 + "\"");
	}

	public static String toMixedNum(int num1, int num2) {
		return ("\"" + (num1 / num2) + "_" + (num1 % num2) + "/" + num2 + "\"");
	}

	public static String foil(int num1, int num2, int num3, int num4, String var) {
		int a = (num1 * num3);
		int b = ((num1 * num4) + (num2 * num3));
		int c = (num2 * num4);
		return ("\"" + a + var + "^2" + b + var + c + "\"");
	}
}
