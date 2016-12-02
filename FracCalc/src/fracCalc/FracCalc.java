package fracCalc;

import java.util.Arrays;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	
	    System.out.print("Enter a fraction string: ");
	    String fractionString = input.nextLine();
	    
	    //checks to see if the input is quit
	    while (!fractionString.equals("quit")){
	    	System.out.println(produceAnswer(fractionString));
		    System.out.println();
		    //prompts for another input
		    System.out.print("Enter a fraction string: ");
		    fractionString = input.nextLine();
	    }
	    
	    

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
    	String[] splitInput = parseInput(input);
    	System.out.println(Arrays.toString(splitInput));
        
    	//Split the fraction into the whole number, numerator, and denominator
    	int[] firstOperand = parseOperand(splitInput[0]);
    	String operator = splitInput[1];
        int[] secondOperand = parseOperand(splitInput[2]);
        System.out.println(Arrays.toString(firstOperand));
        System.out.println(Arrays.toString(secondOperand));
        
        //convert from mixed number to improper fraction
        int[] firstFrac = toImproperFrac(firstOperand);
        int[] secondFrac = toImproperFrac(secondOperand);
        System.out.println(Arrays.toString(firstFrac));
        System.out.println(Arrays.toString(secondFrac));
        
        //decide whether to use add, subtract, divide or multiply
        if(operator.equals("+")){
        	System.out.println(Arrays.toString(addFrac(firstFrac, secondFrac)));
        }else if(operator.equals("-")){
        	System.out.println(Arrays.toString(subtractFrac(firstFrac, secondFrac)));
        }else if(operator.equals("*")){
        	multiplyFrac(firstFrac, secondFrac);
        }else{
        	divideFrac(firstFrac, secondFrac);
        }
        
        
        //convert back from improper fraction to a mixed number and reduce it
        return("testing");
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static String[] parseInput(String input){
    	String[] splitStr = input.split(" ");
    	return splitStr;
    }
    
    public static int[] parseOperand(String operand){
    	
    	//Initializes the varibles that will be returned later
    	int[] fracArr = {0, 0, 1};
    	
    	//checks to see if the operand is a fraction or just a whole number
    	if(operand.indexOf("/") == -1){
    		
    		//makes the whole number equal to the operand put into the method
    		fracArr[0] = Integer.parseInt(operand);
    		return fracArr;
		}
    	
    	//checks to see if the fraction has a whole number
    	if(operand.indexOf("_") != -1){
    		
    		//splits the array by the underscore to tell if the operand has a whole number or not
    		String [] underscoreSplit = operand.split("_");
    		
    		//assings the whole number to the corresponding variable
    		fracArr[0] = Integer.parseInt(underscoreSplit[0]);
    		
    		//changes operand so that it is only the fraction, without the whole number
    		operand = underscoreSplit[1];
    		
    	}
    	
    	//checks to see if the operand leftover is a fraction
    	if(operand.length() >= 3){
    		
    		//splits the operand or remainder of the fraction by the slash and 
    		//assings numerator and denominator
    		String[] numOrDenom = operand.split("/");
    		fracArr[1] = Integer.parseInt(numOrDenom[0]);
    		fracArr[2] = Integer.parseInt(numOrDenom[1]);
    	}
    	return fracArr;
    }
    
    public static int[] toImproperFrac(int[] operand) {
    	//set up array that will be returned later
    	int[] numDenom = new int[2];
    	//checking to see if the fraction is negative or positive
    	if(operand[0] == 0){
    		numDenom[0] = operand[1];
    	}else if(operand[0] < 0){
    		numDenom[0] = operand[0] * operand[2] - operand[1];
    	}else{
    		numDenom[0] = operand[0] * operand[2] + operand[1];
    	}
    	numDenom[1] = operand[2];
    	
    	return numDenom;
	}
    
    public static int[] addFrac(int[] firstOperand, int[] secondOperand){
    	int[] result = new int[2];
    	if(firstOperand[1] == secondOperand[1]){
    		result[0] = firstOperand[0] + secondOperand[0];
    		result[1] = firstOperand[1];
    	}else{
    		
    		firstOperand[0] = firstOperand[0] * secondOperand[1];
    		
    		secondOperand[0] = secondOperand[0] * firstOperand[1];
    		
    		result[0] = firstOperand[0] + secondOperand[0];
    		result[1] = firstOperand[1] * secondOperand[1];
    	}
    	
    	return result;
    }
    
    public static int[] subtractFrac(int[] firstOperand, int[] secondOperand){
    	secondOperand[0] = secondOperand[0] * -1;
    	return addFrac(firstOperand, secondOperand);
    }
    
    public static int[] multiplyFrac(int[] firstOperand, int[] secondOperand){
    	
    }
    
    public static int[] divideFrac(int[] firstOperand, int[] secondOperand){
    	
    }
    
    public static String toMixedNum(int[] improperFrac){
    	
    }
}