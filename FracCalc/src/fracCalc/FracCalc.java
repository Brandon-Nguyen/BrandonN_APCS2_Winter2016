package fracCalc;

import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	
    	System.out.print("Enter a fraction string: ");
    	String fractionStr = input.nextLine();
    	
    	produceAnswer(fractionStr);

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	// TODO: Implement this function to produce the solution to the input
    	
    	//the user inputs the string with spaces in between 
    	//so the code splits the string by the spaces to get everything
    	String[] splitStr = input.split(" ");
    	String firstOperand = splitStr[0];
    	String operator = splitStr[1];
    	String secondOperand = splitStr[2];
        
    	//splitOperand(firstOperand);
        return splitOperand(secondOperand);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static String splitOperand(String operand){
    	String wholeNum = "0";
    	String numerator = "0";
    	String denominator = "0";
    	
    	if(operand.indexOf("/") == -1){
			return "whole:" + operand + " numerator:0 denominator:1";
		}
    		
    	if(operand.indexOf("_") != -1){
    		String [] underscoreSplit = operand.split("_");
    		wholeNum = underscoreSplit[0];
    		operand = underscoreSplit[1];
    		
    	}
    	
    	if(operand.length() >= 3){
    		String[] numOrDenom = operand.split("/");
    		numerator = numOrDenom[0];
    		denominator = numOrDenom[1];
    	}
    	System.out.println("whole:" + wholeNum + " numerator:" + numerator + " denominator:" + denominator);
    	return "whole:" + wholeNum + " numerator:" + numerator + " denominator:" + denominator;
    }
    
}

















