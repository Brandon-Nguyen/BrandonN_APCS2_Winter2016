/**
 * 
 */

/**
 * @author APCS2
 *
 */
public class Calculate {
	public static int square(int number){
		return(number * number);
	}
	public static int cube(int number){
		return(number * number * number);
	}
	public static double average(double num1, double num2){
		return((num1 + num2) / 2.0);
	}
	public static double average(double num1, double num2, double num3){
		return((num1 + num2 + num3) / 3.0);
	}
	public static double toDegrees(double num){
		return((num * 180.0) / 3.14159);
	}
}
